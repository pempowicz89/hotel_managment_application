package com.company.S1Task2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Scanner input = new Scanner(System.in);
        String gender;
        String customer;
        String age;
        String answer;

        do{
            System.out.println("Is the person: \nA)Male     B)Female\n>>");
            gender = input.nextLine();
            System.out.println("Is the person Already a customer: \nA)Yes     B)No\n>>");
            customer = input.nextLine();
            System.out.println("How old is the person: \nA)0=10    B)11-20    C)+20\n>>");
            age = input.nextLine();
            System.out.println("Are the answer correct (y/n)?");
            answer = input.nextLine();
        } while(!answer.equals("y"));



    }
}
