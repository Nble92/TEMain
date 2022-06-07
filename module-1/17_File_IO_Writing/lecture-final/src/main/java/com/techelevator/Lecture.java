package com.techelevator;

import java.io.*;
import java.util.Scanner;

public class Lecture {

	public static void main(String[] args) throws IOException {

		Scanner userInput = new Scanner(System.in);

		/*
		 * The java.io.File class is a representation of file and directory path names.  It provides methods to inspect and
		 * modify file system objects.
		 *
		 * One benefit is that it compensates for differences in Windows and Unix use of '/' and '\' as directory delimiters.
		 *
		 * A new instance of File can be created from a String that contains a file system path
		 */

//		System.out.println("Enter path to file or directory >>>");
//		String path = userInput.nextLine();
//		File file = new File(path);
//
//		if (file.exists()) {
//			System.out.println("name: " + file.getName());
//			System.out.println("absolute path: " + file.getAbsolutePath());
//			if (file.isDirectory()) {
//				System.out.println("it is a directory");
//			} else if (file.isFile()) {
//				System.out.println("it is a file");
//			}
//			System.out.println("size: " + file.length());
//		} else {
//			System.out.println(file.getAbsolutePath() + " does not exist!!");
//		}


//		System.out.println("Enter path of new directory >>>");
//		String path = userInput.nextLine();
//		File newDirectory = new File(path);
//
//		if (newDirectory.exists()) {
//			System.out.println("Sorry, " + newDirectory.getAbsolutePath() + " already exists!");
//			System.exit(1);
//		} else {
//			if (newDirectory.mkdir()) {
//				System.out.println("New directory was created at " + newDirectory.getAbsolutePath());
//			} else {
//				System.out.println("Could not create the directory!!!");
//				System.exit(1);
//			}
//		}

//		System.out.println("Enter path of new file >>>");
//		String path = userInput.nextLine();
//		//File newFile = new File(path);
//		File newFile = new File(newDirectory, path);
//
//		try {
//			newFile.createNewFile();
//			System.out.println("name: " + newFile.getName());
//			System.out.println("absolute path: " + newFile.getAbsolutePath());
//			System.out.println("size: " + newFile.length());
//		} catch (IOException e) {
//			System.out.println("Something went wrong " + e.getMessage());
//		}

//		System.out.println("Enter path to delete >>>");
//		String path = userInput.nextLine();
//		File file = new File(path);
//
//
//		if( file.delete()) {
//			System.out.println("the file was deleted!");
//		} else {
//			System.out.println("could not delete the file!");
//		}


		System.out.println("Enter path of new file >>>");
		String path = userInput.nextLine();
		File newFile = new File(path);

		try {
			newFile.createNewFile();
		} catch (IOException e) {
			System.out.println("Something went wrong " + e.getMessage());
		}

		System.out.println("Enter some message to write to the file.");
		String message = userInput.nextLine();

		// The good way to do try with resources
//		try (PrintWriter writer = new PrintWriter(newFile)) {
//			writer.print(message);
//		} catch (FileNotFoundException e) {
//			System.out.println(e.getMessage());
//		}

		try ( FileOutputStream stream = new FileOutputStream(newFile, true);
			  PrintWriter writer = new PrintWriter(stream)) {
			writer.append(message);
		} catch(IOException e) {
			System.out.println("Exception: " + e.getMessage());
		}



//		// old way to do resource closing
//		try  {
//			PrintWriter writer = new PrintWriter(newFile);
//
//			try {
//				writer.print(message);
//
//			} finally {
//				writer.flush();
//				writer.close();
//			}
//
//		} catch (FileNotFoundException e) {
//			System.out.println(e.getMessage());
//		}




	}





}
