package com.hclt.pmk.defaults.rule.predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class PredicateEvaluatorRegistry {

    @Autowired
    private List<PredicateEvaluator> predicateEvaluators;

    public PredicateEvaluator getEvaluator(String operationType) {
        return predicateEvaluators.stream().filter( e -> e.getOperationType().equalsIgnoreCase(operationType)).findFirst().orElse(null);
    }
}
