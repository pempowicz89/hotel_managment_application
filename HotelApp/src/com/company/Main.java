package com.company;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {

    private Scanner input = new Scanner(System.in);


    private enum Filter {
        ALL, AVAILABLE, BOOKED,
        NAME, SSN, PHONE, ADDRESS,
        ADD, EDIT, REMOVE,
        RNR, BEDS, BALCONY, PRICE,
        ID, CHECKOUT,
        ROOM,
        USERNAME, PASSWORD

    }

    private String userName = "";
    private ArrayList<User> listOfStaff = new ArrayList<>();
    private ArrayList<Booking> listOfBookings = new ArrayList<>();
    private ArrayList<Customer> lisOfCustomer = new ArrayList<>();
<<<<<<< HEAD
    private ArrayList<Room> listOfRooms = new ArrayList<>();
    private Date today = new Date ( 2019, 11, 25, 12, 14 );
=======
    private Date today = new Date(2019, 11, 25, 12, 14);
>>>>>>> 2d3ddf4269ee2f67bfab4b912a9a9897764ce933

    private enum Access {ADMIN, GUEST}

    Customer cus1 = new Customer("Donald", "1234", false, "Donald",
            "Trump", "123456789", "White House", "001001");
    Customer cus2 = new Customer("Vladimir", "4321", false, "Vladidmir",
            "Putin", "987654321", "Kremlin", "002002");




    public static void main(String[] args) {
        Main hotelApp = new Main();
        hotelApp.runProgram();
    }

<<<<<<< HEAD
        Customer cus1 = new Customer("Donald", "1234", false, "Donald",
                "Trump", "123456789", "White House", "001001");
        Customer cus2 = new Customer("Vladimir", "4321", false, "Vladidmir",
                "Putin", "987654321", "Kremlin", "002002");

        //int roomNumber, int numberOfBeds, int balcony, double pricePerNight
        Room room1 = new Room(1, 3, 0, 300);
        
=======
    private void runProgram() {
        Scanner input2 = new Scanner(System.in);
        int choice;

        listOfStaff.add(new User("Hassan", "Mousavi", true));
        listOfStaff.add(new User("Jens", "Lindström", true));
        listOfStaff.add(new User("Gustav", "Svensson", true));
        listOfStaff.add(new User("Dino", "Tuzlak", true));


        do {
            printLogInMenu();
            System.out.println("Make your choice: ");
            System.out.println(">>");
            choice = input2.nextInt();
            if (choice == 1) {
                handleEditMenu();
            }
        } while (choice != 2);
    }
>>>>>>> 2d3ddf4269ee2f67bfab4b912a9a9897764ce933

    private void printLogInMenu() {
        System.out.println("Login Menu");
        System.out.println("--------------------");
        System.out.println("| 1.login          |");
        System.out.println("| 2.Exit           |");
        System.out.println("--------------------");

    }

    private void startMenu() {
        System.out.println("          START MENU             ");
        System.out.println("--------------------------------");
        System.out.println("| 1.  Add Customer              |");
        System.out.println("| 2.  Remove Customer           |");
        System.out.println("| 3.  Edit Customer info        |");
        System.out.println("| 4.  Edit booking              |");
        System.out.println("| 5.  Add Room                  |");
        System.out.println("| 6.  Edit Room                 |");
        System.out.println("| 7.  Remove Room               |");
        System.out.println("| 8.  Go To Admin Menu          |");
        System.out.println("| 9.  View Customer             |");
        System.out.println("| 10. View Rooms                |");
        System.out.println("| 11. Search For All Booking    |");
        System.out.println("| 12. Back                      |");
        System.out.println("--------------------------------");
    }

    private void handleEditMenu() {
        Main hotelApp = new Main();

        int select;
        do {
            startMenu();
            System.out.print(">>");
            select = input.nextInt();
            if (select == 1) {
                hotelApp.addCustomer();
            } else if (select == 2) {
            } else if (select == 3) {
            } else if (select == 4) {
            } else if (select == 5) {
            } else if (select == 6) {
            } else if (select == 7) {
            } else if (select == 8) {
            } else if (select == 9) {
                hotelApp.viewCustomerInfo();
            } else if (select == 10) {
            } else if (select == 11) {

            }
        } while (select != 12);
    }


    private void addCustomer() {
        String firstName, lastName, ssn, phoneNumber, address;
        int counter = 0;
        String stringChoice;
        input.nextLine();


    }

    private void viewCustomerInfo() {

        lisOfCustomer.add(cus1);
        lisOfCustomer.add(cus2);

        System.out.println("      List Of Customers   ");
        for (Customer cus: lisOfCustomer){
            System.out.println(cus);
        }
    }
}







