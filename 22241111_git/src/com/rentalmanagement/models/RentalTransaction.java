package com.rentalmanagement.models;

import com.rentalmanagement.models.Vehicle;

public class RentalTransaction {
    private Vehicle vehicle;
    private Customer customer;
    private int days;
    private double cost;

    public RentalTransaction(Vehicle vehicle, Customer customer, int days, double cost) {
        this.vehicle = vehicle;
        this.customer = customer;
        this.days = days;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return customer.getName() + " rented " + vehicle.getModel() + " for " + days + " days at " + cost;
    }
}
