package com.hclt.pmk.defaults.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.stereotype.Service;

import com.hclt.pmk.defaults.models.InvoicePayable;
import com.hclt.pmk.defaults.processor.DefaultsProcessor;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
@ConditionalOnExpression("'${rule.type}' == 'code'")
public class ApplyDefaultsSvcImpl implements ApplyDefaultsSvc{

    @Autowired
    private List<DefaultsProcessor> defaultsProcessorList;

    @Override
    public InvoicePayable applyDefaults(InvoicePayable invoicePayable) throws Exception {
        log.info("Invoking the service for Invoice Id : {}", invoicePayable.getInvoiceHeader().getInvoiceIdentifer());
        defaultsProcessorList.forEach( d -> d.applyDefault(invoicePayable));

        return invoicePayable;
    }

}
