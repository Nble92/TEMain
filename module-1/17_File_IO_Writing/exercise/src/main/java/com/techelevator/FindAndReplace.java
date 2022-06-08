package com.techelevator;

import java.io.*;
import java.util.Scanner;

public class FindAndReplace {

    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);
//

        System.out.println("What is the search word?");
        String wurd = userInput.nextLine();
        System.out.println("What is the replacement word?");
        String replMnt = userInput.nextLine();
        File file = WordSearch.getInputFileFromUser(userInput);
        File newb = WordSearch.newFile(userInput);
        try (Scanner source = new Scanner(file);
             PrintWriter destinationWriter = new PrintWriter(newb)) {
            while (source.hasNextLine()) {
                String line = source.nextLine();
                destinationWriter.println(line.replaceAll(wurd,replMnt));
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            System.exit(1);
//        try {
//          String wrdRplace = WordSearch.findDaWordz(file,wurd,replMnt);
//            File finalFi = WordSearch.changeFile(newb, wrdRplace);
//            System.out.println(finalFi);
//
//        } catch (FileNotFoundException e) {
//            System.out.println(e.getMessage());
//            System.exit(1);
////
//
//
//            }

        }

    }
}







//		if(file.exists()) {//grabs the name of the file
//			System.out.println("name: " + file.getName());
//			System.out.println("absolute path: " + file.getAbsolutePath());
//			if (file.isDirectory()){
//				System.out.println("it is a directory");
//			}
//
//		 else{//prints the absolute path
//			System.out.println(file.getAbsolutePath() + " does not exist!!!");
//		}
//
//
//        try (FileOutputStream stream = new FileOutputStream(newFile, true);
//             PrintWriter writer = new PrintWriter(stream)) {
//            writer.append(message);
//        } catch (IOException e) {
//            System.out.println("Exception:");


