package com.techelevator;

import java.sql.SQLOutput;
import java.util.Scanner;

class DiscountCalculator {

    /**
     * The main method is the start and end of our program
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Discount Calculator");

        // Prompt the user for a discount amount
        // The answer needs to be saved as a double
        System.out.print("Enter the discount amount (w/out percentage): ");
        double discount = Double.parseDouble(scanner.nextLine()) / 100.0;


        // Prompt the user for a series of prices
        System.out.print("Please provide a series of prices (space separated): ");
        String prices = scanner.nextLine();

        //Split the string up into separate values
        String[] priceArray = prices.split(" ");

        for (int i = 0; i < priceArray.length; i++){
            //Read the individual value as double
            double originalPrice = Double.parseDouble(priceArray[i]);

            //Calc discount amount
            double amountOff = originalPrice * discount;

            //calc sale price
            double salePrice = originalPrice - amountOff;

            System.out.println("Original Price: " + originalPrice +  " Sale Price: " + salePrice);
        }

        scanner.close();

/*  //sandbox code
        boolean gameActive = true;
        Scanner userInput =  new Scanner(System.in);
        String forceUser;

        while (gameActive) {

            System.out.println("Please enter Star Wars character (enter Q to quit the game) ");
            forceUser = userInput.nextLine();
            if (forceUser.equals("Q")){
                gameActive = false;
            }
            else if (forceUser.equals("Yoda")){
                System.out.println(forceUser + " is a Jedi");
            }
            else if (forceUser.equals("Darth Vader")){
                System.out.println(forceUser + " is a Sith");
            }
            else{
                System.out.println("No info on this character");
            }


        }
        System.out.println("Game Over");
        userInput.close();
*/



    }

}