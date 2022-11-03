package com.adrianbarnard.wednesdayweek2demo.models;

public class Mansion extends Home {
	private boolean hasHelipad;
	private boolean hasSaunas;
	private String fountainName;
	
	
	public Mansion(int squareFootage, int numberBathrooms, int numberBedrooms, int numberStories, boolean hasHelipad,
			boolean hasSaunas, String fountainName) {
		// Call on Home constructor to add the first four fields
		super(squareFootage, numberBathrooms, numberBedrooms, numberStories);
		this.hasHelipad = hasHelipad;
		this.hasSaunas = hasSaunas;
		this.fountainName = fountainName;
	}
	
	// Overriding the addBedroom method from the Home class
	public void addBedroom() {
//		super.addBedroom();
		// Add 2 bedrooms
		// Here we MUST use getters and setters if the attributes from the superclass (parent class), Home,
		// are set to private.
		this.setNumberBedrooms(getNumberBedrooms() + 2);
		this.setSquareFootage(getSquareFootage() + 1000);
		// Alternately, we could directly do IF the attributes are set to protected instead:
		// this.numberBedrooms += 2;
		// this.squareFootage += 1000;
	}
	
	// Getters and setters
	public boolean isHasHelipad() {
		return hasHelipad;
	}
	public void setHasHelipad(boolean hasHelipad) {
		this.hasHelipad = hasHelipad;
	}
	public boolean isHasSaunas() {
		return hasSaunas;
	}
	public void setHasSaunas(boolean hasSaunas) {
		this.hasSaunas = hasSaunas;
	}
	public String getFountainName() {
		return fountainName;
	}
	public void setFountainName(String fountainName) {
		this.fountainName = fountainName;
	}
	
	
}
