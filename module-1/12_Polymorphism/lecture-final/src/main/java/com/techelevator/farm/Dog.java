package com.techelevator.farm;

public class Dog extends FarmAnimal{

    private String size;

    public Dog(String size) {
        super(size + " Dog", "woof!");
        this.size = size;
    }

    public String getSize() {
        return size;
    }
}
