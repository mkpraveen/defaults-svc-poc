package com.hclt.pmk.defaults.rule.function;

import org.springframework.stereotype.Component;

import com.hclt.pmk.defaults.models.InvoiceHeader;
import com.hclt.pmk.defaults.models.InvoicePayable;
import com.hclt.pmk.defaults.models.rule.RuleFunction;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;

@Slf4j
@Component
public class AssignFunctionExecutor implements FunctionExecutor{

    @Override
    public String getFunctionType() {
      return "ASSIGN_VALUE";
    }

    @Override
    public boolean executeFunction(RuleFunction ruleFunction, InvoicePayable invoicePayable, String targetAttributeName) {

        Field targetField;
        try {
            log.info("Running ASSING_VALUE executor : {}", targetAttributeName);
            targetField = InvoiceHeader.class.getDeclaredField(targetAttributeName);
            targetField.setAccessible(true);

            log.info("Assign Value : {}", ruleFunction.getValue());
            targetField.set(invoicePayable.getInvoiceHeader(), ruleFunction.getValue());

        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        
        return true;
    }

}
