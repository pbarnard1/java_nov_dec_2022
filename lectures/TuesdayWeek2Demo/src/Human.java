import java.util.ArrayList;

public class Human {
	// Four member variables (attributes) for the Human class - they're all private
	private double height;
	private String eyeColor;
	private int age;
	private String hairColor;
	private ArrayList<Pet> pets = new ArrayList<Pet>();

	public Human() {
		this.height = 66.0; // 66 inches
		this.eyeColor = "orange";
		this.age = 25;
		this.hairColor = "green";
	}
	
	public Human(double height, String eyeColor, int age, String hairColor) {
		this.height = height;
		this.eyeColor = eyeColor;
		this.age = age;
		this.hairColor = hairColor;
	}

	public Human(String eyeColor, String hairColor) {
		this.height = 66.0;
		this.age = 25;
		this.eyeColor = eyeColor;
		this.hairColor = hairColor;
	}
	
	public void adoptPet(Pet newPet) {
		this.pets.add(newPet);
	}
	
	// setAttributeName
	public void setHeight(double height) {
		this.height = height;
	}
	// getAttributeName
	public double getHeight() {
		return this.height;
	}
	public String getEyeColor() {
		return eyeColor;
	}
	public void setEyeColor(String eyeColor) {
		this.eyeColor = eyeColor;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getHairColor() {
		return hairColor;
	}
	public void setHairColor(String hairColor) {
		this.hairColor = hairColor;
	}
	public ArrayList<Pet> getPets() {
		return pets;
	}

	public void setPets(ArrayList<Pet> pets) {
		this.pets = pets;
	}
}
