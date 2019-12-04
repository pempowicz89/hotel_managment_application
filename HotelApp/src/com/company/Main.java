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
    private ArrayList<Room> listOfRooms = new ArrayList<>();
    private Date today = new Date ( 2019, 11, 25, 12, 14 );

    private enum Access {ADMIN, GUEST}






    public static void main(String[] args) {
        Main hotelApp = new Main();
        hotelApp.runProgram();
    }

        //int roomNumber, int numberOfBeds, int balcony, double pricePerNight
        Room room1 = new Room(1, 3, 0, 300);



    private void runProgram() {
        Scanner input2 = new Scanner(System.in);
        int choice;

        listOfStaff.add(new User("Hassan", "Mousavi", true));
        listOfStaff.add(new User("Jens", "Lindström", true));
        listOfStaff.add(new User("Gustav", "Svensson", true));
        listOfStaff.add(new User("Dino", "Tuzlak", true));

        Customer cus1 = new Customer("Donald", "1234", false, "Donald",
                "Trump", "123456789", "White House", "001001");
        Customer cus2 = new Customer("Vladimir", "4321", false, "Vladidmir",
                "Putin", "987654321", "Kremlin", "002002");

        lisOfCustomer.add(cus1);
        lisOfCustomer.add(cus2);

        Room testRoom = new Room(432, 3, 1, 500);

        listOfRooms.add(testRoom);

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
                hotelApp.addRoom();
            } else if (select == 6) {
            } else if (select == 7) {
            } else if (select == 8) {
            } else if (select == 9) {
                hotelApp.viewCustomerInfo();
            } else if (select == 10) {
                hotelApp.viewRoomInfo();
            } else if (select == 11) {

            }
        } while (select != 12);
    }


    private void addCustomer() {
        String userName, password, firstName, lastName, ssn, phoneNumber, address;

        System.out.println("What's the customer User Name?");
        userName = input.nextLine();

        System.out.println("What's the costumer Password?");
        password = input.nextLine();

        System.out.println("What's the customer First Name?");
        firstName = input.nextLine();

        System.out.println("What's the customer Last Name?");
        lastName = input.nextLine();

        System.out.println("What's the customer SSN?");
        ssn = input.nextLine();

        System.out.println("What's the customer Address?");
        address = input.nextLine();

        System.out.println("What's the customer Phone Number?");
        phoneNumber = input.nextLine();

        Customer newCustomer = new Customer(userName, password, false, firstName, lastName, ssn, address, phoneNumber);
        lisOfCustomer.add(newCustomer);

        System.out.println("New Customer added!");
    }

    private void addRoom(){
        //int roomNumber, int numberOfBeds, int balcony, double pricePerNight
        int roomNumber, numberOfBeds, balcony;
        double pricePerNight;
        System.out.println("What's the room number?");
        roomNumber = input.nextInt();

        System.out.println("How many beds are there?");
        numberOfBeds = input.nextInt();

        System.out.println("How many balconies are there?");
        balcony = input.nextInt();

        System.out.println("How much is the room per night?");
        pricePerNight = input.nextDouble();

        Room newRoom = new Room(roomNumber, numberOfBeds, balcony, pricePerNight);
        listOfRooms.add(newRoom);

        System.out.println("New Room added!");
    }

    private void viewCustomerInfo() {

        System.out.println("      List Of Customers   ");
        for (Customer cus: lisOfCustomer){
            System.out.println(cus);
        }
    }
    private void viewRoomInfo() {

        System.out.println("      List Of Rooms   ");
        for (Room room: listOfRooms){
            System.out.println(room);
        }
    }
}







