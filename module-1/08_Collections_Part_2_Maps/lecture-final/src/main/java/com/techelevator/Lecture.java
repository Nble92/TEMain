package com.techelevator;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Lecture {

	public static void main(String[] args) {

		System.out.println("####################");
		System.out.println("        MAPS");
		System.out.println("####################");
		System.out.println();


		Map<String, String> nameToZip = new HashMap<>();

		nameToZip.put("David", "44120");
		nameToZip.put("Tom", "18966");
		nameToZip.put("Sally", "12345");

		String davidsZip = nameToZip.get("David");
		System.out.println("David lives in " + davidsZip);

		String sallysZip = nameToZip.get("Sally");
		System.out.println("Sally lives in " + sallysZip);


		boolean contains = nameToZip.containsKey("Tom");
		System.out.println("Tom is in the map :" + contains);

		contains = nameToZip.containsKey("Doug");
		System.out.println("Doug is in the map :" + contains);

		nameToZip.put("Joe", "12345");
		nameToZip.put("David", "12345");

		davidsZip = nameToZip.get("David");
		System.out.println("David lives in " + davidsZip);

		System.out.println("The size of our map is " + nameToZip.size());


		Set<String> keys = nameToZip.keySet();

		System.out.println(keys);

		for (String key: keys) {
			System.out.println(key);
		}

		// entrySet returns a set of entries from the map.
		// the set is a generic type -  its type is the Map.Entry from the map
		// The entry is also a generic type - its types are the same as the map
		// that it came from which is String, String
		Set<Map.Entry<String, String>> entries =  nameToZip.entrySet();

		for (Map.Entry<String, String> entry : entries) {

			String key = entry.getKey();
			String value = entry.getValue();

			System.out.println("key is " + key + " and value is " + value);
		}


		nameToZip.remove("Tom");

		System.out.println("Tom has been removed");
		System.out.println("");
		for (Map.Entry<String, String> entry : entries) {

			String key = entry.getKey();
			String value = entry.getValue();

			System.out.println("key is " + key + " and value is " + value);
		}


		Set<Integer> numbers = new HashSet<>();

		numbers.add(12);
		numbers.add(34);
		numbers.add(99);

		System.out.println(numbers);

		System.out.println("12 is in the set " + numbers.contains(12));
		System.out.println("25 is in the set " + numbers.contains(25));

		System.out.println("34 is in the set " + numbers.contains(34));
		numbers.remove(34);
		System.out.println("34 is in the set " + numbers.contains(34));

		System.out.println("the size of out set is " + numbers.size());


	}





}
