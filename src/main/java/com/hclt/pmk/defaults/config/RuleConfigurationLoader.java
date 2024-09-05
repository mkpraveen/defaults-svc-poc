package com.hclt.pmk.defaults.config;
import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "apil")
@Configuration
public class RuleConfigurationLoader {

    private List<DefaultRuleConfigs> defaultRuleConfigs;

    public List<DefaultRuleConfigs> getDefaultRuleConfigs() {
        return defaultRuleConfigs;
    }

    public void setDefaultRuleConfigs(List<DefaultRuleConfigs> rules) {
        this.defaultRuleConfigs = rules;
    }

    public RuleConfigurationLoader(List<DefaultRuleConfigs> rules) {
        this.defaultRuleConfigs = rules;
    }

    public RuleConfigurationLoader() {
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((defaultRuleConfigs == null) ? 0 : defaultRuleConfigs.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        RuleConfigurationLoader other = (RuleConfigurationLoader) obj;
        if (defaultRuleConfigs == null) {
            if (other.defaultRuleConfigs != null)
                return false;
        } else if (!defaultRuleConfigs.equals(other.defaultRuleConfigs))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "RuleConfigurationLoader [rules=" + defaultRuleConfigs + "]";
    }

    
}

