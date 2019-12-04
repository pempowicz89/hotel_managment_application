package com.company;

public class Customer extends User {

    private static int IdCounter = 0;
    private final int customerId = ++IdCounter;
    private String firstName;
    private String lastName;
    private String SSN;
    private String Address;
    private String telephoneNumber;

    public Customer(String userName, String password, boolean fullAccess,
                    String firstName, String lastName, String SSN, String address,
                    String telephoneNumber) {
        super(userName, password, fullAccess);
        this.firstName = firstName;
        this.lastName = lastName;
        this.SSN = SSN;
        Address = address;
        this.telephoneNumber = telephoneNumber;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSSN() {
        return SSN;
    }

    public String getAddress() {
        return Address;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    @Override
    public String toString() {
        return " " +
                "--------------------------------"  +
                "\nCustomerId      =  " + customerId +
                "\nfirstName       = '" + firstName + '\'' +
                "\nlastName        = '" + lastName + '\'' +
                "\nSSN             = '" + SSN + '\'' +
                "\nAddress         = '" + Address + '\'' +
                "\ntelephoneNumber = '" + telephoneNumber + '\'' +
                "\n";
    }
}


