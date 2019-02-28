package org.trust40.decisionpoint.service.domain.dto;

public class DenyRule extends Rule {

	private PrivacyLevel privacyLevel;

	public PrivacyLevel getPrivacyLevel() {
		return privacyLevel;
	}

	public void setPrivacyLevel(PrivacyLevel privacyLevel) {
		this.privacyLevel = privacyLevel;
	}

}
