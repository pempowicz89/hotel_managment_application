package com.company.readInt;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Main myApp = new Main();

        int a = myApp.readInt();
        int b = myApp.readInt();
        int c = myApp.readInt();

        myApp.printInteger(a);
        myApp.printInteger(b);
        myApp.printInteger(c);

    }

    private int readInt(){
        Scanner input = new Scanner(System.in);
        int a;

        System.out.println("Enter an integer: ");
        a = input.nextInt();

        return a;
    }

    private void printInteger(int value){
        System.out.println(value);

    }
}
