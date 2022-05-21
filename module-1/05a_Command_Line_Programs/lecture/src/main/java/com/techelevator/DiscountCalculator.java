//package com.techelevator;

import java.util.Scanner;

//class DiscountCalculator {
//
//    /**
//     * The main method is the start and end of our program
//     */
//    public static void main(String[] args) {
//
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.println("Welcome to the Discount Calculator");
//
//        // Prompt the user for a discount amount
//
//        // The answer needs to be saved as a double
//        System.out.print("Enter the discount amount (w/out percentage): ");
//        double discount = Double.parseDouble(scanner.nextLine());
//
//
//        // Prompt the user for a series of prices
//        System.out.print("Please provide a series of prices (space separated): ");
//    String prices = scanner.nextLine();
//
//    //Split the string up into separate values.
//        String[] priceArray = prices.split(" ");
//        for (int i = 0; i < priceArray.length; i++) {
//            //Read individual value as a double
//            double originalPrice = Double.parseDouble(priceArray[i]);
//
//            //originalPrice
//            double amountOff = originalPrice * (discount / 100);
//
//            //calc sale price
//            double salePrice = originalPrice - amountOff;
//            System.out.println("Original Price: " + originalPrice + " Sale Price: " + salePrice);
//        }
//        // You need to close the scanner to preserve memory!
//        scanner.close();
//
//    }
//
//}



        boolean gameActive = true;
                Scanner userInput = new Scannaer(System.in);
String forceUser;
        while (gameActive){

                System.out.printIn("Please enter Star Wars character n");
                forceUser=userInput.nextLine();
                if(forceUser.equals("Q")) //use .equals for comparing strings.
                {
                gameActive=false;
                }
                else if(forceUser.equals("Yoda")){
                System.out.printIn(forceUser+"is a Jedi");
                }
                else if(forceUser.equals("Yoda")){
                System.out.printIn(forceUser+"Was a Jedi...but he got caught up.");
                }
                else{
                System.out.printIn(forceUser+" probably has a Disney + show coming...");
                }
                }
