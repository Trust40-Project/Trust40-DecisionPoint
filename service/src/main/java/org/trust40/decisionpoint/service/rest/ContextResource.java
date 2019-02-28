package org.trust40.decisionpoint.service.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.trust40.decisionpoint.api.IContextUpdate;
import org.trust40.decisionpoint.api.dto.ContextDescription;
import org.trust40.decisionpoint.api.dto.ContextUpdateSchedulingStatus;
import org.trust40.decisionpoint.service.domain.ContextUpdateService;

@RestController
public class ContextResource implements IContextUpdate {

	private static final Logger LOGGER = LoggerFactory.getLogger(ContextResource.class);
	private final ContextUpdateService contextUpdateService;
	
	@Autowired
	public ContextResource(ContextUpdateService contextUpdateService) {
		this.contextUpdateService = contextUpdateService;
	}
	
	@Override
	@RequestMapping(method=RequestMethod.POST, value="/context")
	public ContextUpdateSchedulingStatus update(ContextDescription description) {
		LOGGER.info("Received context update request {}.", description);
		ContextUpdateSchedulingStatus response = new ContextUpdateSchedulingStatus();
		response.setScheduled(contextUpdateService.update(description));
		return response;
	}

}
