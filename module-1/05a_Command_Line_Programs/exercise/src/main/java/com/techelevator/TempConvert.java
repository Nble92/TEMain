package com.techelevator;

import java.util.Scanner;

public class TempConvert {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		System.out.println("Please Enter The Temperature: ");
		String value = input.nextLine();
		int temp = Integer.parseInt(value);
		System.out.println("Is the temperature in (C)elsius, or (F)ahrenheit?");
		String value2 = input.nextLine();
		String cOrF = value2;
		double cToF = (double)(temp * 1.8 + 32);
		double fToC = (double)(temp - 32) / 1.8;
		if (cOrF.equalsIgnoreCase("C")){

			System.out.println(temp + "C = " + (int)cToF + " F.");
		}
		else if (cOrF.equalsIgnoreCase("F")) {
			System.out.println(temp + "F = " + (int)fToC + " C.");
		}
		else {
			System.out.println(temp + "Not a valid input.");

		}


	}

}
