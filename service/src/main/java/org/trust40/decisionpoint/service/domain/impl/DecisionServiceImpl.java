package org.trust40.decisionpoint.service.domain.impl;

import java.util.Collection;
import java.util.Collections;

import org.springframework.stereotype.Service;
import org.trust40.decisionpoint.service.domain.DecisionService;
import org.trust40.decisionpoint.service.domain.dto.AllowRule;
import org.trust40.trust40webservice.ShareRequest;

@Service
public class DecisionServiceImpl implements DecisionService {

	private Collection<AllowRule> activeRules = Collections.emptySet();

	@Override
	public void setRules(Collection<AllowRule> activeRules) {
		synchronized(activeRules) {
			this.activeRules = Collections.unmodifiableCollection(activeRules);			
		}
	}

	@Override
	public boolean canShare(ShareRequest shareRequestDescription) {
		// TODO Implement decision making based on rules
		return false;
	}

}
