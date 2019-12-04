package com.company;


public class Room {

    private int roomNumber;
    private int beds;
    private int star;


    public Room(int roomNumber, int beds, int star) {
        this.roomNumber = roomNumber;
        if(beds == 1 || beds == 2 || beds == 4) {
            this.beds = beds;
        }else{
            throw new IllegalArgumentException(
                    "Number of beds in a room can only be 1, 2 or 4.");
        }
        if (star == 1 || star == 2 || star == 3) {
            this.star = star;
        }else {
            throw new IllegalArgumentException(
                    "Star only rank 1-3.");
        }
    }


    public int getRoomNumber() {
        return roomNumber;
    }

    public int getBeds() {
        return beds;
    }

    public void setBeds (int beds) {
        if(beds == 1 || beds == 2 || beds == 4) {
            this.beds = beds;
        }else{
            throw new IllegalArgumentException(
                    "Number of beds in a room can only be 1, 2 or 4.");
        }
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        if (star == 1 || star == 2 || star == 3) {
            this.star = star;
        } else {
            throw new IllegalArgumentException(
                    "Standards only rank 1-3.");
        }
    }

    @Override
    public String toString(){
        return String.format ("%s%-4d%s%-2d%s%-2d", "Room number: ", roomNumber, "Beds: ", beds, "Star: ", star);
    }

}
