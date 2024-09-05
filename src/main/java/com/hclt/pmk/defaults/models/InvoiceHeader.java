package com.hclt.pmk.defaults.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceHeader {
    private int invoiceIdentifer;
    private int originCode;
    private String vendorId;
    private String bankCd;
    private String bankAccountKey;
    private String paymentMethod;
}
