package com.company.S2Task2;

public class Main {
    public static void main(String[] args) {

        double initialAmount = 100;
        double interestRate = 0.05;
        double year = 1;

        Main myApp = new Main();
        myApp.balanceAfterOneYear(100,100.05,1);









    }

    private double balanceAfterOneYear(double initialAmount, double interestRate, double year ){
        System.out.println("InitialAmount          : " + initialAmount);
        System.out.println("InterestRate           : " + interestRate);
        System.out.println("Balance after one year : " + (initialAmount * interestRate));
        return initialAmount * interestRate * year;


    }
}
