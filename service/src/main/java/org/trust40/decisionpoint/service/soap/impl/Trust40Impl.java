package org.trust40.decisionpoint.service.soap.impl;

import javax.jws.WebService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.trust40.decisionpoint.service.domain.DecisionService;
import org.trust40.trust40webservice.ObjectFactory;
import org.trust40.trust40webservice.ShareRequest;
import org.trust40.trust40webservice.ShareRequestResponse;
import org.trust40.trust40webservice.Trust40WebService;


@Component
@WebService(targetNamespace = "http://trust40.org/Trust40WebService/")
public class Trust40Impl implements Trust40WebService {

	private static final Logger LOGGER = LoggerFactory.getLogger(Trust40Impl.class);
	private final ObjectFactory objectFactory = new ObjectFactory();
	private final DecisionService decisionService;
	
	public Trust40Impl(DecisionService decisionService) {
		this.decisionService = decisionService;
	}
	
	@Override
	public ShareRequestResponse canShare(ShareRequest shareRequestDescription) {
		
		LOGGER.info("Received request:\n{}", shareRequestDescription);
		
		ShareRequestResponse response = objectFactory.createShareRequestResponse();
		response.setCanShare(decisionService.canShare(shareRequestDescription));
		LOGGER.info("Answering with answer:{}", response);
		
		return response;
	}
	
}
