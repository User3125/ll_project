package model;

public abstract class Animal {
	
	public String name;
	public double weight;
	public double height;
	
	public Animal (String name, double weight, double height) {
		this.name = name;
		this.weight = weight;
		this.height = height;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}
	
	public abstract void setSpecies(String family);
	
	public abstract String getSpecies();
	
	public abstract void setFamily(String family);
	
	public abstract String getFamily();
	
	public abstract void performAction();
	
	public void show() {
		System.out.println("Name: " + this.getName());
		System.out.println("Weight: " + this.getWeight() + " kg");
		System.out.println("Height: " + this.getHeight() + " m");
		System.out.println("Species: " + this.getSpecies());
		System.out.println("Family: " + this.getFamily());
		System.out.println("Unique capabilities:");
		this.performAction();
	}
}
