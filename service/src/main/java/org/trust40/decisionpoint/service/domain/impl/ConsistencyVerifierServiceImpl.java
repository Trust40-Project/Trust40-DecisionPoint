package org.trust40.decisionpoint.service.domain.impl;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;
import org.trust40.decisionpoint.service.domain.ConsistencyVerifierService;
import org.trust40.decisionpoint.service.domain.DecisionService;
import org.trust40.decisionpoint.service.domain.EnsembleService;
import org.trust40.decisionpoint.service.domain.PrivacyLevelService;
import org.trust40.decisionpoint.service.domain.dto.AllowRule;
import org.trust40.decisionpoint.service.domain.dto.Rule;
import org.trust40.decisionpoint.service.domain.event.EnsembleResultsInvalidatedEvent;

@Service
public class ConsistencyVerifierServiceImpl implements ConsistencyVerifierService, ApplicationListener<EnsembleResultsInvalidatedEvent> {

	private final EnsembleService ensembleService;
	private final DecisionService decisionService;
	private final PrivacyLevelService privacyLevelService;

	@Autowired
	public ConsistencyVerifierServiceImpl(EnsembleService ensembleService, DecisionService decisionService, PrivacyLevelService privacyLevelService) {
		this.ensembleService = ensembleService;
		this.decisionService = decisionService;
		this.privacyLevelService = privacyLevelService;
	}
	
	@Override
	public void onApplicationEvent(EnsembleResultsInvalidatedEvent event) {
		handleEnsembleResultsInvalidated();
	}

	private void handleEnsembleResultsInvalidated() {
		synchronized(ensembleService) {
			Collection<Rule> rules = ensembleService.recalculate();
			Collection<AllowRule> activeRules = filterRules(rules);
			decisionService.setRules(activeRules);
		}
	}

	private Collection<AllowRule> filterRules(Collection<Rule> rules) {
		// TODO Implement filtering of allowed rules
		return rules.stream().filter(AllowRule.class::isInstance).map(AllowRule.class::cast).collect(Collectors.toList());
	}

}
