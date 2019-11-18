package com.company.methodInMethod;

public class Main {
    public static void main(String[] args) {

        Main myApp = new Main();
        myApp.methodA();

    }

    private void methodA(){
        System.out.println("Method A");
        methodB();
    }

    private void methodB(){
        System.out.println("Method B");
    }
}
