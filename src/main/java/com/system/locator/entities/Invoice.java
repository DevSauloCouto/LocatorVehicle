package com.system.locator.entities;

public class Invoice {

    private Double basicPayment;
    private Double tax;
    public Invoice() {}

    public Invoice(Double basicPayment, Double tax) {
        this.basicPayment = basicPayment;
        this.tax = tax;
    }

    public Double getBasicPayment() {
        return basicPayment;
    }

    public Double getTax() {
        return tax;
    }

    public Double getTotalPayment() {
        //Usando os getters para casualidades de futuras implementações de regras de negócio
        return getBasicPayment() + getTax();
    }

}
