package com.hclt.pmk.defaults.controller;

import org.springframework.web.bind.annotation.RestController;

import com.hclt.pmk.defaults.models.InvoicePayable;
import com.hclt.pmk.defaults.service.ApplyDefaultsSvc;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@AllArgsConstructor
@NoArgsConstructor
@RestController
public class ApplyDefaultsController {

    @Autowired
    private ApplyDefaultsSvc applyDefaultsSvc;

    //post end-point to accept Payable Invoice and return the same after apply edits
    @PostMapping("/v1/apply-defaults")
    public InvoicePayable postMethodName(@RequestBody InvoicePayable invoicePayable) throws Exception {
        applyDefaultsSvc.applyDefaults(invoicePayable);
        
        return invoicePayable;
    }
    
    
}
