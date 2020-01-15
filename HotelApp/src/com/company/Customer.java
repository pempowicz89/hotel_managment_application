package com.company;

public class Customer extends User {

    private final int customerId;
    private String firstName;
    private String lastName;
    private String SSN;
    private String Address;
    private String telephoneNumber;

    public Customer(String userName, String password, boolean fullAccess,
                    String firstName, String lastName, String SSN, String address,
                    String telephoneNumber, int customerId) {
        super(userName, password, fullAccess);
        this.firstName = firstName;
        this.lastName = lastName;
        this.SSN = SSN;
        Address = address;
        this.telephoneNumber = telephoneNumber;
        this.customerId = customerId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSSN() {
        return SSN;
    }

    public void setSSN(String SSN) {
        this.SSN = SSN;
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


