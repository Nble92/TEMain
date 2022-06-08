package com.techelevator;

import javax.swing.plaf.synth.SynthOptionPaneUI;
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
		//this checks if file exists
//		if(file.exists()) {//grabs the name of the file
//			System.out.println("name: " + file.getName());
//			System.out.println("absolute path: " + file.getAbsolutePath());
//			if (file.isDirectory()){
//				System.out.println("it is a directory");
//			}
//			else if(file.isFile()){
//				System.out.println("it is a file");
//			}
//			System.out.println("size:" + file.length());
//		} else{//prints the absolute path
//			System.out.println(file.getAbsolutePath() + "does not exist!!! bitch");
//		}
//
//		System.out.println("Enter path of new directory >>>");
//		String path = userInput.nextLine();
//		//creates a new directory
//		File newDirectory = new File(path);
//		if (newDirectory.exists()) {
//			System.out.println(newDirectory.getAbsolutePath() + " already exists fucker");
//			//anything other than zero means something went wrong
//			System.exit(0);
//		}else {
//			if (newDirectory.mkdir()) {
//				System.out.println("New directory was created at " + newDirectory.getAbsolutePath());
//			}
//			else {
//				System.out.println("Could not create the directory!!!");
//				System.exit(666);
//			}
//		}
//
//		System.out.println("Enter path to new file>>>");
//		File newFile = new File(newDirectory, path);
//
//		try {
//				newFile.createNewFile();
//			System.out.println("name: " + newFile.getName());
//			System.out.println("absolute path: " + newFile.getAbsolutePath());
//			System.out.println("size: " + newFile.length());
//		} catch (IOException e) {
//			System.out.println("Something went wrong" + e.getMessage());
//		}

//		System.out.println("Enter file to delete");
//		String path = userInput.nextLine();
//		File file = new File(path);
////this can delete empty folders
//		if (file.delete()) {
//			System.out.println("the file was deleted");
//		}
//		else {
//			System.out.println("Could not delete the file!");
//		}

//	}

		System.out.println("Enter path to new file>>>");
		String path = userInput.nextLine();
		File newFile = new File(path);

		try {
			newFile.createNewFile();
		} catch (IOException e) {
			System.out.println("Something went wrong" + e.getMessage());
		}
		System.out.println("Enter some message to write to the file.");
		String message = userInput.nextLine();

		//try with resources: the flush() and close() are automatic
		//this is the new way
		//Also PrinterWriter is an object
//		try(PrintWriter writer = new PrintWriter(newFile)) {
//			//this also overrides the content of the file
//			writer.print(message);
//		}catch (FileNotFoundException e) {
//			System.out.println(e.getMessage());
//		}
		//this checks for the file and adds more text instead of raplacing the file
		try (FileOutputStream stream = new FileOutputStream(newFile, true);
				PrintWriter writer = new PrintWriter(stream)) {
			writer.append(message);
		} catch (IOException e) {
			System.out.println("Exception:");

//		//OldWay for resource closing
//		try {
//			PrintWriter writer2 = new PrintWriter();
//			try {
//				writer2.print(message);
//			}
//			finally {
////flushing empties the buffer tank during transfer
//			writer2.flush();
//			writer2.close();
//
//		}
//		}catch (FileNotFoundException e) {
//			System.out.println(e.getMessage());
//		}
//		}
		}
	}
}