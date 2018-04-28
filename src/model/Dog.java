package model;

public class Dog extends Animal {
	
	public String family;
	public String species = "dog";
	
	public Dog(String name, double weight, double height, String family) {
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
		System.out.println("We've got a dog over here.");
		System.out.println("Dogs are very good at fetching things.");
		System.out.println("Dogs are also good at protecting one's property.");
	}

}
