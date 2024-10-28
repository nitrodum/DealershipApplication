package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;

public class DealershipFileManager {
    public static Dealership getDealership() {
        try {
            BufferedReader bufferedReader = new BufferedReader( new FileReader("inventory.csv"));
            String input = bufferedReader.readLine();
            String[] dealershipInfo = input.split("\\|");
            Dealership dealership = new Dealership(dealershipInfo[0], dealershipInfo[1], dealershipInfo[2]);
            while ((input = bufferedReader.readLine()) != null) {
                String[] data = input.split("\\|");
                Vehicle vehicle = new Vehicle(Integer.parseInt(data[0]), Integer.parseInt(data[1]), data[2], data[3],
                        data[4], data[5], Integer.parseInt(data[6]), Double.parseDouble(data[7]));
                dealership.addVehicle(vehicle);
            }
            return dealership;
        } catch (Exception e) {
            System.out.println("Error reading file");
        }
        return null;
    }

    public static void saveDealership(Dealership dealership) {

    }
}
