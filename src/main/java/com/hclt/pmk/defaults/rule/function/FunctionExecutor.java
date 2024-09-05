package com.hclt.pmk.defaults.rule.function;

import com.hclt.pmk.defaults.models.InvoicePayable;
import com.hclt.pmk.defaults.models.rule.RuleFunction;

public interface FunctionExecutor {
    public String getFunctionType();
    public boolean executeFunction(RuleFunction ruleFunction, InvoicePayable invoicePayable, String targetAttributeName);
}
