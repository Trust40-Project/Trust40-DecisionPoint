package org.trust40.decisionpoint.service.domain;

import java.util.Collection;

import org.trust40.decisionpoint.service.domain.dto.AllowRule;

import de.cas.trust40.ws.ShareRequestDescription;

public interface DecisionService {

	void setRules(Collection<AllowRule> activeRules);

	boolean canShare(ShareRequestDescription shareRequestDescription);

}
