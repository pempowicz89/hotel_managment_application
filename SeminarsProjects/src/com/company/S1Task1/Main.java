package com.company.S1Task1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int balance = 0;
        int amount;

        System.out.println("Current balance: " + balance);

        for (int i = 0; i < 10; i ++){
            System.out.println("Enter deposit or withdraw: ");
            amount = input.nextInt();

            balance = balance + amount;

            System.out.println("---------------------------");
            System.out.println("Current balance: " + balance);
        }


    }
}
