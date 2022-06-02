package com.techelevator.farm;

public final class Cat extends FarmAnimal {
    public Cat() {
        super("Cat", "meow");
    }

    public Cat(String type) {
        super("Cat", "meow");
    }

    public Cat(int x) {
        super("Cat", "meow");
    }
        //this is overriding the FarmAnimal eating method
        public String eat(){
            return "Eating cat food.";


        }
    }






//    @Override
//    public String getSound() {
//        return "meow";
//    }

