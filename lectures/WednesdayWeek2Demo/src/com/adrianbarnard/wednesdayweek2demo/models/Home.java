package com.adrianbarnard.wednesdayweek2demo.models;

public class Home {
	private int squareFootage;
	private int numberBathrooms;
	private int numberBedrooms;
	private int numberStories;
	
	
	
	public Home(int squareFootage, int numberBathrooms, int numberBedrooms, int numberStories) {
		this.squareFootage = squareFootage;
		this.numberBathrooms = numberBathrooms;
		this.numberBedrooms = numberBedrooms;
		this.numberStories = numberStories;
	}
	
	public void addBedroom() {
		// Add a new bedroom that's 250 square feet
		this.numberBedrooms++;
		this.squareFootage += 250;
	}
	
	public int getSquareFootage() {
		return squareFootage;
	}
	public void setSquareFootage(int squareFootage) {
		this.squareFootage = squareFootage;
	}
	public int getNumberBathrooms() {
		return numberBathrooms;
	}
	public void setNumberBathrooms(int numberBathrooms) {
		this.numberBathrooms = numberBathrooms;
	}
	public int getNumberBedrooms() {
		return numberBedrooms;
	}
	public void setNumberBedrooms(int numberBedrooms) {
		this.numberBedrooms = numberBedrooms;
	}
	public int getNumberStories() {
		return numberStories;
	}
	public void setNumberStories(int numberStories) {
		this.numberStories = numberStories;
	}
	
}
