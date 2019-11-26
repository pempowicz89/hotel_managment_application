package com.company.S1Task3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int rows;
        int columns;

        System.out.println("Specify number of rows;");
        rows = input.nextInt();
        System.out.println("Specify number of columns;");
        columns = input.nextInt();

        for (int i = 0; i < rows; i++){
            for (int j = 0; j < columns; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
