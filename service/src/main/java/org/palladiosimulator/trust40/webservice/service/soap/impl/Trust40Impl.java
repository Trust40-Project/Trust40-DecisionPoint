package org.palladiosimulator.trust40.webservice.service.soap.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import de.cas.trust40.ws.ObjectFactory;
import de.cas.trust40.ws.ShareRequestDescription;
import de.cas.trust40.ws.ShareRequestResponse;
import de.cas.trust40.ws.Trust40WebService;

@Component
public class Trust40Impl implements Trust40WebService {

	private static final Logger LOGGER = LoggerFactory.getLogger(Trust40Impl.class);
	private final ObjectFactory objectFactory = new ObjectFactory();
	
	@Override
	public ShareRequestResponse canShare(ShareRequestDescription shareRequestDescription) {
		
		LOGGER.info("Received request:\n{}", shareRequestDescription);
		
		ShareRequestResponse response = objectFactory.createShareRequestResponse();
		response.setCanShare(true);
		LOGGER.info("Answerting with default answer:{}", response);
		
		return response;
	}
	
}
