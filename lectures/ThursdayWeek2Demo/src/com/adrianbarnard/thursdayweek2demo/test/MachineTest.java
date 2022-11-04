package com.adrianbarnard.thursdayweek2demo.test;

import java.util.HashMap;

import com.adrianbarnard.thursdayweek2demo.models.SnackMachine;

public class MachineTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SnackMachine schoolMachine = new SnackMachine(true, true, new HashMap<String, Integer>(), new HashMap<String, Double>(), true);
		
		schoolMachine.restockItem("M&Ms", 20, 1.49);
		schoolMachine.restockItem("Lay's Potato Chips", 15, 1.39);
		schoolMachine.buyItem("M&Ms", 2.00);
		System.out.println(schoolMachine.getAllItems());
		System.out.println(schoolMachine.getAllPrices());
		
	}

}
