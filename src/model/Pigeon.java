package model;

public class Pigeon extends Animal {
	
	public String family;
	public String species = "pigeon";

	public Pigeon(String name, double weight, double height, String family) {
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
		System.out.println("This one's a pigeon.");
		System.out.println("Pigeon is an ancient form of email.");
		System.out.println("They are very handy since they can fly.");
	}

}
