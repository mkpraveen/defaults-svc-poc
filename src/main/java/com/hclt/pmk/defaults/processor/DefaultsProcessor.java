package com.hclt.pmk.defaults.processor;

import com.hclt.pmk.defaults.models.InvoicePayable;

@FunctionalInterface
public interface DefaultsProcessor {
    InvoicePayable applyDefault(InvoicePayable invoicePayable);
}
