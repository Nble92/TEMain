package com.techelevator.scanner;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RTNValidator {
	
	private static final int[] CHECKSUM_WEIGHTS = new int[] { 3, 7, 1, 3, 7, 1, 3, 7, 1 };

	public static void main(String[] args) throws FileNotFoundException {

		printApplicationBanner();

		File inputFile = getInputFileFromUser();
		// make sure you close your scanner after it is done
		//unless you're using try with resources.
		try (Scanner fileScanner = new Scanner(inputFile)) {
			//as long s
			while (fileScanner.hasNextLine()) {
				String line = fileScanner.nextLine();
				String rtn = line.substring(0, 9);

				if (checksumIsValid(rtn) == false) {
					System.out.println("This is not a valid RTN" + line);
				} else {
					System.out.println("This is a valid RTN" + line);
				}
			}
		}
		catch (FileNotFoundException ex) {
			System.out.println(ex);
		}
		}

	private static void printApplicationBanner() {
		System.out.println("******************");
		System.out.println("RTN Validator 9000");
		System.out.println("******************");
		System.out.println();
	}

	@SuppressWarnings("resource")
	private static File getInputFileFromUser() {
		//where user types in their input
		Scanner userInput = new Scanner(System.in);
		System.out.print("Please enter path to input file >>> ");
		String path = userInput.nextLine();
		
		File inputFile = new File(path);
		//checking if input file exists
		if(inputFile.exists() == false) { // checks for the existence of a file
			//could throw an exception instead
			System.out.println(path+" does not exist");
			System.exit(1); // Ends the program
			//this checks for if input file is a file
		} else if(inputFile.isFile() == false) {
			System.out.println(path+" is not a file");
			System.exit(1); // Ends the program
		}
		return inputFile;
	}

	private static boolean checksumIsValid(String routingNumber) {
		int checksum = 0;
		for(int i = 0; i < 9; i++) {
			int digit = Integer.parseInt(routingNumber.substring(i, i+1));
			checksum += digit * CHECKSUM_WEIGHTS[i];
		}
		return checksum % 10 == 0;
	}
}
