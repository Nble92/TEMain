package com.techelevator;

import java.util.Scanner;

public class DecimalToBinary {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);


		// Prompt the user for a series of Binary Numbers
		System.out.print("Please provide a series of numbers (space separated): ");
		String numbers = scanner.nextLine();

		String[] numberArray = numbers.split(" ");
		//Split the string up into separate values.
		String[] priceArray = numbers.split(" ");
		for (int i = 0; i < numberArray.length; i++) {
			//Read individual value as an Integer
			int convertNumber = Integer.parseInt(priceArray[i]);
			//convert the integer into a binary string
			String binaryNumber = Integer.toBinaryString(convertNumber);
			// and print the values
			System.out.println(convertNumber + " in binary is " + binaryNumber);


		}

	}

}