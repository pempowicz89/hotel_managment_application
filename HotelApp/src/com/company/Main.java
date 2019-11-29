package com.company;


import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private Scanner input = new Scanner(System.in);

    private ArrayList<User> listOfStaff = new ArrayList<>(); //lista med all personal, alla kunder o bokningar
    private ArrayList<Booking> listOfBookings = new ArrayList<>();
    private ArrayList<Customer> lisOfCustomer = new ArrayList<>();
    private Date today = new Date(2019, 11, 25, 12, 14);

    private enum Access {ADMIN, GUEST} // lägger till alla admins och staff
    
    public static void main(String[] args) { //Här skriver vi ut "Staffs" inloggningsuppgifter.
        Main hotelApp = new Main();
        hotelApp.runProgram();
    }
    
    private void runProgram() {
        Scanner input2 = new Scanner(System.in);
        // för att välja numret som tar dig till en meny
        int choice;

        listOfStaff.add(new User("Hassan", "Mousavi", true));
        listOfStaff.add(new User("Jens", "Lindström", true));
        listOfStaff.add(new User("Gustav", "Svensson", true));
        listOfStaff.add(new User("Dino", "Tuzlak", true));

        Customer cus1 = new Customer("Donald", "1234", false, "Donald",
                "Trump", "123456789", "White House", "001001");
        Customer cus2 = new Customer("Vladimir", "4321", false, "Vladidmir",
                "Putin", "987654321", "Kremlin", "002002");

        // Costumer, är alla som bor på hotellet. här implementerar vi från klassen costumer.
        do {//skriver ut första menyn.
            printLogInMeny();
            System.out.println("Make your choice: ");
            choice = input2.nextInt();
            if (choice == 1) {
                handleEditMenu();
            }
        } while (choice != 2);
    }

    private void printLogInMeny() {
        System.out.println("-----Login Menu-----");
        System.out.println("--------------------");
        System.out.println("-----1) Admin login-----");
        System.out.println("--------------------");
        System.out.println("-----2) Exit ------");
        System.out.println("--------------------");

    }

    private void printEditMenu() {
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
        System.out.println("--------------------");
        System.out.println("--------9) View costumer------------");
        System.out.println("--------------------");
        System.out.println("-------10) View rooms-------------");
        System.out.println("--------------------");
        System.out.println("--------11) Search for all booking------------");
        System.out.println("--------------------");
        System.out.println("-------12) Back -------------");
    }

    private void handleEditMenu() {
        int choice2;
        do {
            printEditMenu();
            System.out.print("Make your choice: ");
           choice2 = input.nextInt();
            if (choice2 == 1){
            }else if (choice2 == 2){
            }else if (choice2 == 3){
            }else if (choice2 == 4){
            }else if (choice2 == 5){
            }else if (choice2 == 6){
            }else if (choice2 == 7){
            }else if (choice2 == 8){
            }else if (choice2 == 9){
            }else if (choice2 == 10){
            }else if (choice2 == 11){

            }
        }while (choice2 != 12);
    }

}
