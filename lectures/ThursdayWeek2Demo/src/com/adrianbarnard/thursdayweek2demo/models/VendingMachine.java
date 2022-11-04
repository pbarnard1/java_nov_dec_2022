package com.adrianbarnard.thursdayweek2demo.models;

import java.util.HashMap;

public abstract class VendingMachine {
	private boolean hasDollarBillSlot;
	private boolean acceptsCards;
	private HashMap<String, Integer> allItems = new HashMap<String, Integer>();
	private HashMap<String, Double> allPrices = new HashMap<String, Double>();
	
	public abstract void buyItem(String item, double payment);
	
	public abstract void restockItem(String item, int quantity, double price);

	public VendingMachine(boolean hasDollarBillSlot, boolean acceptsCards, HashMap<String, Integer> allItems,
			HashMap<String, Double> allPrices) {
		super();
		this.hasDollarBillSlot = hasDollarBillSlot;
		this.acceptsCards = acceptsCards;
		this.allItems = allItems;
		this.allPrices = allPrices;
	}

	public boolean isHasDollarBillSlot() {
		return hasDollarBillSlot;
	}

	public void setHasDollarBillSlot(boolean hasDollarBillSlot) {
		this.hasDollarBillSlot = hasDollarBillSlot;
	}

	public boolean isAcceptsCards() {
		return acceptsCards;
	}

	public void setAcceptsCards(boolean acceptsCards) {
		this.acceptsCards = acceptsCards;
	}

	public HashMap<String, Integer> getAllItems() {
		return allItems;
	}

	public void setAllItems(HashMap<String, Integer> allItems) {
		this.allItems = allItems;
	}

	public HashMap<String, Double> getAllPrices() {
		return allPrices;
	}

	public void setAllPrices(HashMap<String, Double> allPrices) {
		this.allPrices = allPrices;
	}
}
