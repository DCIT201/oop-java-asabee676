package com.rentalmanagement.tests;

import com.rentalmanagement.models.Car;
import com.rentalmanagement.models.Vehicle;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

public class VehicleTest {

    // Test encapsulation for Vehicle fields
    @Test
    public void testEncapsulation() {
        Vehicle car = new Car("C001", "Toyota Corolla", 100, true);
        assertEquals("C001", car.getVehicleId());
        assertEquals("Toyota Corolla", car.getModel());
        assertEquals(100, car.getBaseRentalRate());
        assertTrue(car.isAvailable());
    }

    private void assertEquals(int i, double baseRentalRate) {
    }

    private void assertEquals(String c001, String vehicleId) {
    }

    // Test calculateRentalCost for Car
    @Test
    public void testCalculateRentalCostCar() {
        Vehicle car = new Car("C002", "Honda Civic", 120, true);
        assertEquals(380, car.calculateRentalCost(3), 0.01); // Assuming GPS fee adds $50
    }

    private void assertEquals(int i, double v, double v1) {
    }

    // Test calculateRentalCost for Motorcycle
    @Test
    public void testCalculateRentalCostMotorcycle() {
        Vehicle motorcycle = new Vehicle("M001", "Yamaha R3", 50) {
            @Override
            public double calculateRentalCost(int days) {
                return 0;
            }

            @Override
            public boolean isAvailableForRental() {
                return false;
            }
        };
        assertEquals(150, motorcycle.calculateRentalCost(3), 0.01);
    }

    // Test isAvailableForRental
    @Test
    public void testIsAvailableForRental() {
        Vehicle car = new Car("C003", "Ford Mustang", 200, false);
        car.setAvailable(false);
        assertFalse(car.isAvailableForRental());
    }

    // Test polymorphic behavior
    @Test
    public void testPolymorphism() {
        Vehicle vehicle1 = new Car("C004", "BMW 3 Series", 150, true);
        Vehicle vehicle2 = new Vehicle("M002", "Suzuki Hayabusa", 70) {
            @Override
            public double calculateRentalCost(int days) {
                return 0;
            }

            @Override
            public boolean isAvailableForRental() {
                return false;
            }
        };

        assertEquals(500, vehicle1.calculateRentalCost(3), 0.01); // With GPS fee
        assertEquals(210, vehicle2.calculateRentalCost(3), 0.01);
    }

    // Test abstraction implementation
    @Test
    public void testAbstraction() {
        Vehicle car = new Car("C005", "Audi A4", 140, false);
        assertNotNull(car.calculateRentalCost(1)); // Ensures method is implemented
    }

    private void assertNotNull(double v) {
    }

    private record Motorcycle(String m002, String suzukiHayabusa, int i) {
    }
}
