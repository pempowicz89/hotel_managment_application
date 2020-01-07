package com.company;


public class Room {

    private int roomNumber;
    private int beds;
    private int star;
    private String hasBalcony;
    private int price;


    public Room(int roomNumber, int beds, int star, String hasBalcony, int price) {
        this.roomNumber = roomNumber;
        this.hasBalcony = hasBalcony;
        if (beds == 1 || beds == 2 || beds == 3 || beds == 4) {
            this.beds = beds;
        } else {
            throw new IllegalArgumentException(
                    "Number of beds in a room can only be 1, 2, 3 or 4.");
        }
        if (star == 3 || star == 4 || star == 5) {
            this.star = star;
        } else {
            throw new IllegalArgumentException(
                    "Star only rank 1-5.");
        }
        if (price == 1000 || price == 1500 || price == 1900 || price ==2200 ) {
            this.price = price;

        } else {
            throw new IllegalArgumentException(
                    "The options for prices are 1000 SEK, 1500 SEK, 1900 SEK and 2200 ");
        }
    }

    public String getHasBalcony() {

        return hasBalcony;
    }

    public void setHasBalcony(String hasBalcony)
    {
        this.hasBalcony = hasBalcony;
    }

    public int getPrice()
    {
        return price;
    }

    public void setPrice(int price) {
        if (price == 1000 || price == 1500 || price == 1900 || price ==2200 ) {
            this.price = price;
        } else {
            throw new IllegalArgumentException(
                    "The options for prices are 1000 SEK, 1500 SEK, 2000 SEK and 2200 ");
        }
    }


    public void setRoomNumber(int roomNumber) {

        this.roomNumber = roomNumber;
    }

    public int getRoomNumber() {

        return roomNumber;
    }

    public int getBeds() {

        return beds;
    }

    public void setBeds(int beds) {
        if (beds == 1 || beds == 2 || beds == 3 || beds == 4) {
            this.beds = beds;
        } else {
            throw new IllegalArgumentException(
                    "Number of beds in a room can only be 1, 2, 3 or 4.");
        }
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        if (star == 3 || star == 4 || star == 5) {
            this.star = star;
        } else {
            throw new IllegalArgumentException(
                    "Standards only rank 3-5.");
        }
    }

    @Override
    public String toString() {
        return "" +
                "roomNumber    " + roomNumber +
                "\nbeds          " + beds +
                "\nstar          " + star +
                "\nhasBalcony    " + hasBalcony +
                "\nprice         " + price +
                ' ';
    }
}
