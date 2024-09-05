package com.hclt.pmk.defaults.rule.predicate;

import java.util.List;
import java.util.ArrayList;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.hclt.pmk.defaults.models.rule.RulePredicate;

@Component
public class EqualsPredicateEvaluator implements PredicateEvaluator {

    @Override
    public String getOperationType() {
        return "EQUALS";
    }

    @Override
    public boolean evaluate(String actualValue, RulePredicate rulePredicate) {

        boolean result = false;
        if (rulePredicate.getValue() instanceof List) {
            List<String> compValueLst = (ArrayList<String>) rulePredicate.getValue();
            return compValueLst.stream().map(c -> {

                if (c.equalsIgnoreCase("NULL") || c.equalsIgnoreCase("EMPTY")) {
                    return StringUtils.isEmpty(actualValue);
                } else if (c.equalsIgnoreCase(actualValue)) {
                    return true;
                }
                else {
                    return false;
                }
            }).anyMatch(e -> e == true);

        } 

        return result;
    }

}
