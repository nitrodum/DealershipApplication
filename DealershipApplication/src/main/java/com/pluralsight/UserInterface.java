package com.pluralsight;

import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private Dealership dealership;
    private final Scanner scanner = new Scanner(System.in);
    private boolean running = true;

    public UserInterface() {
    }

    private void init() {
        DealershipFileManager loader = new DealershipFileManager();
        this.dealership = loader.getDealership();
    }

    public void display() {
        init();
        while (running) {
            menu();
        }
        scanner.close();
    }

    private void menu() {
        System.out.println("Welcome to our Dealership!\n" +
                "Please enter the number that corresponds to the command:\n" +
                "1) Search by Price\n" +
                "2) Search by Make and Model\n" +
                "3) Search by Year\n" +
                "4) Search by Color\n" +
                "5) Search by Mileage\n" +
                "6) Search by Vehicle Type\n" +
                "7) Search All\n" +
                "8) Add Vehicle\n" +
                "9) Remove Vehicle\n" +
                "0) Exit");

        String choice = scanner.nextLine();
        switch (choice) {
            case "1":
                processGetByPriceRequest();
                break;
            case "2":
                processGetByMakeModelRequest();
                break;
            case "3":
                processGetByYearRequest();
                break;
            case "4":
                processGetByColorRequest();
                break;
            case "5":
                processGetByMileageRequest();
                break;
            case "6":
                processGetByVehicleTypeRequest();
                break;
            case "7":
                processGetAllVehiclesRequest();
                break;
            case "8":
                processAddVehicleRequest();
                break;
            case "9":
                processRemoveVehicleRequest();
                break;
            case "0":
                running = false;
                break;
            default:
                System.out.println("Invalid Option, Please Choose a Valid Option");

        }
    }

    private void processGetByPriceRequest() {

    }

    private void processGetByMakeModelRequest() {

    }

    private void processGetByYearRequest() {

    }

    private void processGetByColorRequest() {

    }

    private void processGetByMileageRequest() {

    }

    private void processGetByVehicleTypeRequest() {

    }

    private void processGetAllVehiclesRequest() {
        List<Vehicle> allVehicles = dealership.getAllVehicles();
        displayVehicles(allVehicles);
    }

    private void processAddVehicleRequest() {

    }

    private void processRemoveVehicleRequest() {

    }

    private void displayVehicles(List<Vehicle> vehicles) {
        for (Vehicle vehicle : vehicles) {
            System.out.println("VIN: " + vehicle.getVin() + " Year: " + vehicle.getYear() + " Make: " +
                    vehicle.getMake() + " Model: " + vehicle.getModel() + " Type: " + vehicle.getVehicleType() +
                    " Color: " + vehicle.getColor() + " Odometer: " + vehicle.getOdometer() + " Price: " +
                    vehicle.getPrice());
        }
    }
}
