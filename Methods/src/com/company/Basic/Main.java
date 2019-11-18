package com.company.Basic;

public class Main {
    public static void main(String[] args) {

        Main myApp = new Main();


        myApp.print();
        myApp.printQuite();
        myApp.printParam("This text is param");
        myApp.printTwoParams(5, 10);
        myApp.printDoubles(11.2, 12.3, 100.2);


    }

    private void print(){
        System.out.println("Hello World");
    }

    private void printQuite(){

        System.out.println("Hassan ");
        System.out.println("He is the king ");
        System.out.println("Hassan is here ");
        System.out.println("THe king is here ");
        System.out.println("OMG ");
    }

    private void printParam(String s){
        System.out.println(s);
    }

    private void printTwoParams(int a, int b){
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }

    private void printDoubles(double a, double b, double c){
        System.out.printf("%f,%f,%f%n", a, b, c);
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }
}
