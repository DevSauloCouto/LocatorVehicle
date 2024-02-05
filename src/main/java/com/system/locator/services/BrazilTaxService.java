package com.system.locator.services;

import com.system.locator.services.interfaces.ITaxService;

public class BrazilTaxService implements ITaxService {

    @Override
    public Double tax(Double amount) {
        if (amount <= 100.0) {
            return amount * 0.2;
        } else {
            return amount * 0.15;
        }
    }

}
