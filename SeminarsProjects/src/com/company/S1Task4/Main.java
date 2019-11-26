package com.company.S1Task4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int numberOfStudents;
        int id = 0;
        int gradeID = ++id;
        int average;
        Scanner input = new Scanner(System.in);
        int studentId = ++id;
         int count = 0;


        System.out.println("Enter number of students: ");
        numberOfStudents = input.nextInt();

        for (int i = 0; i < numberOfStudents; i++){
            System.out.println("Enter the grade " + "[" + (count++) + "]:");
            gradeID = input.nextInt();
        }

        System.out.println("-------------------------");



    }
}
