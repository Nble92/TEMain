package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FizzWriter {

	public static void main(String[] args) {

		Scanner userInput = new Scanner(System.in);
		System.out.println("What is the destination file?");
		String path = userInput.nextLine();
		File newb = new File(path);
		try (PrintWriter destinationWriter = new PrintWriter(newb);) {
			for (int i = 1; i < 301; i++) {
				if (i % 3 == 0 && i % 5 == 0) {
					destinationWriter.println("FizzBuzz");
				} else if (i % 3 == 0) {
					destinationWriter.println("Fizz");
				} else if (i % 5 == 0){
					destinationWriter.println("Buzz");
				}
				else {
					destinationWriter.println(i);
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			System.exit(1);

		}

	}
}




