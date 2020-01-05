package com.company;


import java.util.ArrayList;
import java.util.Scanner;


public class Main {

    private Scanner input = new Scanner(System.in);

    //arrays for adding user, booking, customer, and rooms

    private String userName = "";
    private ArrayList<User> listOfStaff = new ArrayList<>();
    private ArrayList<Booking> listOfBookings = new ArrayList<>();
    private ArrayList<Customer> listOfCustomer = new ArrayList<>();
    private ArrayList<Room> listOfRooms = new ArrayList<>();
    private Date today = new Date(2019, 11, 25, 12, 14);

    private enum Access {ADMIN, GUEST}

    private enum Motive {
        VIEW, BOOKING, REMOVE,
        CHECKOUT, NULL,
        EDIT
    }

    private enum Filter {
        ALL, AVAILABLE, BOOKED,
        NAME, SSN, PHONE, ADDRESS,
        ADD, EDIT, REMOVE,
        RNR, BEDS, BALCONY, PRICE,
        ID, CHECKOUT,
        ROOM,
        USERNAME, PASSWORD }


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

        /*Customer cus1 = new Customer("Donald", "1234", false, "Donald",
                "Trump", "123456789", "White House", "001001");
        Customer cus2 = new Customer("Vladimir", "4321", false, "Vladidmir",
                "Putin", "987654321", "Kremlin", "002002");

        listOfCustomer.add(cus1);
        listOfCustomer.add(cus2);*/


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
        System.out.println("| 12. Add booking               |");
        System.out.println("| 13. Back                      |");
        System.out.println("--------------------------------");
    }

    private void handleEditMenu() {
        Main hotelApp = new Main();

        int select;
        do {
            startMenu();
            System.out.print(">>");
            select = input.nextInt();
            input.nextLine();
            if (select == 1) {
                hotelApp.addCustomer();
            } else if (select == 2) {
                hotelApp.removeCustomer();
            } else if (select == 3) {
                hotelApp.editCustomer();
            } else if (select == 4) {
                System.out.println("Under Construction");
            } else if (select == 5) {
                hotelApp.addRoom();
            } else if (select == 6) {
                hotelApp.printMenuEditRoom();
            } else if (select == 7) {
                hotelApp.removeRoom();
            } else if (select == 8) {
                System.out.println("Under Construction");
            } else if (select == 9) {
                hotelApp.viewCustomerInfo();
            } else if (select == 10) {
                hotelApp.viewRoomInfo();
            } else if (select == 11) {
                System.out.println("Under Construction");
            } else if (select == 12) {
                hotelApp.addBooking();
            }
        } while (select != 13);
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
        listOfCustomer.add(newCustomer);

        System.out.println("New Customer added!");
    }

    private void removeCustomer() {

        int customerID;
        boolean foundID = false;
        String select;

        System.out.println("Which Customer do you want to remove? Enter Customer ID");
        customerID = input.nextInt();
        input.nextLine();

        for (int i = 0; i < listOfCustomer.size(); i++) {
            if (customerID == listOfCustomer.get(i).getCustomerId()) {
                int chosenCustomer = listOfCustomer.get(i).getCustomerId();
                System.out.println(listOfCustomer.get(i).getCustomerId());
                System.out.println(listOfCustomer.get(i).getFirstName());
                System.out.println(listOfCustomer.get(i).getLastName());
                System.out.println(listOfCustomer.get(i).getSSN());
                System.out.println(listOfCustomer.get(i).getAddress());
                foundID = true;
                System.out.println("Is this the Customer you want to remove? Y/N");
                select = input.nextLine();

                switch (select) {
                    case "y":
                    case "yes": {
                        System.out.println("Customer with ID " + listOfCustomer.get(i).getCustomerId() + " has been " +
                                "removed! Press Enter to Continue");
                        listOfCustomer.remove(i);
                        input.nextLine();
                    }
                    case "n":
                    case "no": {
                        System.out.println("Customer with ID " + listOfCustomer.get(i).getCustomerId() + " has not been" +
                                "removed! Press Enter to Continue");
                        input.nextLine();
                    }
                    default: {
                        System.out.println("Invalid Input. Answer yes/y or no/n");
                        input.nextLine();
                        break;
                    }
                }
            }
        }
        if (foundID == false) {
            System.out.println("No Customer has that ID.");
            input.nextLine();
        }

    }

    private void editCustomer() {

        int customerID;
        String select;
        String newData;

        System.out.println("Which Customer do you want to change? Enter Customer ID");
        customerID = input.nextInt();
        input.nextLine();

        for (int i = 0; i < listOfCustomer.size(); i++) {
            if (customerID == listOfCustomer.get(i).getCustomerId()) {
                int chosenCustomer = listOfCustomer.get(i).getCustomerId();

                System.out.println("What do you want to change?");
                System.out.println("1. Username");
                System.out.println("2. Password");
                System.out.println("3. First Name");
                System.out.println("4. Last Name");
                System.out.println("5. SSN");
                System.out.println("6. Address");
                System.out.println("7. Phone Number");

                select = input.nextLine();

                switch (select) {
                    case "1": {
                        System.out.println("Current Username:" + listOfCustomer.get(i).getUserName());
                        System.out.println("Input new Username:");
                        newData = input.nextLine();

                        listOfCustomer.get(i).setUserName(newData);
                    }
                    case "2": {
                        System.out.println("Current Password:" + listOfCustomer.get(i).getPassword());
                        System.out.println("Input new Password:");
                        newData = input.nextLine();

                        listOfCustomer.get(i).setPassword(newData);
                    }
                    case "3": {
                        System.out.println("Current First Name:" + listOfCustomer.get(i).getFirstName());
                        System.out.println("Input new First Name:");
                        newData = input.nextLine();

                        listOfCustomer.get(i).setFirstName(newData);
                    }
                    case "4": {
                        System.out.println("Current Last Name:" + listOfCustomer.get(i).getLastName());
                        System.out.println("Input new Last Name:");
                        newData = input.nextLine();

                        listOfCustomer.get(i).setLastName(newData);
                    }
                    case "5": {
                        System.out.println("Current SSN:" + listOfCustomer.get(i).getSSN());
                        System.out.println("Input new SSN:");
                        newData = input.nextLine();

                        listOfCustomer.get(i).setSSN(newData);
                    }
                    case "6": {
                        System.out.println("Current Address:" + listOfCustomer.get(i).getAddress());
                        System.out.println("Input new Address:");
                        newData = input.nextLine();

                        listOfCustomer.get(i).setAddress(newData);
                    }
                    case "7": {
                        System.out.println("Current Phone Number:" + listOfCustomer.get(i).getTelephoneNumber());
                        System.out.println("Input new Phone Number:");
                        newData = input.nextLine();

                        listOfCustomer.get(i).setTelephoneNumber(newData);
                    }
                }
            }
        }

    }

    private void addBooking() {
        int customerId;
        int bookingId, roomNumber;
        String checkIn;
        String checkOut;
        double totalPrice;
        String printCus;
        int choice;
        System.out.println("If you wish to see what rooms are available type in 10!");
        System.out.print("If you wish to proceed type in any int: ");
        choice = input.nextInt();
        if (choice == 10) {
            viewRoomInfo();}

            System.out.println("Welcome to our booking services!");
        System.out.print("Please enter your customer ID : ");
        customerId = input.nextInt();
        Customer customer = findCustomerWithId(customerId);
        if (customer == null) {
            System.out.println("Does not exist");
        } else {
            System.out.println(customer);
        }

        System.out.print("Please enter the room id that you wish to stay in: ");
        bookingId = input.nextInt();
        Room rum = findRoomWithId(bookingId);
        if (rum == null){
            System.out.println("Does not exist");
        } else {
            System.out.println(rum);
        }

        System.out.println("Please enter when you will check in: ");
        checkIn = input.nextLine();

        System.out.print("Please enter your check out date: ");
        checkOut = input.nextLine();

//      Booking newBooking = new Booking(bookingId, customerId, roomNumber, totalPrice, checkIn, checkOut);


    }

    private void addRoom() { // method adding room

        int roomNumber = 0;
        int beds = 0;
        int star = 0;
        String hasBalcony = "No";
        int price = 0;
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
                    System.out.println("Enter room Number: ");
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
                        } else {
                            rightInput = false;
                            System.out.println("Invalid input. Star must be entered accordingly: 1-3." +
                                    "\nTry again:");
                        }
                    } while (!rightInput);

                    System.out.println("Does the room has balcony?(yes/no) ");
                    hasBalcony = input.nextLine();
                    if (hasBalcony.equals("yes") || hasBalcony.equals("no")) {
                        rightInput = true;
                    } else {
                        rightInput = false;
                        System.out.println("The answer should be (yes) or (no)" +
                                "\nTry again:");
                    }


                    System.out.println("Enter the price (1000 SEK - 1500 SEK - 1900 SEK - 2200 SEK ): ");
                    do {
                        reply = input.nextLine();
                        try {
                            price = Integer.parseInt(reply);
                            rightInput = true;
                        } catch (NumberFormatException e) {
                            rightInput = false;
                        }
                        if (price == 1000 || price == 1500 || price == 1900 || price ==2200 ) {
                            rightInput = true;
                            try {
                                Room newRoom = new Room(roomNumber, beds, star, hasBalcony, price);
                                listOfRooms.add(newRoom);
                                System.out.println("New room has been created!");
                            } catch (IllegalArgumentException e) {
                                System.out.println(e.getMessage());
                            }
                            System.out.println("Back (Enter)");
                            input.nextLine();
                        } else {
                            rightInput = false;
                            System.out.println("Invalid input. \"The options for prices are 1000 SEK, 1500 SEK, 2000 SEK and 2200 " +
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

    private void printMenuEditRoom() {
        int choice;
        String stringChoice;

        System.out.println("                   EDIT ROOM                     ");
        System.out.println("-------------------------------------------------");
        System.out.println("| 1. Edit Room Number                            |");
        System.out.println("| 2. Edit Number Of Beds                         |");
        System.out.println("| 3. Edit Price                                  |");
        System.out.println("| 4. Edit Balcony Status                         |");
        System.out.println("| 5. Edit All Room Attributes                    |");
        System.out.println("| 6. Back To Main Menu                           |");
        System.out.println("-------------------------------------------------");
        System.out.print("Enter your choice >>");
        stringChoice = input.next();
        if (!stringChoice.equals("1") && !stringChoice.equals("2") && !stringChoice.equals("3") &&
                !stringChoice.equals("4") && !stringChoice.equals("5") && !stringChoice.equals("6")) {
            if (stringChoice.equals(".")) {
                startMenu();
            }

        } else {
            choice = Integer.valueOf(stringChoice);

            switch (choice) {
                case 1:
                    editRoom(Filter.RNR);
                    break;
                case 2:
                    editRoom(Filter.BEDS);
                    break;
                case 3:
                    editRoom(Filter.PRICE);
                    break;
                case 4:
                    editRoom(Filter.BALCONY);
                    break;
                case 5:
                    editRoom(Filter.ALL);
                    break;
                case 6: // Back to startMenu
                    break;
            }
        }
    }

    private void editRoom(Filter filt) {
        String stringChoice, temp;
        int roomNumber, beds, counter, index = 99;
        String hasBalcony = "No";
        int price;

        viewRoomInfo();
        if (filt == Filter.ALL) {
            do {
                counter = 0;
                System.out.print("Enter ROOM NUMBER: ");
                roomNumber = input.nextInt();
                for (int i = 0; i < listOfRooms.size(); i++) {
                    if (listOfRooms.get(i).getRoomNumber() != roomNumber) {
                        counter++;
                    }
                }
                if (counter == listOfRooms.size()) {
                    System.out.println("\nROOM NUMBER [" + roomNumber + "] does not exist in room directory");
                }
            } while (counter == listOfRooms.size());

            for (int i = 0; i < listOfRooms.size(); i++) {
                if (listOfRooms.get(i).getRoomNumber() == roomNumber) {
                    index = i;
                    break;
                }
            }
            System.out.println("\nEDIT ALL INFORMATION\n-------------------------------");
            System.out.printf("%s %5s %7s %11s |%n", "ROOM NUMBER", "BEDS", "BALCONY", "PRICE (SEK)");
            System.out.printf("%2d %5d %6s %10.2f    |%n",
                    listOfRooms.get(index).getRoomNumber(), listOfRooms.get(index).getBeds(),
                    listOfRooms.get(index).getHasBalcony(), listOfRooms.get(index).getPrice());
            System.out.println("-------------------------------");
            do {
                counter = 0;
                System.out.print("New ROOM NUMBER: ");
                roomNumber = input.nextInt();
                for (int i = 0; i < listOfRooms.size(); i++) {
                    if (listOfRooms.get(i).getRoomNumber() == roomNumber && i != index || roomNumber <= 0 || roomNumber >= 100) {
                        counter++;
                    }
                }
                if (counter != 0) {
                    System.out.println("\nROOM NUMBER [" + roomNumber + "] is already in use or out-of-bounds");
                }
            } while (counter != 0);

            do {
                counter = 0;
                System.out.print("New Number of beds: ");
                beds = input.nextInt();
                if (beds != 1 && beds != 2 && beds != 3 && beds != 4) {
                    System.out.println("\nRoom can hold one, two, three or four beds");
                }
            } while (beds != 1 && beds != 2 && beds != 3 && beds != 4);

            System.out.print("New has Balcony status (true/false): ");
            temp = input.next();
            if (temp.equalsIgnoreCase("yes") || temp.equalsIgnoreCase("true")) {
                hasBalcony = "yes";
            }

            do {
                System.out.print("New Price per night: ");
                price = input.nextInt();
                if (price == 1000 || price == 1500 || price == 1900 || price ==2200 ) {
                    System.out.println("\nHotel's price range for rooms are (1000 - 2200 SEK) / per night");
                }
            } while (price == 1000 || price == 1500 || price == 1900 || price ==2200 );
            listOfRooms.get(index).setRoomNumber(roomNumber);
            listOfRooms.get(index).setBeds(beds);
            listOfRooms.get(index).setHasBalcony(hasBalcony);
            listOfRooms.get(index).setPrice(price);
            System.out.println("\nRoom successfully updated");
        } else if (filt == Filter.RNR) {
            do {
                counter = 0;
                System.out.print("Enter RNR: ");
                roomNumber = input.nextInt();
                for (int i = 0; i < listOfRooms.size(); i++) {
                    if (listOfRooms.get(i).getRoomNumber() != roomNumber) {
                        counter++;
                    }
                }
                if (counter == listOfRooms.size()) {
                    System.out.println("\nRNR [" + roomNumber + "] does not exist in room directory");
                }
            } while (counter == listOfRooms.size());

            for (int i = 0; i < listOfRooms.size(); i++) {
                if (listOfRooms.get(i).getRoomNumber() == roomNumber) {
                    index = i;
                    break;
                }
            }
            System.out.println("\nEDIT RNR\n-------------------------------");
            System.out.printf("%s %5s %7s %11s |%n", "RNR", "BEDS", "BALCONY", "PRICE (SEK)");
            System.out.printf("%2d %5d %6s %10.2f    |%n",
                    listOfRooms.get(index).getRoomNumber(), listOfRooms.get(index).getBeds(),
                    listOfRooms.get(index).getHasBalcony(), listOfRooms.get(index).getPrice());
            System.out.println("-------------------------------");
            do {
                counter = 0;
                System.out.print("New ROOM NUMBER: ");
                roomNumber = input.nextInt();
                for (int i = 0; i < listOfRooms.size(); i++) {
                    if (listOfRooms.get(i).getRoomNumber() == roomNumber && i != index || roomNumber <= 0 || roomNumber >= 100) {
                        counter++;
                    }
                }
                if (counter != 0) {
                    System.out.println("\nROOM NUMBER [" + roomNumber + "] is already in use or out-of-bounds");
                }
            } while (counter != 0);
            listOfRooms.get(index).setRoomNumber(roomNumber);
            System.out.println("\nRoom successfully updated");
        } else if (filt == Filter.BEDS) {
            do {
                counter = 0;
                System.out.print("Enter ROOM NUMBER: ");
                roomNumber = input.nextInt();
                for (int i = 0; i < listOfRooms.size(); i++) {
                    if (listOfRooms.get(i).getRoomNumber() != roomNumber) {
                        counter++;
                    }
                }
                if (counter == listOfRooms.size()) {
                    System.out.println("\nROOM NUMBER [" + roomNumber + "] does not exist in room directory");
                }
            } while (counter == listOfRooms.size());

            for (int i = 0; i < listOfRooms.size(); i++) {
                if (listOfRooms.get(i).getRoomNumber() == roomNumber) {
                    index = i;
                    break;
                }
            }
            System.out.println("\nEDIT NUMBER OF BEDS\n-------------------------------");
            System.out.printf("%s %5s %7s %11s |%n", "RNR", "BEDS", "BALCONY", "PRICE (SEK)");
            System.out.printf("%2d %5d %6s %10.2f    |%n",
                    listOfRooms.get(index).getRoomNumber(), listOfRooms.get(index).getBeds(),
                    listOfRooms.get(index).getHasBalcony(), listOfRooms.get(index).getPrice());
            System.out.println("-------------------------------");
            do {
                System.out.print("New Number of beds: ");
                beds = input.nextInt();
                if (beds != 1 && beds != 2 && beds != 3 && beds != 4) {
                    System.out.println("\nRoom can hold one, two, three or four beds");
                }
            } while (beds != 1 && beds != 2 && beds != 3 && beds != 4);
            listOfRooms.get(index).setBeds(beds);
            System.out.println("\nRoom successfully updated");
        } else if (filt == Filter.BALCONY) {
            do {
                counter = 0;
                System.out.print("Enter RNR: ");
                roomNumber = input.nextInt();
                for (int i = 0; i < listOfRooms.size(); i++) {
                    if (listOfRooms.get(i).getRoomNumber() != roomNumber) {
                        counter++;
                    }
                }
                if (counter == listOfRooms.size()) {
                    System.out.println("\nRNR [" + roomNumber + "] does not exist in room directory");
                }
            } while (counter == listOfRooms.size());

            for (int i = 0; i < listOfRooms.size(); i++) {
                if (listOfRooms.get(i).getRoomNumber() == roomNumber) {
                    index = i;
                    break;
                }
            }
            System.out.println("\nEDIT HAS BALCONY\n-------------------------------");
            System.out.printf("%s %5s %7s %11s |%n", "ROOM NUMBER", "BEDS", "BALCONY", "PRICE (SEK)");
            System.out.printf("%2d %5d %6s %10.2f    |%n",
                    listOfRooms.get(index).getRoomNumber(), listOfRooms.get(index).getBeds(),
                    listOfRooms.get(index).getHasBalcony(), listOfRooms.get(index).getPrice());
            System.out.println("-------------------------------");
            System.out.print("New has Balcony status (true/false): ");
            temp = input.next();
            if (temp.equalsIgnoreCase("yes") || temp.equalsIgnoreCase("true")) {
                hasBalcony = "Yes";
            }
            listOfRooms.get(index).setHasBalcony(hasBalcony);
            System.out.println("\nRoom successfully updated");
        } else if (filt == Filter.PRICE) {
            do {
                counter = 0;
                System.out.print("Enter ROOM NUMBER: ");
                roomNumber = input.nextInt();
                for (int i = 0; i < listOfRooms.size(); i++) {
                    if (listOfRooms.get(i).getRoomNumber() != roomNumber) {
                        counter++;
                    }
                }
                if (counter == listOfRooms.size()) {
                    System.out.println("\nROOM NUMBER [" + roomNumber + "] does not exist in room directory");
                }
            } while (counter == listOfRooms.size());

            for (int i = 0; i < listOfRooms.size(); i++) {
                if (listOfRooms.get(i).getRoomNumber() == roomNumber) {
                    index = i;
                    break;
                }
            }
            System.out.println("\nEDIT RNR\n-------------------------------");
            System.out.printf("%s %5s %7s %11s |%n", "ROOM NUMBER", "BEDS", "BALCONY", "PRICE (SEK)");
            System.out.printf("%2d %5d %6s %10.2f    |%n",
                    listOfRooms.get(index).getRoomNumber(), listOfRooms.get(index).getBeds(),
                    listOfRooms.get(index).getHasBalcony(), listOfRooms.get(index).getPrice());
            System.out.println("-------------------------------");
            do {
                System.out.print("New Price per night: ");
                price = input.nextInt();
                if (price == 1000 || price == 1500 || price == 1900 || price ==2200 ) {
                    System.out.println("\nHotel's price range for rooms are (1000 - 2500 SEK) / per night");
                }
            } while (price == 1000 || price == 1500 || price == 1900 || price ==2200 );
            listOfRooms.get(index).setPrice(price);
            System.out.println("\nRoom successfully updated");
        }
        System.out.print("Press any key >>");
        stringChoice = input.next();
        if (stringChoice.equals(".")) {
            printMenuEditRoom();
        } else if (stringChoice.equals("..")) {
            startMenu();
        } else if (stringChoice.equals("...")) {
            // back to startMenu
        } else if (stringChoice.equals(".r") && filt == Filter.RNR) {
            editRoom(Filter.RNR);
        } else if (stringChoice.equals(".r") && filt == Filter.BEDS) {
            editRoom(Filter.BEDS);
        } else if (stringChoice.equals(".r") && filt == Filter.BALCONY) {
            editRoom(Filter.BALCONY);
        } else if (stringChoice.equals(".r") && filt == Filter.PRICE) {
            editRoom(Filter.PRICE);
        } else if (stringChoice.equals(".r") && filt == Filter.ALL) {
            editRoom(Filter.ALL);
        } else {
            System.out.println("Hehehehe");
        }
    }


    private void removeRoom() {
        int roomNumber;
        int beds;
        int star;
        String hasBalcony;
        int price = 0;
        int select;
        String reply;
        int counter;
        int index = 99;

        System.out.println("--------Remove Room--------");
        System.out.println("|1. Remove Room      |");
        System.out.println("|2. Back to Start Menu |");
        System.out.println("------------------------");
        select = input.nextInt();

        if (select == 1) {
            do {
                counter = 0;
                System.out.println("Enter the room number: ");
                roomNumber = input.nextInt();
                for (int i = 0; i < listOfRooms.size(); i++) {
                    if (listOfRooms.get(i).getRoomNumber() != roomNumber) {
                        counter++;
                    }
                }
                if (counter == listOfRooms.size()) {
                    System.out.println("\nRNR [" + roomNumber + "] does not exist in room directory");
                }
            } while (counter == listOfRooms.size());

            for (int i = 0; i < listOfRooms.size(); i++) {
                if (listOfRooms.get(i).getRoomNumber() == roomNumber) {
                    index = i;
                    break;
                }
            }

            System.out.println("\nREMOVE ROOM\n-------------------------------");
            System.out.println("Number of room: " + listOfRooms.get(index).getRoomNumber() +
                    "\nNumber of Beds: " + listOfRooms.get(index).getBeds() +
                    "\nRoom has balcony: " + listOfRooms.get(index).getHasBalcony() +
                    "\nPrice: " + listOfRooms.get(index).getPrice() +
                    "\nHow many stars has the room: " + listOfRooms.get(index).getStar());
            System.out.println("-------------------------------");
            System.out.print("Are you sure? (y/n): ");
            reply = input.next();
            if (reply.equalsIgnoreCase("y") || reply.equalsIgnoreCase("yes")) {
                listOfRooms.remove(index);
                System.out.println("\nRoom successfully removed");
            } else if (select == 2) {
                handleEditMenu();
                startMenu();
            } else {
                System.out.println("Faulty input recognized. Try again!\nPress (Enter)");
                input.nextLine();
            }
        }
    }

    private Customer findCustomerWithId(int customerId) {
        for (int i = 0; i < listOfCustomer.size(); i++) {
            if (listOfCustomer.get(i).getCustomerId() == customerId) {
                return listOfCustomer.get(i);
            }
        }
        return null;
    }
    private Room findRoomWithId(int roomId) {
        for (int i = 0; i < listOfRooms.size(); i++) {
            if (listOfRooms.get(i).getRoomNumber() == roomId) {
                return listOfRooms.get(i);
            }
        }
        return null;
    }

    private void viewCustomerInfo() {
        System.out.println("-----List Of Customers-----");
        for (Customer cus: listOfCustomer){
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







