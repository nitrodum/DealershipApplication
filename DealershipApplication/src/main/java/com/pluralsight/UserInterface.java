package com.pluralsight;

import java.util.ArrayList;
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
        System.out.println("Enter any input to continue");
        String buffer = scanner.nextLine();
    }

    private void processGetByPriceRequest() {
        System.out.println("Enter the minimum price to search for:");
        int min = scanner.nextInt();
        System.out.println("Enter the maximum price to search for:");
        int max = scanner.nextInt();
        scanner.nextLine();

        List<Vehicle> filteredByPrice = dealership.getVehiclesByPrice(min, max);
        displayVehicles(filteredByPrice);
    }

    private void processGetByMakeModelRequest() {
        System.out.println("Enter the make of the car:");
        String make = scanner.nextLine();
        System.out.println("Enter the model of the car");
        String model = scanner.nextLine();
        
        List<Vehicle> filteredByMakeModel = dealership.getVehiclesByMakeModel(make, model);
        displayVehicles(filteredByMakeModel);
    }

    private void processGetByYearRequest() {
        System.out.println("Enter the start year to search for:");
        int min = scanner.nextInt();
        System.out.println("Enter the end year to search for:");
        int max = scanner.nextInt();
        scanner.nextLine();

        List<Vehicle> filteredByYear = dealership.getVehiclesByYear(min, max);
        displayVehicles(filteredByYear);
    }

    private void processGetByColorRequest() {
        System.out.println("Enter the color to search for:");
        String color = scanner.nextLine();

        List<Vehicle> filteredByColor = dealership.getVehiclesByColor(color);
        displayVehicles(filteredByColor);
    }

    private void processGetByMileageRequest() {
        System.out.println("Enter the minimum mileage to search for:");
        int min = scanner.nextInt();
        System.out.println("Enter the maximum mileage to search for:");
        int max = scanner.nextInt();
        scanner.nextLine();

        List<Vehicle> filteredByMileage = dealership.getVehiclesByMileage(min, max);
        displayVehicles(filteredByMileage);
    }

    private void processGetByVehicleTypeRequest() {
        System.out.println("Enter the vehicle type to search for:");
        String type = scanner.nextLine();

        List<Vehicle> filteredByType = dealership.getVehiclesByType(type);
        displayVehicles(filteredByType);
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
