package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;

public class WordSearch {

	public static void main(String[] args) throws FileNotFoundException {
		//pull from content root. not absolute path
		//check lecture code for solutions
		//goal is to find words throughout the file.
		//keep track of line number
		//this line calls the method below
		Scanner keyB = new Scanner(System.in);
		File inputFile = getInputFileFromUser(keyB);

		// make sure you close your scanner after it is done
		//unless you're using try with resources.
//		try (Scanner fileScanner = new Scanner(inputFile)) {
//
//		} catch (FileNotFoundException ex) {
//			System.out.println(ex);
//		}
		String findWord = findDaWordz(inputFile,keyB);

	}


	//Takes the input from user and searches for the file
	@SuppressWarnings("resource")
	private static File getInputFileFromUser(Scanner userInput) {
		//where user types in their input to find file
		System.out.print("Please enter path to input file >>> ");
		String path = userInput.nextLine();

		File inputFile = new File(path);
		//checking if input file exists
		if (inputFile.exists() == false) { // checks for the existence of a file
			//could throw an exception instead
			System.out.println(path + " does not exist");
			System.exit(1); // Ends the program
			//this checks for if input file is a file
		} else if (inputFile.isFile() == false) {
			System.out.println(path + " is not a file");
			System.exit(1); // Ends the program
		}
		return inputFile;
	}

	//ask for word they would like to search.
	private static String findDaWordz(File inputFi, Scanner userInput) throws FileNotFoundException {

		System.out.println("What word are you looking for?");
		String wurd = userInput.nextLine();
		System.out.println("Should the search be case sensitive? (Y\\N)" );
		String senSay = userInput.nextLine();
		//find all instances of the word in the file.
		int lineNum = 1;
		Scanner daBook = new Scanner(inputFi);
		if (senSay.equalsIgnoreCase("Y")) {
			while (daBook.hasNextLine()) {
				String line = daBook.nextLine();
				if (line.contains(wurd)) {
					System.out.println(lineNum + ":" + " " + line);
				}
				lineNum++;
			}
		}
			else if (senSay.equalsIgnoreCase("N")){
			while (daBook.hasNextLine()) {
				String line = daBook.nextLine();

				if (line.toLowerCase().contains(wurd.toLowerCase())) {
					System.out.println(lineNum + ":" + " " + line);
				}
				lineNum++;
			}
		}
		return wurd;

	}

}







