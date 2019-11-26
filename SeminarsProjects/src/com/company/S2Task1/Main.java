package com.company.S2Task1;

import java.sql.SQLOutput;
import java.util.Scanner;


public class Main {


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Main myApp = new Main();
        int select;
        int amount;
        String name;
        String address;
        String phone;
        String account;
        int currentBalance = 0;

        System.out.println("--- New Account ---");
        System.out.print("Name: ");
        name = input.nextLine();
        System.out.print("Address: ");
        address = input.nextLine();
        System.out.print("Phone: ");
        phone = input.nextLine();
        System.out.print("Account: ");
        account = input.nextLine();
        String Answer;

        do {
            myApp.printMenu();
            select = input.nextInt();
            if (select == 1) {
                myApp.deposit(0, 0);
            } else if (select == 2) {
                myApp.withdraw(0, 0);
            } else if (select == 3) {
                System.out.println("--- View Account ----");
                System.out.println("Name:           :" + name);
                System.out.println("Address         :" + address);
                System.out.println("Phone           :" + phone);
                System.out.println("Account         :" + account);
                System.out.println("Current Balance :" + currentBalance);
            } else if (select == 4) {
                System.exit(0);
            } else {
                System.out.println("Not a valid option");
            }

            System.out.println("Do you really want to quit (y/n)? ");
            Answer = input.nextLine();

        } while (!Answer.equals("y"));




    }
    private void printMenu(){
        System.out.println("-----Menu-----");
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. View Account");
        System.out.println("4. Exit");
    }

    private int deposit(int amount, int balance){
        return balance = balance + amount;
    }

    private int withdraw(int amount, int balance){
        return balance = balance - amount;
    }
}
