package com.pluralsight;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Dealership dealership = DealershipFileManager.getDealership();
        System.out.println("Name: " + dealership.getName());
        System.out.println("Address:  " + dealership.getAddress());
        System.out.println("Number: " + dealership.getPhoneNumber());
        List<Vehicle> vehicles = dealership.getAllVehicles();

        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle);
        }
    }
}