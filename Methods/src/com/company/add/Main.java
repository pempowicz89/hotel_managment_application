package com.company.add;

public class Main {
    public static void main(String[] args) {

        Main myApp = new Main();
        int sum1 = myApp.add(10, 20);
        double sum2 = myApp.add(10.11, 20.30);
        int sum3 = myApp.addThree(1,2,3);

        System.out.println("Sum1 is: " + sum1);
        System.out.println("Sum2 is: " + sum2);
        System.out.println("Sum3 is: " + sum3);

    }

    private int add(int a, int b){
        return a + b;
    }

    private double add(double a, double b){
        return a + b;
    }

    private int addThree(int a, int b, int c){
        return (a * b) + c;
    }
}
