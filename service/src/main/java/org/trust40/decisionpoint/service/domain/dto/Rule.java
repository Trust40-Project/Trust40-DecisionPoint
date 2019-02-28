package org.trust40.decisionpoint.service.domain.dto;

import java.util.Collection;

public abstract class Rule {

	private String operationId;
	private Collection<String> subjectIds;
	private Collection<String> objectIds;

	public String getOperationId() {
		return operationId;
	}

	public void setOperationId(String operationId) {
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
