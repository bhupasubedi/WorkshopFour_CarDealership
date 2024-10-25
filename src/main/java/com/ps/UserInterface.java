package com.ps;
import java.util.List;
import java.util.Scanner;

public class UserInterface {

    private static Dealership dealership;
    private static Scanner scanner = new Scanner(System.in);


    public static void init() {
        dealership = DealershipFileManager.getDealership();
    }

    public static void display() {
        init();

        int choice;

        do {
            System.out.println("\nWelcome to the Dealership Inventory System:");
            System.out.println("1. Display All Vehicles");
            System.out.println("2. Search Vehicles by Price");
            System.out.println("3. Search Vehicles by Make and Model");
            System.out.println("4. Search Vehicles by Year");
            System.out.println("5. Search Vehicles by Color");
            System.out.println("6. Search Vehicles by Mileage");
            System.out.println("7. Search Vehicles by Type");
            System.out.println("8. Add Vehicle");
            System.out.println("9. Remove Vehicle");
            System.out.println("10. Sort Vehicles by Price");
            System.out.println("11. Sort Vehicles by Year");
            System.out.println("99. Exit");

            System.out.print("Please select an option: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    displayAllVehicles();
                    break;
//              //  case 2:
//                 //   searchByPrice(scanner);
//                  //  break;
//              //  case 3:
//                    searchByMakeModel(scanner);
//                    break;
//                case 4:
//                    searchByYear(scanner);
//                    break;
//                case 5:
//                    searchByColor(scanner);
//                    break;
//                case 6:
//                    searchByMileage(scanner);
//                    break;
//                case 7:
//                    searchByType(scanner);
//                    break;
//                case 8:
//                    addVehicle(scanner);
//                    break;
//                case 9:
//                    removeVehicle(scanner);
//                    break;
//                case 10:
//                    sortVehiclesByPrice();
//                    break;
//                case 11:
//                    sortVehiclesByYear();
//                    break;
                case 0:
                    System.out.println("Exiting the system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 99);

        scanner.close();
        DealershipFileManager.saveDealership(dealership);
    }

    private static void displayAllVehicles() {

        List<Vehicle> vehicles = dealership.getAllVehicles();
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle);
        }
    }
}