package com.company.add3Numbers;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Main myApp = new Main();

        System.out.println("Enter a: ");
        int a = input.nextInt();
        System.out.println("Enter b: ");
        int b = input.nextInt();
        System.out.println("Enter c: ");
        int c = input.nextInt();

        int res = myApp.calc(a, b, c);
        System.out.println("(a * b) + c is: " + res);

    }

    private int calc(int a, int b, int c){
        return (a * b) + c;
    }
}
