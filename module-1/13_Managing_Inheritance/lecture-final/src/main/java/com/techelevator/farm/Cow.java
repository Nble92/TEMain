package com.techelevator.farm;

import java.math.BigDecimal;

public class Cow extends FarmAnimal implements Sellable {
	private BigDecimal price;

	public Cow() {
		super("Cow", "moo!");
		price = calculateCowPrice("Some String", 99);
	}

	public BigDecimal getPrice() {
		return price;
	}

	public String eat() {
		return "Eating cow food...";
	}


	private BigDecimal calculateCowPrice(String foo, int bar) {
		// lots of code to figure out how much a cow costs...

		// change code to figure out cow cost...


		return new BigDecimal("1500.00");
	}

}
