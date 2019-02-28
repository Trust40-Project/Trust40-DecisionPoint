package org.trust40.decisionpoint.service.domain.dto;

import java.util.Collection;

public abstract class Rule {

	private int operationId;
	private Collection<String> subjectIds;
	private Collection<String> objectIds;

	public int getOperationId() {
		return operationId;
	}

	public void setOperationId(int operationId) {
		this.operationId = operationId;
	}

	public Collection<String> getSubjectIds() {
		return subjectIds;
	}

	public void setSubjectIds(Collection<String> subjectIds) {
		this.subjectIds = subjectIds;
	}

	public Collection<String> getObjectIds() {
		return objectIds;
	}

	public void setObjectIds(Collection<String> objectIds) {
		this.objectIds = objectIds;
	}

}
