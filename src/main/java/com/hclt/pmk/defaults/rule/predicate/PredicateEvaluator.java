package com.hclt.pmk.defaults.rule.predicate;

import com.hclt.pmk.defaults.models.rule.RulePredicate;

public interface PredicateEvaluator {

    public String getOperationType();
    public boolean evaluate(String actualValue, RulePredicate RulePredicate);
}
