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


		Map<String, String> gamePublisher = new HashMap<>();

		gamePublisher.put("Halo","Microsoft");
		gamePublisher.put("God of War", "Sony");
		gamePublisher.put("Smash Bros", "Nintendo");

		String smash = gamePublisher.get("Smash Bros");
		String gow = gamePublisher.get("God of War");
		boolean contains = gamePublisher.containsKey("Halo");


		Set<String> keys = gamePublisher.keySet();
			for (String kiki : keys) {

				System.out.println(kiki);
			}
			Set<Map.Entry<String,String>> entries = gamePublisher.entrySet();


			//entrySet returns a set of entries <key, value>
			//the set is a generic type - its type is Map.Entry
			for (Map.Entry<String, String> entry : entries) {

				String key = entry.getKey();
				String value = entry.getValue();


				System.out.println("key is " + key + " and value is " + value);

			}
		gamePublisher.remove("Smash Bros");
		System.out.println("Smash is cancelled");

		System.out.println(gamePublisher.size());
		System.out.println(smash);
		System.out.println(gow);

		Set<Integer> numbas = new HashSet<>();

numbas.add(12);
numbas.add(17);
numbas.add(220);

		System.out.println(numbas);
		System.out.println("220 is in the set " + numbas.contains(220));

		numbas.remove(12);
		System.out.println("Size equals " + numbas.size());

	}

}
