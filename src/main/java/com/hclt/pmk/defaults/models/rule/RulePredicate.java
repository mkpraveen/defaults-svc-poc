package com.hclt.pmk.defaults.models.rule;

import java.util.List;


public class RulePredicate {
    private String operationType;
    private List<String> value;

    public RulePredicate() {
    }

    public RulePredicate(String operationType, List<String> value) {
        this.operationType = operationType;
        this.value = value;
    }
    
    public String getOperationType() {
        return operationType;
    }
    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }
    public List<String> getValue() {
        return value;
    }
    public void setValue(List<String> value) {
        this.value = value;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((operationType == null) ? 0 : operationType.hashCode());
        result = prime * result + ((value == null) ? 0 : value.hashCode());
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
        RulePredicate other = (RulePredicate) obj;
        if (operationType == null) {
            if (other.operationType != null)
                return false;
        } else if (!operationType.equals(other.operationType))
            return false;
        if (value == null) {
            if (other.value != null)
                return false;
        } else if (!value.equals(other.value))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "RulePredicate [operationType=" + operationType + ", value=" + value + "]";
    }

    
}
