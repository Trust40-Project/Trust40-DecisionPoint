package org.trust40.decisionpoint.api;

import org.trust40.decisionpoint.api.dto.ContextDescription;
import org.trust40.decisionpoint.api.dto.ContextUpdateSchedulingStatus;

public interface IContextUpdate {

	ContextUpdateSchedulingStatus update(ContextDescription description);
	
}
