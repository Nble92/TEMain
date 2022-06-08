package com.techelevator;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
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
	}


	//Takes the input from user and searches for the file
	@SuppressWarnings("resource")
	public static File getInputFileFromUser(Scanner userInput) {
		//where user types in their input to find file
		System.out.print("What is the source file?");
		String path = userInput.nextLine();

		File inputFile = new File(path);
		//checking if input file exists
//		if (inputFile.exists() == false) { // checks for the existence of a file
//			//could throw an exception instead
//			System.out.println(path + " does not exist");
//			System.exit(1); // Ends the program
//			//this checks for if input file is a file
//		} else if (inputFile.isFile() == false) {
//			System.out.println(path + " is not a file");
//			System.exit(1); // Ends the program
//		}
		return inputFile;
	}
	public static File newFile(Scanner userInput){
		System.out.println("What is the destination file?");
		String path = userInput.nextLine();
		File newFile = new File(path);

		try {
			newFile.createNewFile();
		} catch (IOException e) {
			System.out.println("Something went wrong" + e.getMessage());
		}

		return newFile;
	}
	public static File changeFile(File newFile, String newText) {

		try (
				FileOutputStream stream = new FileOutputStream(newFile, true);
				PrintWriter writer = new PrintWriter(stream)) {
			writer.append(newText);
		} catch (IOException e) {
			System.out.println("Exception:");
		}
		return newFile;
	}
	//ask for word they would like to search.
	public static String findDaWordz(File inputFi, String wurd, String replMnt) throws FileNotFoundException {

		//find all instances of the word in the file.
		int lineNum = 1;
		List list = new ArrayList<>();
		Scanner daBook = new Scanner(inputFi);
			while (daBook.hasNextLine()) {
				String line = daBook.nextLine();
				if (line.contains(wurd)) {
					list.add(line.replace(wurd,replMnt));
				}
				else {
					list.add(line);

				}
				lineNum++;

			}

		return list.toString();

	}


}







