package org.trust40.decisionpoint.service.domain.impl;

import java.util.Collection;
import java.util.Collections;

import org.springframework.stereotype.Service;
import org.trust40.decisionpoint.service.domain.DecisionService;
import org.trust40.decisionpoint.service.domain.dto.AllowRule;

import de.cas.trust40.ws.ShareRequestDescription;

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
	public boolean canShare(ShareRequestDescription shareRequestDescription) {
		// TODO Implement decision making based on rules
		return false;
	}

}
