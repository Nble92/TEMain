package com.techelevator;

public class Inventory {

    public static void main(String[] args) {
        // Method for splitting up the inventory lines...
        String line = "A1|Potato Crisps|3.05|Chip";


        String[] parts = line.split("\\|");

        for( String part : parts) {
            System.out.println(part);
        }
    }
}
