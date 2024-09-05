package com.hclt.pmk.defaults.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hclt.pmk.defaults.config.RuleConfigurationLoader;
import com.hclt.pmk.defaults.models.InvoiceHeader;
import com.hclt.pmk.defaults.models.InvoicePayable;
import com.hclt.pmk.defaults.models.rule.DefaultsRuleConfig;
import com.hclt.pmk.defaults.models.rule.RuleFunction;
import com.hclt.pmk.defaults.models.rule.RulePredicate;
import com.hclt.pmk.defaults.rule.function.FunctionExecutor;
import com.hclt.pmk.defaults.rule.function.FunctionExecutorRegistry;
import com.hclt.pmk.defaults.rule.predicate.PredicateEvaluator;
import com.hclt.pmk.defaults.rule.predicate.PredicateEvaluatorRegistry;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;

@Slf4j
@Service
@ConditionalOnExpression("'${rule.type}' == 'custom'")
public class ApplyDefaultsDynamicSvcImpl implements ApplyDefaultsSvc {

    private Gson gson;

    @Autowired
    private PredicateEvaluatorRegistry evaluatorRegistry;

    @Autowired
    private FunctionExecutorRegistry executorRegistry; 

    @Autowired
    private RuleConfigurationLoader configurationLoader;

    @Override
    public InvoicePayable applyDefaults(InvoicePayable invoicePayable) throws Exception {

        List<DefaultsRuleConfig> rules = setupRules();
        gson = new GsonBuilder().create();

        rules.forEach( r -> {
            applyRule(invoicePayable, r);
        });

        return invoicePayable;
    }

    /**
     * 
     * @param invoicePayable
     * @param ruleConfig
     * @return
     */
    private InvoicePayable applyRule(InvoicePayable invoicePayable, DefaultsRuleConfig ruleConfig) {

        RulePredicate predicate = gson.fromJson(ruleConfig.getRulePredicateJson(), RulePredicate.class);
        RuleFunction function = gson.fromJson(ruleConfig.getRuleFunctionJson(), RuleFunction.class);

        log.info("Apply Default rule for : {}", ruleConfig.getSrcAttributeName());
        log.info("Rule Predicate : {}", predicate.toString());
        log.info("Rule Function : {}", function.toString());

        try {
            Field srcField =  InvoiceHeader.class.getDeclaredField(ruleConfig.getSrcAttributeName());
            srcField.setAccessible(true);

            String srcAttributeValue = (String) srcField.get(invoicePayable.getInvoiceHeader());
            log.info("The Source Attribute Value : {}", srcAttributeValue);

            PredicateEvaluator evaluator = evaluatorRegistry.getEvaluator(predicate.getOperationType());
            if (evaluator != null) {
                if (evaluator.evaluate(srcAttributeValue, predicate)) {
                    FunctionExecutor executor = executorRegistry.getExecutor(function.getFunctionType());
                    executor.executeFunction(function, invoicePayable, ruleConfig.getTargetAttributeName());
                }
            }

        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return invoicePayable;
    }



    /**
     * 
     * @return
     */
    private List<DefaultsRuleConfig> setupRules() {
        List<DefaultsRuleConfig> ruleConfigs = new ArrayList<>();

        configurationLoader.getDefaultRuleConfigs().forEach( rule -> {

        DefaultsRuleConfig config = new DefaultsRuleConfig();
        config.setOrigin(rule.getOrigin());
        config.setRuleId(rule.getRuleId());
        config.setSrcAttributeName(rule.getSourceAttributeName());
        config.setTargetAttributeName(rule.getTargetAttributeName());
        config.setRulePredicateJson(rule.getPredicateJson());
        config.setRuleFunctionJson(rule.getFunctionJson());

        ruleConfigs.add(config);
        });
        

        return ruleConfigs;
    }

}
