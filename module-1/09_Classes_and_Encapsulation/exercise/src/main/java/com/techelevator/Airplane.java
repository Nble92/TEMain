package com.techelevator;

public class Airplane {

    private String planeNumber;
    private int totalFirstClassSeats;
    private int bookedFirstClassSeats;
    private int totalCoachSeats;
    private int bookedCoachSeats;


    public Airplane(String planeNumber, int totalFirstClassSeats, int totalCoachSeats) {
        this.planeNumber = planeNumber;
        this.totalFirstClassSeats = totalFirstClassSeats;
        this.totalCoachSeats = totalCoachSeats;

    }

    public int getAvailableFirstClassSeats() {
        return totalFirstClassSeats - bookedFirstClassSeats;

    }

    public int getAvailableCoachSeats() {
        return totalCoachSeats - bookedCoachSeats;
    }

    public int getBookedCoachSeats() {
        return bookedCoachSeats;
    }

    public int getTotalCoachSeats() {
        return totalCoachSeats;
    }
    public String getPlaneNumber(){
        return planeNumber;
    }

    public int getTotalFirstClassSeats() {
        return totalFirstClassSeats;
    }

    public int getBookedFirstClassSeats() {

        return bookedFirstClassSeats;
}


    public boolean reserveSeats(boolean forFirstClass, int totalNumberOfSeats) {
        boolean reserve = false;

        if (forFirstClass) {
            if (getAvailableFirstClassSeats() >= totalNumberOfSeats) {
                bookedFirstClassSeats += totalNumberOfSeats;
                reserve = true;
            }
        }
        else {
            if (getAvailableCoachSeats() >= totalNumberOfSeats) {
                bookedCoachSeats += totalNumberOfSeats;
                reserve = true;
            }
        }
        return reserve;


    }
}
