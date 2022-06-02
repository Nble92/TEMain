package com.techelevator.farm;

//making the class abstract prevents instantiation
//it's solely for inheritance and polymorphism(need more polymorphism examples)
public abstract class FarmAnimal implements Singable {
	private String name;
	private String sound;
	private boolean asleep;

	public FarmAnimal(String name, String sound) {
		this.name = name;
		this.sound = sound;
	}

	public void sleep(boolean isAsleep){
		this.asleep = isAsleep;
	}
	public String getName( ) {
		return name;
	}
	public final String getSound( ) {
		if (isAsleep()){
			return "zzZZZzzzZZZ";
		}
		return sound;
	}
	public boolean isAsleep() {return asleep;}

	//this is an abstract method. This sets a rule that each con subclass needs this method;
	//abstract methods only work with abstract classes
	//You can make subclasses abstract but at some point this abstract method has to bee...
	//implemented by some other concrete class OR it can be implemented by another abstract class that would be;
	//inherited by their concrete subclasses
	public abstract String eat();
}
