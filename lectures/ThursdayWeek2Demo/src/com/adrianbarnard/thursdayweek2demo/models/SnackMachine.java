package com.adrianbarnard.thursdayweek2demo.models;

import java.util.HashMap;

public class SnackMachine extends VendingMachine implements MachineInterface {
	private boolean isOn;
	

	public SnackMachine(boolean hasDollarBillSlot, boolean acceptsCards, HashMap<String, Integer> allItems,
			HashMap<String, Double> allPrices, boolean isOn) {
		super(hasDollarBillSlot, acceptsCards, allItems, allPrices);
		this.isOn = isOn;
	}

	@Override
	public void turnOn() {
		if (isOn) {
			System.out.println("Already turned on");
		} else {
			isOn = true;
			System.out.println("Turning machine on");
		}
	}

	@Override
	public void turnOff() {
		if (!isOn) {
			System.out.println("Already turned off");
		} else {
			isOn = false;
			System.out.println("Turning machine off");
		}
	}

	@Override
	public void buyItem(String item, double payment) {
		// Grab inventory and prices with getter methods
		HashMap<String, Integer> currentInventory = this.getAllItems();
		HashMap<String, Double> currentPrices = this.getAllPrices();
		// Check to see whether the item was already in stock - and its price, if possible
		Integer currentQuantity = currentInventory.get(item);
		Double currentPrice = currentPrices.get(item);
		if (currentQuantity == null || currentQuantity <= 0) { // Item wasn't there before or is out
			System.out.println("Item cannot be found - can't buy");
		} else if (currentPrice > payment) { // Not enough money
			System.out.println("Insufficent funds");
		} else { // Item is there, so remove one from quantity
			currentInventory.put(item, currentQuantity - 1);
		}
	}

	@Override
	public void restockItem(String item, int quantity, double price) {
		HashMap<String, Integer> currentInventory = this.getAllItems();
		HashMap<String, Double> currentPrices = this.getAllPrices();
		// Check to see whether the item was already in stock
		Integer currentQuantity = currentInventory.get(item);
		if (currentQuantity == null) { // Item wasn't there before
			currentInventory.put(item, quantity); // Add this item's quantity
			currentPrices.put(item, price); // Add this price
		} else { // Item is there, so add on
			currentInventory.put(item, currentQuantity + quantity);
		}
	}

}
