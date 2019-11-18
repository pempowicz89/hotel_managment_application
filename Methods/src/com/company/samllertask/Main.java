package com.company.samllertask;

import java.util.Scanner;

public class Main {

    Scanner input = new Scanner(System.in);


    public static void main(String[] args) {

        Main myApp = new Main();
        myApp.printTheNumber();
    }

    private void printTheNumber(){
        int number;

        do {
            System.out.println("--------------------------");
            System.out.println("Please enter your number: ");
            number = input.nextInt();
            System.out.println("Your number is: " + number);
        } while(true);
    }
}
