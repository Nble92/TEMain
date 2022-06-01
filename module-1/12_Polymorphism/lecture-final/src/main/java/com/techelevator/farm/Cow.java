package com.techelevator.farm;

import java.math.BigDecimal;

public class Cow extends FarmAnimal implements Sellable {

	public Cow() {
		super("Cow", "moo!");
	}

	@Override
	public BigDecimal getPrice() {
		return new BigDecimal(1200.00);
	}
}
