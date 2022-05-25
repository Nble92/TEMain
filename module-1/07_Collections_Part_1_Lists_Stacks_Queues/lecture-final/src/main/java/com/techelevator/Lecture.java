package com.techelevator;

import java.util.*;

public class Lecture {

	public static void main(String[] args) {
		System.out.println("####################");
		System.out.println("       LISTS");
		System.out.println("####################");

		List<String> names = new ArrayList<>();
		names.add("Tom");
		names.add("Myron");
		names.add("Mary");
		names.add("Jane");
		names.add("Kate");
		names.add("Fred");


		System.out.println("####################");
		System.out.println("Lists are ordered");
		System.out.println("####################");


		System.out.println(names);

		for (int i = 0; i < names.size(); i++) {
			System.out.println(names.get(i));
		}

		System.out.println("####################");
		System.out.println("Lists allow duplicates");
		System.out.println("####################");

		names.add("Mary");

		for (int i = 0; i < names.size(); i++) {
			System.out.println(names.get(i));
		}

		System.out.println("####################");
		System.out.println("Lists allow elements to be inserted in the middle");
		System.out.println("####################");

		names.add(2, "David");

		for (int i = 0; i < names.size(); i++) {
			System.out.println(names.get(i));
		}


		System.out.println("####################");
		System.out.println("Lists allow elements to be removed by index");
		System.out.println("####################");

		names.remove(3);
		for (int i = 0; i < names.size(); i++) {
			System.out.println(names.get(i));
		}


		System.out.println("####################");
		System.out.println("Find out if something is already in the List");
		System.out.println("####################");

		boolean inList = names.contains("Jane");
		System.out.println("Jane is in the list: " +  inList);

		inList = names.contains("Harry");
		System.out.println("Harry is in the list: " + inList);

		System.out.println("####################");
		System.out.println("Find index of item in List");
		System.out.println("####################");

		int indexOfMyron = names.indexOf("Myron");
		System.out.println("Index of Myron is " + indexOfMyron);


		System.out.println("####################");
		System.out.println("Lists can be turned into an array");
		System.out.println("####################");

		String[] namesArray = new String[names.size()];
        for (int i = 0; i < names.size(); i++) {
			namesArray[i] = names.get(i);
		}

		for (int i = 0; i < namesArray.length; i++) {
			System.out.println(namesArray[i]);
		}

		System.out.println("new array using toArray...");
		String[] namesArray2 = names.toArray(new String[0]);

		for (int i = 0; i < namesArray2.length; i++) {
			System.out.println(namesArray2[i]);
		}


		System.out.println("####################");
		System.out.println("Lists can be sorted");
		System.out.println("####################");

		Collections.sort(names);
		for (int i = 0; i < names.size(); i++) {
			System.out.println(names.get(i));
		}


		System.out.println("####################");
		System.out.println("Lists can be reversed too");
		System.out.println("####################");


		Collections.reverse(names);

		for (int i = 0; i < names.size(); i++) {
			System.out.println(names.get(i));
		}

		List<Integer> numbers = new ArrayList<>();

		numbers.add(7);
		numbers.add(7);
		numbers.add(8);
		numbers.add(11117);
		numbers.add(7);
		numbers.add(70000);
		numbers.add(7);

		for (int i = 0; i < numbers.size(); i++) {
			System.out.println(numbers.get(i));
		}



		Integer num1 = 7;
		Integer num2 = new Integer(7);
		Integer num3 = Integer.valueOf(7);

		System.out.println(num1 + " is equal to " + num2);
		if(num1.equals(num2) ) {

		}





		System.out.println("####################");
		System.out.println("       FOREACH");
		System.out.println("####################");
		System.out.println();


		for (String name : names) {
			System.out.println(name);
		}

		for (int i = 0; i < names.size(); i++) {
			System.out.println(names.get(i));
		}

		List<Student> students = new ArrayList<>();
		students.add(new Student());

		for (Student student: students) {
			System.out.println(student.getName() + " " + student.getAddress());
		}


		Queue<String> namesQueue = new LinkedList<>();
		namesQueue.offer("Tom");
		namesQueue.offer("Myron");
		namesQueue.offer("Dave");

		String firstInLine = namesQueue.poll();
		String secondOnLine = namesQueue.poll();

		System.out.println(firstInLine);
		System.out.println(secondOnLine);


		Stack<String> namesStack = new Stack<>();
		namesStack.push("Tom");
		namesStack.push("Myron");

//		String zeroElement = namesStack.get(0);
//
//		namesStack.remove(0);
//
//		String firstOff = namesStack.pop();
//		String secondOff = namesStack.pop();
//
//		System.out.println(firstOff);
//		System.out.println(secondOff);
//
//		System.out.println("zero element = " + zeroElement);



		m1();
	}


	public static void m1() {
		System.out.println("result is " + m3(100));
	}


	public static int m2(int a) {

		return a + 10;
	}


	public static int m3(int b) {
		return m2(b);
	}



}
