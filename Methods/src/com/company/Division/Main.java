package com.company.Division;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Main myApp = new Main();


        System.out.println("Enter a:");
        int a = input.nextInt();
        System.out.println("Enter b:");
        int b = input.nextInt();

        int div = myApp.divide(a, b);
        System.out.println("(a * b) + c is: " + div);

    }


    private int divide(int a, int b){
        return a/b;
    }
}
