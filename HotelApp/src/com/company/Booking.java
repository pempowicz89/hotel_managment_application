package com.company;

public class Booking {

    private int bookingId;
    private String customerId;
    private int roomNumber;
    private double totalPrice;
    private String checkIn;
    private String checkOut;

    public Booking(int bookingId, String customerId, int roomNumber, double totalPrice, String checkIn, String checkOut) {
        this.bookingId = bookingId;
        this.customerId = customerId;
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

    public String getCustomer() {
        return customerId;
    }

    public void setCustomer(String customer) {
        this.customerId = customer;
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
