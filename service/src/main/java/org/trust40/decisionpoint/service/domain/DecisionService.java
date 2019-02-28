package org.trust40.decisionpoint.service.domain;

import java.util.Collection;

import org.trust40.decisionpoint.service.domain.dto.AllowRule;
import org.trust40.trust40webservice.ShareRequest;

public interface DecisionService {

	void setRules(Collection<AllowRule> activeRules);

	boolean canShare(ShareRequest shareRequestDescription);

}
