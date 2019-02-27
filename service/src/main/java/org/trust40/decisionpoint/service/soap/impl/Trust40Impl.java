package org.trust40.decisionpoint.service.soap.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.trust40.decisionpoint.service.domain.DecisionService;

import de.cas.trust40.ws.ObjectFactory;
import de.cas.trust40.ws.ShareRequestDescription;
import de.cas.trust40.ws.ShareRequestResponse;
import de.cas.trust40.ws.Trust40WebService;

@Component
public class Trust40Impl implements Trust40WebService {

	private static final Logger LOGGER = LoggerFactory.getLogger(Trust40Impl.class);
	private final ObjectFactory objectFactory = new ObjectFactory();
	private final DecisionService decisionService;
	
	public Trust40Impl(DecisionService decisionService) {
		this.decisionService = decisionService;
	}
	
	@Override
	public ShareRequestResponse canShare(ShareRequestDescription shareRequestDescription) {
		
		LOGGER.info("Received request:\n{}", shareRequestDescription);
		
		ShareRequestResponse response = objectFactory.createShareRequestResponse();
		response.setCanShare(decisionService.canShare(shareRequestDescription));
		LOGGER.info("Answering with answer:{}", response);
		
		return response;
	}
	
}
