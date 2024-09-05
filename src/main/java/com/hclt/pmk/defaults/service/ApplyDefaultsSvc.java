package com.hclt.pmk.defaults.service;

import com.hclt.pmk.defaults.models.InvoicePayable;

public interface ApplyDefaultsSvc {

    public InvoicePayable applyDefaults(InvoicePayable invoicePayable) throws Exception;
}
