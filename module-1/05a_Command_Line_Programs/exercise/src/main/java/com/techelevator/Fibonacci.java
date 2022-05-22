package com.techelevator;

import java.util.Arrays;
import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] fibNa) {

		Scanner input = new Scanner(System.in);


		System.out.print("Enter a number value to end at: "); // this is printing a prompt to the screen

		String value = input.nextLine();
		int lastNum = Integer.parseInt(value);
		int[] range = {0,1};
		int incValue = 0;
		if (lastNum <= 0)
		{

			System.out.println(lastNum);
			System.out.println(lastNum + 1);

		}
		else {

			for (int count = 0; incValue < lastNum; count++) {
				if (count == 0) {
					System.out.println(count);
					System.out.println(count + 1);
				}

				incValue = range[1] + range[0];
				range[0] = range[1];
				range[1] = incValue;


				int[] range2 = new int[count + 1];
				range2[count] = incValue;
				System.out.println(incValue);
			}






		}


	}
}