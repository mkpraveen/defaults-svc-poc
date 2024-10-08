package com.hclt.pmk.defaults.models.rule;

public class RuleFunction {

    private String functionType;
    private String value;

    public String getFunctionType() {
        return functionType;
    }

    public void setFunctionType(String functionType) {
        this.functionType = functionType;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((functionType == null) ? 0 : functionType.hashCode());
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
        RuleFunction other = (RuleFunction) obj;
        if (functionType == null) {
            if (other.functionType != null)
                return false;
        } else if (!functionType.equals(other.functionType))
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
        return "RuleFunction [functionType=" + functionType + ", value=" + value + "]";
    }

  
}
