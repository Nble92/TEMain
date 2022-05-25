package com.techelevator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exercises {

	/*
	 Note, for-each is preferred, and should be used when possible.
	 */

	/*
	 Given an array of Strings, return an ArrayList containing the same Strings in the same order
	 array2List( {"Apple", "Orange", "Banana"} )  ->  ["Apple", "Orange", "Banana"]
	 array2List( {"Red", "Orange", "Yellow"} )  ->  ["Red", "Orange", "Yellow"]
	 array2List( {"Left", "Right", "Forward", "Back"} )  ->  ["Left", "Right", "Forward", "Back"]
	 */
	public List<String> array2List(String[] stringArray) {

		List<String> output = new ArrayList<>();
		for (String element : stringArray) //element is the same as *Array[i]

		{

			output.add(element);

		}


		return output;
	}

	/*
	 Given a list of Strings, return an array containing the same Strings in the same order
	 list2Array( ["Apple", "Orange", "Banana"] )  ->  {"Apple", "Orange", "Banana"}
	 list2Array( ["Red", "Orange", "Yellow"] )  ->  {"Red", "Orange", "Yellow"}
	 list2Array( ["Left", "Right", "Forward", "Back"] )  ->  {"Left", "Right", "Forward", "Back"}
	 */
	public String[] list2Array(List<String> stringList) {

		String[] listArray = stringList.toArray(new String[0]);


		return listArray;
	}

	/*
	 Given an array of Strings, return an ArrayList containing the same Strings in the same order
	 except for any words that contain exactly 4 characters.
	 no4LetterWords( {"Train", "Boat", "Car"} )  ->  ["Train", "Car"]
	 no4LetterWords( {"Red", "White", "Blue"} )  ->  ["Red", "White"]
	 no4LetterWords( {"Jack", "Jill", "Jane", "John", "Jim"} )  ->  ["Jim"]
	 */
	public List<String> no4LetterWords(String[] stringArray) {

		List<String> string2Array = array2List(stringArray);

		string2Array.removeIf(wordz -> wordz.length() == 4);

		return string2Array;
	}

	/*
	 Given an array of ints, divide each int by 2, and return an ArrayList of Doubles.
	 arrayInt2ListDouble( {5, 8, 11, 200, 97} ) -> [2.5, 4.0, 5.5, 100, 48.5]
	 arrayInt2ListDouble( {745, 23, 44, 9017, 6} ) -> [372.5, 11.5, 22, 4508.5, 3]
	 arrayInt2ListDouble( {84, 99, 3285, 13, 877} ) -> [42, 49.5, 1642.5, 6.5, 438.5]
	 */
	public List<Double> arrayInt2ListDouble(int[] intArray) {

		double[] dblPrim = new double[intArray.length];
		for (int i = 0; i < dblPrim.length; i++) {

			dblPrim[i] = intArray[i];
		}

		List<Double> doubleConvert = new ArrayList<>();

		for (Double dbls : dblPrim) {

			doubleConvert.add(dbls / 2);
		}


		return doubleConvert;
	}

	/*
	 Given a List of Integers, return the largest value.
	 findLargest( [11, 200, 43, 84, 9917, 4321, 1, 33333, 8997] ) -> 33333
	 findLargest( [987, 1234, 9381, 731, 43718, 8932] ) -> 43718
	 findLargest( [34070, 1380, 81238, 7782, 234, 64362, 627] ) -> 81238
	 */
	public Integer findLargest(List<Integer> integerList) {

		Integer Lrg = 0;


		for (int i = 0; i < integerList.size(); i++) {
			if (i + 1 >= integerList.size()) {
				return Lrg;
			}
			if (Lrg <= integerList.get(i)) {

				Lrg = integerList.get(i);

			}
		}


		return Lrg;
	}

	/*
	 Given an array of Integers, return a List of Integers containing just the odd values.
	 oddOnly( {112, 201, 774, 92, 9, 83, 41872} ) -> [201, 9, 83]
	 oddOnly( {1143, 555, 7, 1772, 9953, 643} ) -> [1143, 555, 7, 9953, 643]
	 oddOnly( {734, 233, 782, 811, 3, 9999} ) -> [233, 811, 3, 9999]
	 */
	public List<Integer> oddOnly(Integer[] integerArray) {

		List<Integer> oddz = new ArrayList<>();

		for (Integer odd1Out : integerArray) {

			if (odd1Out % 2 != 0)
				oddz.add(odd1Out);
		}

		return oddz;
	}

	/*
	 Given a List of Integers, and an int value, return true if the int value appears two or more times in
	 the list.
	 foundIntTwice( [5, 7, 9, 5, 11], 5 ) -> true
	 foundIntTwice( [6, 8, 10, 11, 13], 8 -> false
	 foundIntTwice( [9, 9, 44, 2, 88, 9], 9) -> true
	 */
	public boolean foundIntTwice(List<Integer> integerList, int intToFind) {
		boolean appears = false;
		boolean dupes = false;
		int count = 0;
		for (Integer confirmNum : integerList) {
			if (intToFind == confirmNum) {
				count += 1;
			}
		}
		if (count > 1) {
			dupes = true;
		}
		return dupes;
	}

	/*
	 Given an array of Integers, return a List that contains the same Integers (as Strings). Except any multiple of 3
	must be replaced by the String "Fizz", any multiple of 5 must be replaced by the String "Buzz",
	and any multiple of both 3 and 5 must be replaced by the String "FizzBuzz."
	** INTERVIEW QUESTION **

	fizzBuzzList( {1, 2, 3} )  ->  ["1", "2", "Fizz"]
	fizzBuzzList( {4, 5, 6} )  ->  ["4", "Buzz", "Fizz"]
	fizzBuzzList( {7, 8, 9, 10, 11, 12, 13, 14, 15} )  ->  ["7", "8", "Fizz", "Buzz", "11", "Fizz", "13", "14", "FizzBuzz"]

	HINT: To convert an Integer x to a String, you can use x.toString() in your code. For example, if x = 1, then x.toString() returns "1."
	 */
	public List<String> fizzBuzzList(Integer[] integerArray) {
		List<String> strList = new ArrayList<>();

		String Fizz = "Fizz";
		String Buzz = "Buzz";
		String FizzBuzz = "FizzBuzz";


		for (int i = 0; i < integerArray.length; i++) {


			if (integerArray[i] % 3 == 0 && integerArray[i] % 5 == 0) {

				strList.add(FizzBuzz);
			} else if (integerArray[i] % 5 == 0) {
				strList.add(Buzz);
			} else if (integerArray[i] % 3 == 0) {
				strList.add(Fizz);
			} else {
				strList.add(integerArray[i].toString());
			}
		}


		return strList;
	}


	/*
	 Given two lists of Integers, interleave them beginning with the first element in the first list followed
	 by the first element of the second. Continue interleaving the elements until all elements have been interwoven.
	 Return the new list. If the lists are of unequal lengths, simply attach the remaining elements of the longer
	 list to the new list before returning it.
	 interleaveLists( [1, 2, 3], [4, 5, 6] )  ->  [1, 4, 2, 5, 3, 6]
	 */
	public List<Integer> interleaveLists(List<Integer> listOne, List<Integer> listTwo) {

		List<Integer> listThree = new ArrayList<>();


		if (listOne.size() > listTwo.size()) {


			for (int i = 0; i < listOne.size(); i++) {
				if (i >= listTwo.size()) {
					listThree.add(listOne.get(i));
				} else {
					listThree.add(listOne.get(i));
					listThree.add(listTwo.get(i));

				}
			}

		} else if (listOne.size() < listTwo.size()) {
			for (int i = 0; i < listTwo.size(); i++) {
				if (i >= listOne.size()) {
					listThree.add(listTwo.get(i));
				} else {
					listThree.add(listOne.get(i));
					listThree.add(listTwo.get(i));

				}
			}
		} else {
			for (int i = 0; i < listOne.size(); i++) {

				listThree.add(listOne.get(i));
				listThree.add(listTwo.get(i));
			}
		}


		return listThree;
	}
	}

