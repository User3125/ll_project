package model;

public class Cat extends Animal {
	
	public String family;
	public String species = "cat";

	public Cat(String name, double weight, double height, String family) {
		super(name, weight, height);
		this.family = family;
	}

	@Override
	public String getSpecies() {
		return species;
	}

	@Override
	public void setSpecies(String species) {
		this.species = species;
	}

	@Override
	public void setFamily(String family) {
		this.family = family;		
	}

	@Override
	public String getFamily() {
		return this.family;
	}

	@Override
	public void performAction() {
		System.out.println("This here is a cat.");
		System.out.println("Cats don't do very much.");
		System.out.println("Frankly, they sleep all the time.");
	}

}
