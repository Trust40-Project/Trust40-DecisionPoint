package org.trust40.decisionpoint.service.domain.impl;

import java.util.Collection;
import java.util.Collections;

import org.springframework.stereotype.Service;
import org.trust40.decisionpoint.api.dto.ContextDescription;
import org.trust40.decisionpoint.service.domain.EnsembleService;
import org.trust40.decisionpoint.service.domain.dto.Rule;

@Service
public class EnsembleServiceImpl implements EnsembleService {

	@Override
	public void processContextUpdate(ContextDescription poll) {
		// TODO Ensembles updates
	}

	@Override
	public Collection<Rule> recalculate() {
		// TODO Ensembles solving
		return Collections.emptySet();
	}

}
