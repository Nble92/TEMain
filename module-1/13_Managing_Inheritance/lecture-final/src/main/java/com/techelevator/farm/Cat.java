package com.techelevator.farm;

public final class Cat extends FarmAnimal {
    public Cat(String type) {
        super("Cat", "meow");
    }

    public Cat() {
        super("Cat", "meow");
    }

    public Cat(int x) {
        super("Cat", "meow");
    }



    public String eat() {
        return "Eating cat food...";
    }

//    @Override
//    public String getSound() {
//        return "meow";
//    }
}
