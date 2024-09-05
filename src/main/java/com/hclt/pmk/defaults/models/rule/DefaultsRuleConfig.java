package com.hclt.pmk.defaults.models.rule;

import lombok.Data;

@Data
public class DefaultsRuleConfig {

    private int ruleId;
    private int origin;
    private String srcAttributeName;
    private String targetAttributeName;
    private String rulePredicateJson;
    private String ruleFunctionJson;

}
