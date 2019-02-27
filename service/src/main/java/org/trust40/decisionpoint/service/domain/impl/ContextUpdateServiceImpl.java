package org.trust40.decisionpoint.service.domain.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.trust40.decisionpoint.api.dto.ContextDescription;
import org.trust40.decisionpoint.service.domain.ContextUpdateService;
import org.trust40.decisionpoint.service.domain.EnsembleService;
import org.trust40.decisionpoint.service.domain.event.EnsembleResultsInvalidatedEvent;

@Service
public class ContextUpdateServiceImpl implements ContextUpdateService {

	private final ExecutorService executor = Executors.newSingleThreadExecutor();
	private final List<ContextDescription> pendingContextUpdates = new ArrayList<>();
	private final EnsembleService ensembleService;
	private final ApplicationEventPublisher applicationEventPublisher;
	
	@Autowired
	public ContextUpdateServiceImpl(EnsembleService ensembleService, ApplicationEventPublisher applicationEventPublisher) {
		this.ensembleService = ensembleService;
		this.applicationEventPublisher = applicationEventPublisher;
		executor.execute(this::processUpdatesLoop);
	}
	
	@Override
	public boolean update(ContextDescription description) {
		synchronized(pendingContextUpdates) {
			boolean queueResult = pendingContextUpdates.add(description);
			pendingContextUpdates.notifyAll();
			return queueResult;			
		}
	}
	
	protected void processUpdatesLoop() {
		try {
			while (true) {
				processAllPendingUpdates();
			}			
		} catch (InterruptedException e) {
			return;
		}
	}

	private void processAllPendingUpdates() throws InterruptedException {
		List<ContextDescription> queue = drainPendingUpdates();
		if (!queue.isEmpty()) {
			synchronized (ensembleService) {
				queue.stream().forEach(ensembleService::processContextUpdate);
				applicationEventPublisher.publishEvent(new EnsembleResultsInvalidatedEvent(this));
			}
		}
	}

	private List<ContextDescription> drainPendingUpdates() throws InterruptedException {
		synchronized(pendingContextUpdates) {
			while(pendingContextUpdates.isEmpty()) {
				pendingContextUpdates.wait();
			}
			List<ContextDescription> queue = new ArrayList<>();
			queue.addAll(pendingContextUpdates);
			pendingContextUpdates.clear();
			return queue;
		}
	}
	
}
