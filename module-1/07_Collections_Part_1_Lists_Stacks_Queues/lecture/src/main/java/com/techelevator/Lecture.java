package com.techelevator;

import java.util.*;

public class Lecture {

	public static void main(String[] args) {
		System.out.println("####################");
		System.out.println("       LISTS");
		System.out.println("####################");

		List<String> name = new ArrayList<>(); //assigns Arraylist
		name.add("Noble");
		name.add("Jen");
		name.add("Bojack");
		for (int i = 0; i < name.size(); i++) {
			System.out.println(name.get(i));

		}


		System.out.println("####################");
		System.out.println("Lists are ordered");
		System.out.println("####################");


		System.out.println("####################");
		System.out.println("Lists allow duplicates");
		System.out.println("####################");
		name.add("Noble");

		for (int i = 0; i < name.size(); i++) {
			System.out.println(name.get(i));

		}

		System.out.println("####################");
		System.out.println("Lists allow elements to be inserted in the middle");
		System.out.println("####################");
		name.add(3, "John");
		for (int i = 0; i < name.size(); i++) {
			System.out.println(name.get(i));
		}
			System.out.println("####################");
			System.out.println("Lists allow elements to be removed by index");
			System.out.println("####################");
		name.remove(3);
		for (int i = 0; i < name.size(); i++) {
			System.out.println(name.get(i));
		}

			System.out.println("####################");
			System.out.println("Find out if something is already in the List");
			System.out.println("####################");
		boolean inList = name.contains("Jen");
		System.out.println("Jen is in the list: " + inList);

			System.out.println("####################");
			System.out.println("Find index of item in List");
			System.out.println("####################");
		System.out.println("Noble is in position: " + name.indexOf("Noble"));


		System.out.println("####################");
			System.out.println("Lists can be turned into an array");
			System.out.println("####################");

String[] nameArray = name.toArray(new String[0]);
		{
			System.out.println(nameArray[2]);

		}

		Collections.sort(name);

			System.out.println("####################");
			System.out.println("Lists can be sorted");
			System.out.println("####################");


			System.out.println("####################");
			System.out.println("Lists can be reversed too");
			System.out.println("####################");


			System.out.println("####################");
			System.out.println("       FOREACH");
			System.out.println("####################");
			System.out.println();

		Queue<String> nameQueue = new LinkedList<>();
		nameQueue.offer("Techy");
		nameQueue.offer("Smokey");
		nameQueue.offer("Snorty");
		String firstInLine = nameQueue.poll();
		String secondInLine = nameQueue.poll();
		System.out.println(secondInLine);





		Stack<String> nameStack = new Stack<>();
		nameStack.push("Noble");

			}


}

