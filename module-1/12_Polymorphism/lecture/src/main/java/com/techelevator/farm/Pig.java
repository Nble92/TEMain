package com.techelevator.farm;

import java.math.BigDecimal;

public class Pig extends FarmAnimal implements Sellable{

    public Pig() {
        super("Pig", "Oink");

    }
    public BigDecimal getPrice(){
        return new BigDecimal(300.00);
    }
    public String getName(){
        return "Pig";
    }
}
