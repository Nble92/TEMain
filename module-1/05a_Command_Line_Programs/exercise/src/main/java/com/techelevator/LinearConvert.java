package com.techelevator;

import java.util.Scanner;

public class LinearConvert {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		System.out.println("Please Enter The Length: ");
		String value = input.nextLine();
		int length = Integer.parseInt(value);
		System.out.println("Is the length in feet(ft), or meters(m)?");
		String value2 = input.nextLine();
		String fOrM = value2;
		double fTom = (double)(length * 0.3048);
		double mToF = (double)(length * 3.2808399);
		if (fOrM.equalsIgnoreCase("ft")){

			System.out.println(length + "ft = " + fTom + "m.");
		}
		else if (fOrM.equalsIgnoreCase("m")) {
			System.out.println(length + "m = " + mToF + " ft.");
		}
		else {
			System.out.println("Not a valid input.");

		}


	}

}
