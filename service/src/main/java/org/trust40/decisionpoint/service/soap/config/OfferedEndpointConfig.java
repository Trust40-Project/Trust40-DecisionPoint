package org.trust40.decisionpoint.service.soap.config;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import de.cas.trust40.ws.Trust40WebService;

/**
 * Configuration for SOAP endpoints that are offered to users.
 */
@Configuration
public class OfferedEndpointConfig {

	@Autowired
	private Trust40WebService trust40Webservice;
	
	@Autowired
	private Bus bus;

	@Bean
	public Endpoint endpoint() {
		return create(trust40Webservice, "/Trust40WebService");
	}
	
	protected Endpoint create(Object implementation, String addr) {
		EndpointImpl endpoint = new EndpointImpl(bus, implementation);
		endpoint.publish(addr);
		return endpoint;
	}
	
}
