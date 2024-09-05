package com.hclt.pmk.defaults.config;

import lombok.Data;

@Data
public class DefaultRuleConfigs {

    private int ruleId;
    private int origin;
    private String sourceAttributeName;
    private String targetAttributeName;
    private String predicateJson;
    private String functionJson;

}
