package com.system.locator.services;

import com.system.locator.entities.CarRental;
import com.system.locator.entities.Invoice;
import com.system.locator.services.interfaces.ITaxService;

import java.time.Duration;

public class RentalService {

    private Double pricePerDay;
    private Double pricePerHour;
    private ITaxService taxService;

    public RentalService(Double pricePerHour, Double pricePerDay, ITaxService taxService) {
        this.pricePerHour = pricePerHour;
        this.pricePerDay = pricePerDay;
        this.taxService = taxService;
    }

    public void processInvoice(CarRental carRental) {
        double hours = Math.ceil(Duration.between(carRental.getStart(), carRental.getFinish()).toMinutes() / 60.0);

        double basicPayment;
        if (hours <= 12.0) {
            basicPayment = pricePerHour * hours;
        } else {
            basicPayment = pricePerDay * Math.ceil(hours / 24);
        }

        double tax = taxService.tax(basicPayment);

        carRental.setInvoice(new Invoice(basicPayment, tax));
    }

}
