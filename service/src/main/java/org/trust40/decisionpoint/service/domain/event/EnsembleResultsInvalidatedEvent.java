package org.trust40.decisionpoint.service.domain.event;

import org.springframework.context.ApplicationEvent;

public class EnsembleResultsInvalidatedEvent extends ApplicationEvent {

	private static final long serialVersionUID = -2789329921014487740L;

	public EnsembleResultsInvalidatedEvent(Object source) {
		super(source);
	}

}
