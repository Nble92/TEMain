package com.techelevator;

import java.util.Scanner;

public class KilometerConverter {

    public static void main(String[] args) {// this has a main method and is public on this system

   Scanner input = new Scanner(System.in);

        System.out.print("Enter a kilometer value to start at: "); // this is printing a prompt to the screen
        String value = input. nextLine(); // this is where the user inputs a value
        int kilometerStart = Integer.parseInt(value); // the value is declared to represent the inputted value;
        System.out.print("Enter a kilometer value to end with: "); // this is printing a prompt to the screen
        String value2 = input. nextLine(); // this is where the user inputs a value
        int kilometerEnd = Integer.parseInt(value2); // this is the second value inputted
        System.out.print("How many should it increment by?: "); // this is printing a prompt to the screen
        String value3 = input. nextLine(); // this is where the user inputs a value
        int increment = Integer.parseInt(value3); // this is the third value inputted



        System.out.print("Going from " + kilometerStart + "km to " + kilometerEnd + "km" + " in increments of " + increment + "km."); // this is printing a prompt to the screen


        for (int km = kilometerStart; km <= kilometerEnd; km += (kilometerEnd - kilometerStart) / increment) {
                    double miles = km * 0.621371;
                    System.out.println(km + "km is " + miles + "mi.");
        }







    }
    
}
