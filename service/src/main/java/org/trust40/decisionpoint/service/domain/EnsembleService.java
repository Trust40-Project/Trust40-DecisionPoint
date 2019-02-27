package org.trust40.decisionpoint.service.domain;

import java.util.Collection;

import org.trust40.decisionpoint.api.dto.ContextDescription;
import org.trust40.decisionpoint.service.domain.dto.Rule;

public interface EnsembleService {

	void processContextUpdate(ContextDescription poll);

	Collection<Rule> recalculate();

}
