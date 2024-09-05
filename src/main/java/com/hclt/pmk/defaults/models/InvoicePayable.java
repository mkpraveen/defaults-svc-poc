package com.hclt.pmk.defaults.models;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InvoicePayable {

    private InvoiceHeader invoiceHeader;
    private List<InvoiceDetail> invoiceDetails;

}
