package com.hclt.pmk.defaults.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceDetail {
    private int lineItemNumber;
    private String itemDescription;
    private int quantity;
    private double value;
    private double taxRate;
}
