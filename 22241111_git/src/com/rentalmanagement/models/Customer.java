package com.rentalmanagement.models;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private final List<Object> rentalHistory = new ArrayList<>().reversed();

    public Customer(String customerId, String name) {
        this.name = name;
    }

    public String getName() { return name; }

    public void addRental(RentalTransaction transaction) {
        rentalHistory.add(transaction);
    }

    public boolean isEligibleForRental() {
        return rentalHistory.size() < 5;
    }
}
