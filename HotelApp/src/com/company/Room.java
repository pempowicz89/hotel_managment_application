package com.company;

public class Room {

    private static int idCounter = 0;
    private final int roomId = ++idCounter;
    private int roomNumber;
    private int numberOfBeds;
    private int Balcony;
    private double pricePerNight;
    private boolean booked = false;


    public Room(int roomNumber, int numberOfBeds, int balcony, double pricePerNight) {
        this.roomNumber = roomNumber;
        this.numberOfBeds = numberOfBeds;
        Balcony = balcony;
        this.pricePerNight = pricePerNight;
    }

    public static int getIdCounter() {
        return idCounter;
    }

    public static void setIdCounter(int idCounter) {
        Room.idCounter = idCounter;
    }

    public int getRoomId() {
        return roomId;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public void setNumberOfBeds(int numberOfBeds) {
        this.numberOfBeds = numberOfBeds;
    }

    public int getBalcony() {
        return Balcony;
    }

    public void setBalcony(int balcony) {
        Balcony = balcony;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public boolean isBooked() {
        return booked;
    }

    public void setBooked(boolean booked) {
        this.booked = booked;
    }
}
