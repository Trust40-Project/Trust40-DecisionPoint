package org.trust40.decisionpoint.service.soap.config;

import javax.xml.ws.Endpoint;
import javax.xml.ws.Service;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.trust40.trust40webservice.Trust40WebService;
import org.trust40.trust40webservice.Trust40WebService_Service;

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
		return create(trust40Webservice, "/Trust40WebService", new Trust40WebService_Service());
	}
	
	protected Endpoint create(Object implementation, String addr, Service service) {
		EndpointImpl endpoint = new EndpointImpl(bus, implementation);
		endpoint.publish(addr);
		endpoint.setWsdlLocation(service.getWSDLDocumentLocation().toString());
		endpoint.setServiceName(service.getServiceName());
		endpoint.setEndpointName(service.getPorts().next());
		return endpoint;
	}
	
}
