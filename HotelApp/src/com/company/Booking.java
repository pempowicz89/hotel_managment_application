package com.company;

public class Booking {

    private int bookingId;
    private int customerId;
    private String customerName;
    private int customerSSN;
    private int roomNumber;
    private double totalPrice;
    private String checkIn;
    private String checkOut;

    public Booking(int bookingId, int customerId, String customerName, int customerSSN, int roomNumber, double totalPrice, String checkIn, String checkOut) {
        this.bookingId = bookingId;
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerSSN = customerSSN;
        this.roomNumber = roomNumber;
        this.totalPrice = totalPrice;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public int getCustomer() {
        return customerId;
    }

    public void setCustomer(int customer) {
        this.customerId = customer;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerSSN(int customerSSN) {
        this.customerSSN = customerSSN;
    }

    public int getCustomerSSN() {
        return customerSSN;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }

    public String getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(String checkOut) {
        this.checkOut = checkOut;
    }
}
