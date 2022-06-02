package com.techelevator.farm;

public class Chicken extends FarmAnimal {
//When you create a chicken, you call this constructor classes need constructors

	public Chicken() {
		//you do it by calling the farm animal constructor because a chicken IS A FarmAnimal
		super("Chicken", "cluck!");
	}

	public void layEgg() {
		System.out.println("Chicken laid an egg!");
	}

	@Override
	public String eat() {
		return "Eating chicken feed";
	}
}