package com.hclt.pmk.defaults.processor;

import org.springframework.stereotype.Service;

import com.hclt.pmk.defaults.models.InvoicePayable;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BankCdDefaultProcessor implements DefaultsProcessor {

    @Override
    public InvoicePayable applyDefault(InvoicePayable invoicePayable) {

        log.info("Executing BankCdDefaultProcessor - for invoice : {}" , invoicePayable.getInvoiceHeader().getInvoiceIdentifer());
        if(invoicePayable.getInvoiceHeader().getBankCd().isEmpty()) {
            invoicePayable.getInvoiceHeader().setBankCd("NA");
        }
        return invoicePayable;

        
    }

}
