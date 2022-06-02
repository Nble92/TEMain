package com.techelevator.farm;

import java.util.ArrayList;
import java.util.List;

public class OldMacdonald {
	public static void main(String[] args) {

//		Cow c1 = new Cow();
//		if (c1.isAsleep()){
//			System.out.println("She's Asleep.");
//		}


		Cow cow = new Cow();
		cow.sleep(true);

		Cat cat = new Cat();
		cat.sleep(true);


		//declaring a FarmAnimal variable called animal. This is instantiating FarmAnimal
		//Now that FarmAnimal is an abstract class you can't instantiate it
		//FarmAnimal animal = new FarmAnimal("Foo","Bar");

		//Alt Enter can import things instantly
		List<FarmAnimal> farmAnimalList = new ArrayList<>();
		farmAnimalList.add(new Cow());
		farmAnimalList.add(new Cat());
		farmAnimalList.add(new Chicken());
		farmAnimalList.add(new Pig());

		for (FarmAnimal animal2 : farmAnimalList){
			System.out.println(animal2.eat());


		}

		Singable[] singables =
				new Singable[] {cow, new Chicken(), new Pig(), new Tractor(), cat};

		for (Singable singable : singables) {
			String name = singable.getName();
			String sound = singable.getSound();
			System.out.println("Old MacDonald had a farm, ee, ay, ee, ay, oh!");
			System.out.println("And on his farm he had a " + name
					+ ", ee, ay, ee, ay, oh!");
			System.out.println("With a " + sound + " " + sound + " here");
			System.out.println("And a " + sound + " " + sound + " there");
			System.out.println("Here a " + sound + " there a " + sound
					+ " everywhere a " + sound + " " + sound);
			System.out.println();
		}

		Sellable[] sellables = new Sellable[] {new Cow(), new Pig(), new Egg()};

		for (Sellable sellable : sellables) {
			System.out.println("Step right up and get your " + sellable.getName());
			System.out.println("Only $" + sellable.getPrice());
		}
	}
}