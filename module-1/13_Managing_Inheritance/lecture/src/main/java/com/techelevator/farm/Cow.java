package com.techelevator.farm;

import java.math.BigDecimal;

public class Cow extends FarmAnimal implements Sellable {
	private BigDecimal price;

	public Cow() {
		super("Cow", "moo!");
		price = calculateCowPrice("Strang", 99);
	}

	public BigDecimal getPrice() {
		return price;
	}

	@Override
	public String eat() {
		return "eating cow food";
	}

	private BigDecimal calculateCowPrice(String foo, int bar) {
		//ex: lots of code to find cow cost

		//ex: change code to figure out cost...
		return new BigDecimal("1500.00");
	}
}
