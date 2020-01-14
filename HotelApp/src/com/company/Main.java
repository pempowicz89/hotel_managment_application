package com.company;


import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class Main {

    private Scanner input = new Scanner(System.in);

    //This gets the current date

    SimpleDateFormat sdf = new SimpleDateFormat("E, dd-MM-yyyy HH:mm:ss z");
    Calendar cal = Calendar.getInstance();
    //To use this, you write: sdf.format(cal.getTime())
    //If you want to change date:
    //To add days, you write: cal.add(Calendar.DAY_OF_MONTH, 1)  The 1 is how many days you want to add
    //Then you need to make another string: String newDate = sdf.format(cal.getTime())

    //arrays for adding user, booking, customer, and rooms
    private final String passwordRegex = "((Dino)|(Jens)|(Gustav)|(Hassan))";
    private String userName = "";
    private ArrayList<User> listOfStaff = new ArrayList<>();
    private ArrayList<Booking> listOfBookings = new ArrayList<>();
    private ArrayList<Customer> listOfCustomer = new ArrayList<>() {{
        add(new Customer("Vladimir", "4321", false, "Vladidmir",
                "Putin", "987654321", "Kremlin", "002002"));
        add(new Customer("Donald", "1234", false, "Donald",
                "Trump", "123456789", "White House", "001001"));
    }};
    private ArrayList<Room> listOfRooms = new ArrayList<>() {{
        add(new Room(1, 2, 3, "yes", 1000, false));
        add(new Room(2, 3, 4, "no", 1500, false));
        add(new Room(3, 3, 5, "yes", 1900, false));
    }};
    private Date today = new Date(2019, 11, 25, 12, 14);

    private enum Access {ADMIN, GUEST}
    private int menuInt;
    private int loggedInCustomer;
    private int bookingId = 0;
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
        USERNAME, PASSWORD
    }


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

        do {
            printLogInMenu();
            System.out.println("Make your choice: ");
            System.out.println(">>");
            choice = input2.nextInt();

            if (choice == 1) {
                password();
            }
            if (choice == 2) {
                customerPassword();
            }

        } while (choice != 3);
    }

    private void password() {
        String choice2 = "";
        System.out.print("Please enter your password: ");
        choice2 = input.nextLine();
        while (!choice2.matches(passwordRegex)) {
            System.out.println("Enter a valid password!: ");
            System.out.println("To Exit type Return");
            choice2 = input.nextLine();
            if (choice2.equals("Return")) {
                printLogInMenu();
            }
        }
        menuInt = 0;
        handleEditMenu();
    }

    private void customerPassword() {
        String choice = "";
        System.out.println("Please enter your Customer password: ");
        choice = input.nextLine();
        for (Customer c : listOfCustomer){
            if (choice.equals(c.getPassword())) {
                menuInt = 1;
                System.out.println(c.getCustomerId());
                loggedInCustomer = c.getCustomerId();
                System.out.println(loggedInCustomer);
                handleEditMenu();
            }
        }
    }

    private void printLogInMenu() {
        System.out.println("Login Menu");
        System.out.println("--------------------");
        System.out.println("| 1.Staff login          |");
        System.out.println("| 2.Customer login       |");
        System.out.println("| 3.Exit                 |");
        System.out.println("--------------------");

    }
    public void printCustomerMenu() {

        System.out.println("        START MENU                ");
        System.out.println("----------------------------------");
        System.out.println("| 1: View available rooms        |");
        System.out.println("| 2: View booking history        |");
        System.out.println("| 3: Make a new booking          |");
        System.out.println("| 4: Edit your info              |");
        System.out.println("| 5: Check out                   |");
        System.out.println("| 6: Cancel booking              |");
        System.out.println("| 13: Exit to log in menu         |");
        menuInt = 1;


}

    private void startMenu() {
        System.out.println("          START MENU             ");
        System.out.println("---------------------------------");
        System.out.println("| 1.  Add Customer              |");
        System.out.println("| 2.  Remove Customer           |");
        System.out.println("| 3.  Edit Customer info        |");
        System.out.println("| 4.  Edit booking              |");
        System.out.println("| 5.  Add Room                  |");
        System.out.println("| 6.  Edit Room                 |");
        System.out.println("| 7.  Remove Room               |");
        System.out.println("| 8.  Go To Log in Menu         |");
        System.out.println("| 9.  View Customer             |");
        System.out.println("| 10. View Rooms                |");
        System.out.println("| 11. Search For All Booking    |");
        System.out.println("| 12. Add booking               |");
        System.out.println("| 13. Back                      |");
        System.out.println("---------------------------------");
        menuInt = 0;
    }

    private void handleEditMenu() {
        Main hotelApp = new Main();

        int select;
        do {
            if (menuInt == 0){
                startMenu();
            }else if (menuInt == 1){
                printCustomerMenu();
            }
            System.out.print(">>");
            select = input.nextInt();
            input.nextLine();

            if (menuInt == 0) {
                if (select == 1) {
                    hotelApp.addCustomer();
                } else if (select == 2) {
                    hotelApp.removeCustomer();
                } else if (select == 3) {
                    hotelApp.editCustomer();
                } else if (select == 4) {
                    hotelApp.editBooking();
                } else if (select == 5) {
                    hotelApp.addRoom();
                } else if (select == 6) {
                    hotelApp.printMenuEditRoom();
                } else if (select == 7) {
                    hotelApp.removeRoom();
                } else if (select == 8) {
                    hotelApp.printLogInMenu();
                } else if (select == 9) {
                    hotelApp.viewCustomerInfo();
                } else if (select == 10) {
                    hotelApp.viewRoomInfo();
                } else if (select == 11) {
                    hotelApp.searchForAllBookings();
                } else if (select == 12) {
                    hotelApp.addBooking();
                }
            } else if (menuInt == 1) {
                if (select == 1) {
                    hotelApp.availableRooms();
                } else if (select == 2) {
                    hotelApp.bookingHistory();
                } else if (select == 3) {
                    hotelApp.makeABook();
                } else if (select == 4) {
                    hotelApp.editYourInfo();
                } else if (select == 5) {
                    //hotelApp.checkOut();
                } else if (select == 6) {
                    //hotelApp.cancelBooking();
                }
            }

        } while (select != 13);
    }


    private void bookingHistory() {

        System.out.println("This is your booking history: ");
        System.out.println("------------------------------");
        for (Booking b : listOfBookings) {
            if (b.getCustomer() == loggedInCustomer){
                System.out.println("Customer Name :" + b.getCustomerName());
                System.out.println("Customer SSN :" + b.getCustomerSSN());
                System.out.println("Room Number :" + b.getRoomNumber());
                System.out.println("Total Price :" + b.getTotalPrice());
                System.out.println("Booking Time : From " + b.getCheckIn() +
                        " to " + b.getCheckOut());
                System.out.println("------------------------------");
            }
        }
    }

    private void editYourInfo(){
        String select;
        String newData;
        System.out.print("What do you wish to change?: ");
        for (Customer customer : listOfCustomer) {
            System.out.println(customer.getCustomerId() + "   " + loggedInCustomer);
            if (customer.getCustomerId() == loggedInCustomer) {
                System.out.println("TEST2");
                System.out.println("Which option would you like to change?");
                System.out.println("1. Change username");
                System.out.println("2. Change password");
                System.out.println("3. Exit");

                select = input.nextLine();

                switch (select) {
                    case "1": {
                        System.out.println("Current username: " + customer.getUserName());
                        System.out.print("Please input your new username: ");
                        newData = input.nextLine();
                        customer.setUserName(newData);
                        break;

                    }
                    case "2": {
                        System.out.println("Current password: " + customer.getUserName());
                        System.out.print("Please enter your new password: ");
                        newData = input.nextLine();
                        customer.setPassword(newData);
                        break;

                    }
                    case "3": {
                        printCustomerMenu();
                    }
                }
            }

        }


    }

    private void availableRooms() {
        System.out.println("Available rooms: ");
        for (Room r : listOfRooms){
            if (!r.getBooked(false)){
                System.out.println(r);
                System.out.println("-----------------");
            }
        }
    }
    private void makeABook() {
        System.out.println("Welcome to our booking service");
        System.out.println("------------------------------");

        int numberOfNights = 0;
        while (numberOfNights < 1) {
            System.out.println("How many nights do you want to book?");
            numberOfNights = input.nextInt();
            input.nextLine();
            if (numberOfNights < 1) {
                System.out.println("You must book at least one night.");
            }
        }
        int numberOfBeds = 0;
        while (numberOfBeds < 1) {
            System.out.println("How many beds do you want in your room? ");
            numberOfBeds = input.nextInt();
            input.nextLine();
            if (numberOfBeds < 1) {
                System.out.println("You must book at least one bed.");
            }
        }
        String balcony = "";
        while (!balcony.matches("yes|no")){
            System.out.println("Do you want a balcony? yes/no");
            balcony = input.nextLine();
            if ((!balcony.matches("yes|no"))){
                System.out.println("You must answer with yes or no");
            }
        }


        System.out.println("These rooms have what you specified: ");
        for (Room r : listOfRooms){
            if (r.getBeds() >= numberOfBeds && balcony.equals(r.getHasBalcony()) && !r.getBooked(false)){
                System.out.println(r);
            }else{
                System.out.println("No room available with those specifications. (Press enter to continue)");
                input.nextLine();
                break;
            }

            System.out.println("Which room do you want to book? Enter room Id");
            int roomId = input.nextInt();
            input.nextLine();
            String customerName = listOfCustomer.get(loggedInCustomer).getFirstName() + " "
                    + listOfCustomer.get(loggedInCustomer).getLastName();
            String customerSSN = listOfCustomer.get(loggedInCustomer).getSSN();
            String oldDate = sdf.format(cal.getTime());
            cal.add(Calendar.DAY_OF_MONTH, numberOfNights);
            String newDate = sdf.format(cal.getTime());
            Booking newBooking = new Booking(bookingId, loggedInCustomer, customerName, Integer.parseInt(customerSSN), r.getRoomNumber()
                    , r.getPrice(), oldDate, newDate);
            listOfBookings.add(newBooking);
            listOfRooms.get(bookingId).getBooked(true);
            bookingId++;
            System.out.println("Booking made! (Press Enter to Continue)");
            input.nextLine();
            break;
        }

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
                System.out.println("8. Back to Main Menu");

                select = input.nextLine();

                switch (select) {
                    case "1": {
                        System.out.println("Current Username:" + listOfCustomer.get(i).getUserName());
                        System.out.println("Input new Username:");
                        newData = input.nextLine();

                        listOfCustomer.get(i).setUserName(newData);
                        break;
                    }
                    case "2": {
                        System.out.println("Current Password:" + listOfCustomer.get(i).getPassword());
                        System.out.println("Input new Password:");
                        newData = input.nextLine();

                        listOfCustomer.get(i).setPassword(newData);
                        break;
                    }
                    case "3": {
                        System.out.println("Current First Name:" + listOfCustomer.get(i).getFirstName());
                        System.out.println("Input new First Name:");
                        newData = input.nextLine();

                        listOfCustomer.get(i).setFirstName(newData);
                        break;
                    }
                    case "4": {
                        System.out.println("Current Last Name:" + listOfCustomer.get(i).getLastName());
                        System.out.println("Input new Last Name:");
                        newData = input.nextLine();

                        listOfCustomer.get(i).setLastName(newData);
                        break;
                    }
                    case "5": {
                        System.out.println("Current SSN:" + listOfCustomer.get(i).getSSN());
                        System.out.println("Input new SSN:");
                        newData = input.nextLine();

                        listOfCustomer.get(i).setSSN(newData);
                        break;
                    }
                    case "6": {
                        System.out.println("Current Address:" + listOfCustomer.get(i).getAddress());
                        System.out.println("Input new Address:");
                        newData = input.nextLine();

                        listOfCustomer.get(i).setAddress(newData);
                        break;
                    }
                    case "7": {
                        System.out.println("Current Phone Number:" + listOfCustomer.get(i).getTelephoneNumber());
                        System.out.println("Input new Phone Number:");
                        newData = input.nextLine();

                        listOfCustomer.get(i).setTelephoneNumber(newData);
                        break;
                    }
                    case "8": {
                        startMenu();
                    }
                }
            }
        }

    }

    private void addBooking() {
        int customerId;
        int roomNumber;
        String checkIn;
        String checkOut;
        String customerName = "";
        int customerSSN = 0;
        double totalPrice;
        String printCus;
        int choice;
        int days;
        String val;
        System.out.println("If you wish to see what rooms are available type in 10!");
        System.out.print("If you wish to proceed type in any int: ");
        choice = input.nextInt();
        if (choice == 10) {
            viewRoomInfo();
        }

        System.out.println("Welcome to our booking services!");
        System.out.print("Please enter your customer ID : ");
        customerId = input.nextInt();
        Customer customer = findCustomerWithId(customerId);
        if (customer == null) {
            System.out.println("Does not exist");
            startMenu();
        }
        else {
            System.out.println(customer);
            customerName = customer.getFirstName() + " " + customer.getLastName();
            customerSSN = Integer.parseInt(customer.getSSN());
        }

        System.out.print("Please enter the room id that you wish to stay in: ");
        roomNumber = input.nextInt();
        Room rum = findRoomWithId(roomNumber);
        if (rum == null) {
            System.out.println("Does not exist (Press Enter to Continue)");
            input.nextLine();
            startMenu();
        } else if (rum.getBooked(true)){
            System.out.println("This room is already booked. (Press Enter to Continue)");
            input.nextLine();
            startMenu();
        } else {
            System.out.println(rum);
        }

        do {


            System.out.print("Please enter the number of days that you wish to stay: ");
            days = input.nextInt();

            System.out.println("Current date: " + sdf.format(cal.getTime()));
            System.out.println();
            String oldDate = sdf.format(cal.getTime());
            cal.add(Calendar.DAY_OF_MONTH, days);
            String newDate = sdf.format(cal.getTime());
            System.out.println("Date of your check out: " + newDate);
            input.nextLine();
            System.out.println("Is this correct? (Yes/No)");
            val = input.nextLine();
            if (val.equals("Yes")) {
                System.out.println("Room Price per Night: " + findRoomWithId(roomNumber).getPrice());
                System.out.println("Days staying: " + days);
                totalPrice = (findRoomWithId(roomNumber).getPrice() * days);
                System.out.println("Total price for staying: " + totalPrice);

                findRoomWithId(roomNumber).setBooked(true);

                Booking newBooking = new Booking(bookingId, customerId, customerName, customerSSN, roomNumber, totalPrice, oldDate, newDate);

                listOfBookings.add(newBooking);
                bookingId++;
            }

        } while (!val.equals("Yes"));
//      Booking newBooking = new Booking(bookingId, customerId, roomNumber, totalPrice, checkIn, checkOut);


    }

    private void editBooking() {
        int bookingId;
        String newData;
        int newDataInt;

        System.out.println("Which booking do you want to change? Enter booking ID");
        bookingId = input.nextInt();
        input.nextLine();

        for (int i = 0; i < listOfBookings.size(); i++) {
            if (bookingId == listOfBookings.get(i).getBookingId()) {
                int chosenBooking = listOfBookings.get(i).getBookingId();
                System.out.println("Current Booking Id :" + listOfBookings.get(i).getBookingId());
                System.out.println("Current Customer Id :" + listOfBookings.get(i).getCustomer());
                System.out.println("Current Customer Name :" + listOfBookings.get(i).getCustomerName());
                System.out.println("Current Customer SSN :" + listOfBookings.get(i).getCustomerSSN());
                System.out.println("Current Room Number :" + listOfBookings.get(i).getRoomNumber());
                System.out.println("Current Total Price :" + listOfBookings.get(i).getTotalPrice());
                System.out.println("Current Booking Time : From " + listOfBookings.get(i).getCheckIn() +
                        " to " + listOfBookings.get(i).getCheckOut());
                System.out.println("---------------------------");
                System.out.println("What do you want to change?");
                System.out.println("1. Customer Id");
                System.out.println("2. Room Number");
                System.out.println("3. Checkout Date");
                System.out.println("4. Cancel this book");
                System.out.println("5. Back to Main Menu");

                String select = input.nextLine();

                switch (select) {
                    case "1": {
                        System.out.println("Current Customer Id: " + listOfBookings.get(i).getCustomer());
                        System.out.println("Input new Customer Id :");
                        newDataInt = input.nextInt();

                        listOfBookings.get(i).setCustomer(newDataInt);
                        System.out.println("New Customer Id: " + listOfBookings.get(i).getCustomer());
                        System.out.println("(Press Enter to Continue)");
                        input.nextLine();
                        input.nextLine();
                        break;
                    }
                    case "2": {
                        System.out.println("Current Room Number: " + listOfBookings.get(i).getRoomNumber());
                        System.out.println("Input new Room Number: ");
                        newDataInt = input.nextInt();

                        listOfBookings.get(i).setRoomNumber(newDataInt);
                        System.out.println("New Room Data:");
                        System.out.println(listOfRooms.get(i));
                        System.out.println("(Press Enter to Continue)");
                        input.nextLine();
                        input.nextLine();
                        break;
                    }
                    case "3": {
                        System.out.println("Current Checkout Date: " + listOfBookings.get(i).getCheckOut());
                        System.out.println("Input how many days until checkout: ");
                        newDataInt = input.nextInt();


                        cal.add(Calendar.DAY_OF_MONTH, newDataInt);
                        String newDate = sdf.format(cal.getTime());
                        listOfBookings.get(i).setCheckOut(newDate);

                        System.out.println("New Checkout Date: " + newDate);
                        System.out.println("(Press Enter to Continue)");
                        input.nextLine();
                        input.nextLine();
                        break;
                    }
                    case "4": {
                        System.out.println("Would you like to cancel this book? yes/no: " );
                        boolean rightInput;
                        do {
                            newData = input.nextLine();
                            if (newData.equals("yes")) {
                                rightInput = true;
                                listOfBookings.remove(i);

                            } else if (newData.equals("no")){
                                rightInput = false;
                                editBooking();
                            } else {
                                System.out.println("Invalid answer");
                                System.out.println("--------------");
                                editBooking();
                            }
                        } while (rightInput = false);

                        break;


                    }
                    case "5": {
                        startMenu();
                    }
                }
            }
        }
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
                        if (price == 1000 || price == 1500 || price == 1900 || price == 2200) {
                            rightInput = true;
                            try {
                                Room newRoom = new Room(roomNumber, beds, star, hasBalcony, price, false);
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
            System.out.println("\nEDIT ALL INFORMATION\n-------------------------------");
            System.out.printf("%s %5s %7s %11s  |%n", "RNR", "BEDS", "BALCONY", "PRICE(SEK)");
            System.out.printf("%2d %5d %6s %10d     |%n",
                    listOfRooms.get(index).getRoomNumber(), listOfRooms.get(index).getBeds(),
                    listOfRooms.get(index).getHasBalcony(), listOfRooms.get(index).getPrice());
            System.out.println("-------------------------------");
            do {
                counter = 0;
                System.out.print("New RNR: ");
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

            System.out.print("New has Balcony status (yes/no): ");
            temp = input.next();
            if (temp.equalsIgnoreCase("yes") || temp.equalsIgnoreCase("true")) {
                hasBalcony = "yes";
            }

            do {
                System.out.print("New Price per night: ");
                price = input.nextInt();
                if (price != 1000 && price != 1500 && price != 1900 && price != 2200) {
                    System.out.println("\nThe options for prices are 1000 SEK, 1500 SEK, 2000 SEK and 2200 SEK");
                }
            } while (price == 1000 && price == 1500 && price == 1900 && price == 2200);
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
            System.out.printf("%s %5s %7s %11s  |%n", "RNR", "BEDS", "BALCONY", "PRICE(SEK)");
            System.out.printf("%2d %5d %6s %10d     |%n",
                    listOfRooms.get(index).getRoomNumber(), listOfRooms.get(index).getBeds(),
                    listOfRooms.get(index).getHasBalcony(), listOfRooms.get(index).getPrice());
            System.out.println("-------------------------------");
            do {
                counter = 0;
                System.out.print("New RNR: ");
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
            System.out.println("\nEDIT NUMBER OF BEDS\n-------------------------------");
            System.out.printf("%s %5s %7s %11s  |%n", "RNR", "BEDS", "BALCONY", "PRICE(SEK)");
            System.out.printf("%2d %5d %6s %10d     |%n",
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
            System.out.printf("%s %5s %7s %11s  |%n", "RNR", "BEDS", "BALCONY", "PRICE(SEK)");
            System.out.printf("%2d %5d %6s %10d     |%n",
                    listOfRooms.get(index).getRoomNumber(), listOfRooms.get(index).getBeds(),
                    listOfRooms.get(index).getHasBalcony(), listOfRooms.get(index).getPrice());
            System.out.println("-------------------------------");
            System.out.print("New has Balcony status (yes/no): ");
            temp = input.next();
            if (temp.equalsIgnoreCase("yes") || temp.equalsIgnoreCase("true")) {
                hasBalcony = "Yes";
            }
            listOfRooms.get(index).setHasBalcony(hasBalcony);
            System.out.println("\nRoom successfully updated");
        } else if (filt == Filter.PRICE) {
            do {
                counter = 0;
                System.out.print("RNR: ");
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
            System.out.println("\nEdit PRICE\n-------------------------------");
            System.out.printf("%s %5s %7s %11s  |%n", "RNR", "BEDS", "BALCONY", "PRICE(SEK)");
            System.out.printf("%2d %5d %6s %10d     |%n",
                    listOfRooms.get(index).getRoomNumber(), listOfRooms.get(index).getBeds(),
                    listOfRooms.get(index).getHasBalcony(), listOfRooms.get(index).getPrice());
            System.out.println("-------------------------------");
            do {
                System.out.print("New Price: ");
                price = input.nextInt();
                if (price != 1000 && price != 1500 && price != 1900 && price != 2200) {
                    System.out.println("\nThe options for prices are 1000 SEK, 1500 SEK, 2000 SEK and 2200 SEK");
                }
            } while (price == 1000 && price == 1500 && price == 1900 && price == 2200);
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
            System.out.println("Return to Main menu");
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
    private void searchForAllBookings () {
        System.out.println("Search for all bookings");
        System.out.println("----------------------------");
        //System.out.println("Enter a specific customer ID");
        //int p = input.nextInt();

        for (Booking b : listOfBookings) {
            System.out.println("Booking ID: " + b.getBookingId());
            System.out.println("Total price: " + b.getTotalPrice());
            System.out.println("Room Number: " + b.getRoomNumber());
            System.out.println("Customer Id: " + b.getCustomer());
            System.out.println("Customer SSN: " + b.getCustomerSSN());
            System.out.println("Customer Name: " + b.getCustomerName());
            System.out.println("Check in: " + b.getCheckIn());
            System.out.println("Check out: " + b.getCheckOut());
            System.out.println("----------------------");
        }
        /*
        for (int i = 0; i < listOfBookings.size(); i++) {
            listOfBookings.get(i).getBookingId();
            int ID = listOfBookings.get(i).getBookingId();
            if (ID == p);
            {
                System.out.println("Booking ID: " + listOfBookings.get(i).getBookingId());
                System.out.println("Total price: " + listOfBookings.get(i).getTotalPrice());
                System.out.println("Check in: " + listOfBookings.get(i).getCheckIn());
                System.out.println("Check out: " + listOfBookings.get(i).getCheckOut());
                System.out.println("----------------------");
            }

    */
        /*System.out.println("Search for room");
        System.out.println("-----------------------------------------------");

        System.out.println("enter room number");
        int n;
        n = input.nextInt();

        for (Room r : listOfRooms) {

                System.out.println("Room number: " + r.getRoomNumber());
                System.out.println("Number of beds: " + r.getRoomNumber());
                System.out.println("Balcony : " + r.getRoomNumber());
                System.out.println("Price per night: " + r.getRoomNumber());
                System.out.println("Is the room booked: " + r.getRoomNumber());
                System.out.println("-----------------------------------------------");
            }*/
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
        for (Customer cus : listOfCustomer) {
            System.out.println(cus);
        }
        System.out.println("---------------------------");
    }

    private void viewRoomInfo() {

        System.out.println("-----List Of Rooms-----");
        for (Room room : listOfRooms) {
            System.out.println(room);
            System.out.println("--------------------");
        }
        System.out.println("------------------------------");
    }


}







