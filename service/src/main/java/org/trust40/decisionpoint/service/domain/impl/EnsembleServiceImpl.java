package org.trust40.decisionpoint.service.domain.impl;

import java.util.Collection;
import java.util.Collections;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.trust40.decisionpoint.api.dto.ContextDescription;
import org.trust40.decisionpoint.service.domain.EnsembleService;
import org.trust40.decisionpoint.service.domain.dto.Rule;

@Service
public class EnsembleServiceImpl implements EnsembleService {

	private static final Logger LOGGER = LoggerFactory.getLogger(EnsembleServiceImpl.class);
	
	@Override
	public void processContextUpdate(ContextDescription contextUpdate) {
		LOGGER.info("Received context update {}", contextUpdate);
		// TODO Ensembles updates
	}

	@Override
	public Collection<Rule> recalculate() {
		LOGGER.info("Recalculation triggered.");
		// TODO Ensembles solving
		return Collections.emptySet();
	}

}
