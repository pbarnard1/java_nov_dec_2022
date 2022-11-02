
public class Pet {
	private String breed;
	private int age;
	private String color;
	private String species; // cat, dog, etc.
	private boolean hasTail;
	
	public Pet() {
		this.breed = "terrier";
		this.age = 2;
		this.color = "brown";
		this.species = "dog";
		this.hasTail = true;
	}
	
	public Pet(String breed, int age, String color, String species, boolean hasTail) {
		this.breed = breed;
		this.age = age;
		this.color = color;
		this.species = species;
		this.hasTail = hasTail;
	}
	public String getBreed() {
		return breed;
	}
	public void setBreed(String breed) {
		this.breed = breed;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getSpecies() {
		return species;
	}
	public void setSpecies(String species) {
		this.species = species;
	}
	public boolean isHasTail() {
		return hasTail;
	}
	public void setHasTail(boolean hasTail) {
		this.hasTail = hasTail;
	}
}
