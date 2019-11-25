package com.company;


import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private Scanner input = new Scanner(System.in);

    private ArrayList<User> listOfUsers = new ArrayList<>();
    private ArrayList<Booking> listOfBookings = new ArrayList<>();
    private ArrayList<Customer> lisOfCustomer = new ArrayList<>();
    private Date today = new Date ( 2019, 11, 25, 12, 14 );

    private enum Access {ADMIN, GUEST}


    public static void main(String[] args) {
        Main hotelApp = new Main();
        hotelApp.listOfUsers.add(new User("Hassan", "Mousavi", true));
        hotelApp.listOfUsers.add(new User("Jens", "Lindström", true));
        hotelApp.listOfUsers.add(new User("Gustav", "Svensson", true));
        hotelApp.listOfUsers.add(new User("Dino", "Tuzlak", true));

        Customer cus1 = new Customer("Donald", "1234", false, "Donald",
                "Trump", "123456789", "White House", "001001");
        Customer cus2 = new Customer("Vladimir", "4321", false, "Vladidmir",
                "Putin", "987654321", "Kremlin", "002002");
        








    }
}
