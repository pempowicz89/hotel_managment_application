package com.company;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {

    private Scanner input = new Scanner(System.in);

    //arrays for adding user, booking, customer, and rooms

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

    private void runProgram() {
        Scanner input2 = new Scanner(System.in);
        int choice;

        //four of staffs or admins added manually

        listOfStaff.add(new User("Hassan", "Mousavi", true));
        listOfStaff.add(new User("Jens", "Lindström", true));
        listOfStaff.add(new User("Gustav", "Svensson", true));
        listOfStaff.add(new User("Dino", "Tuzlak", true));

        //two guests or user added manually

        Customer cus1 = new Customer("Donald", "1234", false, "Donald",
                "Trump", "123456789", "White House", "001001");
        Customer cus2 = new Customer("Vladimir", "4321", false, "Vladidmir",
                "Putin", "987654321", "Kremlin", "002002");

        lisOfCustomer.add(cus1);
        lisOfCustomer.add(cus2);


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
                System.out.println("Under Construction");
            } else if (select == 3) {
                System.out.println("Under Construction");
            } else if (select == 4) {
                System.out.println("Under Construction");
            } else if (select == 5) {
                hotelApp.addRoom();
            } else if (select == 6) {
                System.out.println("Under Construction");
            } else if (select == 7) {
                System.out.println("Under Construction");
            } else if (select == 8) {
                System.out.println("Under Construction");
            } else if (select == 9) {
                hotelApp.viewCustomerInfo();
            } else if (select == 10) {
                hotelApp.viewRoomInfo();
            } else if (select == 11) {
                System.out.println("Under Construction");

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

    private void addBooking (){
        int customerId;
        int bookingId, roomNumber;
        String checkIn;
        String checkOut;
        double totalPrice;
        int choice;
        System.out.println("If you wish to see what rooms are available go back to the previous menu and press 11!");
        choice = input.nextInt();
        if (choice == 11){
            handleEditMenu();
        }

        System.out.println("Welcome to our booking services!");

        System.out.print("Please enter the room id that you wish to stay in: ");
        bookingId = input.nextInt();
        System.out.print("Please enter when you will check in: ");
        checkIn = input.nextLine();
        System.out.print("Please enter your check out date: ");
        checkOut = input.nextLine();
//        Booking newBooking = new Booking(bookingId, customerId, roomNumber, totalPrice, checkIn, checkOut);




    }

    private void addRoom() { // method adding room

        int roomNumber = 0;
        int beds = 0;
        int star = 0;
        String select;
        String reply;
        boolean rightInput;


        do {
            System.out.println("--------Add Room--------");
            System.out.println("|1. Register Room      |");
            System.out.println("|2. Back to Start Menu |");
            System.out.println("------------------------");
            select = input.nextLine();

            switch (select) {
                case "1":
                    System.out.println("Enter number of room: ");
                    do {
                        reply = input.nextLine();
                        try {
                            roomNumber = Integer.parseInt(reply);
                            rightInput = true;
                        } catch (NumberFormatException e) {
                            rightInput = false;
                        }
                        if (0 < roomNumber) {
                            rightInput = true;
                        } else {
                            rightInput = false;
                            System.out.println("Invalid input. Number of room should be greater than 0" +
                                    "\nTry again:");
                        }
                    } while (!rightInput);

                    System.out.println("Enter number of beds (1,2,3 or 4): ");
                    do {
                        reply = input.nextLine();
                        try {
                            beds = Integer.parseInt(reply);
                            rightInput = true;
                        } catch (NumberFormatException e) {
                            rightInput = false;
                        }

                        if (beds == 1 || beds == 2 || beds == 3 || beds == 4) {
                            rightInput = true;
                        } else {
                            rightInput = false;
                            System.out.println("Invalid input. Number of beds must be entered accordingly: " +
                                    "1, 2, 3 or 4. \nTry again:");
                        }
                    } while (!rightInput);

                    System.out.println("Enter The room star (3-5): ");
                    do {
                        reply = input.nextLine();
                        try {
                            star = Integer.parseInt(reply);
                            rightInput = true;
                        } catch (NumberFormatException e) {
                            rightInput = false;
                        }
                        if (star == 3 || star == 4 || star == 5) {
                            rightInput = true;
                            try {
                                Room newRoom = new Room(roomNumber, beds, star);
                                listOfRooms.add(newRoom);
                                System.out.println("New room has been created!");
                            }catch(IllegalArgumentException e) {
                                System.out.println(e.getMessage());
                            }
                            System.out.println("Back (Enter)");
                            input.nextLine();
                        } else {
                            rightInput = false;
                            System.out.println("Invalid input. Star must be entered accordingly: 1-3." +
                                    "\nTry again:");
                        }

                    } while (!rightInput);

                    break;

                case "2":
                    System.out.println("Returning to the previous menu!");
                    startMenu();
                    handleEditMenu();

                    break;

                default:
                    System.out.println("Faulty input recognized. Try again!\nPress (Enter)");
                    input.nextLine();
                    break;
            }
        } while (!select.equalsIgnoreCase("1") && !select.equalsIgnoreCase("0"));
    }


    private void viewCustomerInfo() {

        System.out.println("-----List Of Customers-----");
        for (Customer cus: lisOfCustomer){
            System.out.println(cus);
        }
        System.out.println("---------------------------");
    }
    private void viewRoomInfo() {

        System.out.println("-----List Of Rooms-----");
        for (Room room: listOfRooms){
            System.out.println(room);
        }
        System.out.println("-----------------------");
    }


}







