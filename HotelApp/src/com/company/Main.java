package com.company;


import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private Scanner input = new Scanner(System.in);

    private ArrayList<User> listOfStaff = new ArrayList<>(); //lista med all personal, alla kunder o bokningar
    private ArrayList<Booking> listOfBookings = new ArrayList<>();
    private ArrayList<Customer> lisOfCustomer = new ArrayList<>();
    private Date today = new Date ( 2019, 11, 25, 12, 14 );

    private enum Access {ADMIN, GUEST} // lägger till alla admins och staff



    public static void main(String[] args) { //Här skriver vi ut "Staffs" inloggningsuppgifter.
        Main hotelApp = new Main();
        hotelApp.listOfStaff.add(new User("Hassan", "Mousavi", true));
        hotelApp.listOfStaff.add(new User("Jens", "Lindström", true));
        hotelApp.listOfStaff.add(new User("Gustav", "Svensson", true));
        hotelApp.listOfStaff.add(new User("Dino", "Tuzlak", true));

        Customer cus1 = new Customer("Donald", "1234", false, "Donald",
                "Trump", "123456789", "White House", "001001");
        Customer cus2 = new Customer("Vladimir", "4321", false, "Vladidmir",
                "Putin", "987654321", "Kremlin", "002002");
        
            // Costumer, är alla som bor på hotellet. här implementerar vi från klassen costumer.

    }
        private void printLogInMeny(){
            System.out.println("-----Login Menu-----");
            System.out.println("--------------------");
            System.out.println("-----1) Admin login-----");
            System.out.println("--------------------");
            System.out.println("-----2) Costumer login------");
            System.out.println("--------------------");

    }
        private void printAdminMenu(){
            System.out.println("-------Admin Menu-------");
            System.out.println("--------------------");
            System.out.println("--------1) Go to edit menu------------");
            System.out.println("--------------------");
            System.out.println("-------2) View menu-------------");
            System.out.println("--------------------");
            System.out.println("--------3) Go to previous menu------------");
            System.out.println("--------------------");

        }
        private void printEditMenu(){
            System.out.println("--------Edit menu------------");
            System.out.println("--------------------");
            System.out.println("-------1) Add costumer-------------");
            System.out.println("--------------------");
            System.out.println("---------2) Remove costumer-----------");
            System.out.println("--------------------");
            System.out.println("-------3) Edit costumer info-------------");
            System.out.println("--------------------");
            System.out.println("-------4) Edit booking -------------");
            System.out.println("--------------------");
            System.out.println("---------5) Add room-----------");
            System.out.println("--------------------");
            System.out.println("---------6) Edit room-----------");
            System.out.println("--------------------");
            System.out.println("--------7) Remove room------------");
            System.out.println("--------------------");
            System.out.println("-------8) Go to admin menu-------------");

    }

        private void printViewMenu(){
        System.out.println("--------View Menu----------");
        System.out.println("--------------------");
        System.out.println("--------1) View costumer------------");
        System.out.println("--------------------");
        System.out.println("-------2) View rooms-------------");
        System.out.println("--------------------");
        System.out.println("--------3) Search for all booking------------");
        System.out.println("--------------------");
        System.out.println("-------4) Go to admin menu-------------");








    }
}
