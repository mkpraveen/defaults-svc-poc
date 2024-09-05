package com.hclt.pmk.defaults.service;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.stereotype.Service;

import com.hclt.pmk.defaults.models.InvoicePayable;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@ConditionalOnExpression("'${rule.type}' == 'drools'")
public class AppluDefaultsDroolsSvcImpl implements ApplyDefaultsSvc {

    @Autowired
    private KieContainer kieContainer;
    

    @Override
    public InvoicePayable applyDefaults(InvoicePayable invoicePayable) throws Exception {

        log.info("Invoking Drools rule engine for Invoice : {}", invoicePayable.getInvoiceHeader().getInvoiceIdentifer());
        KieSession kieSession = kieContainer.newKieSession();
        kieSession.insert(invoicePayable.getInvoiceHeader());
        kieSession.fireAllRules();

        return invoicePayable;
    }

}
