package com.adrianbarnard.algosweek7.problems;

import java.util.ArrayList;
import java.util.HashMap;

public class WednesdayWeek7 {
	/* Modified from Hacker Rank: 
	 * Given an array of String arrays, count and print the number of unique pairs.  For example:
	 * { {John, Joe}, {Jane, Jack}, {Jane, Jack}, {John, Jack} }
	 * would print 1, 2, 2, 3 because we have a duplicate {Jane, Jack}.
	 */
	
	public void countUniquePairs(String[][] namesArr) {
		// Use a hash map, where the key is a String that represents the first name, and the value
		// linked to the key is an array - or actually ArrayList - of second names linked to the first name
		// to keep track of who the first name is paired up with.
		HashMap<String, ArrayList<String>> hashNameMap = new HashMap<String, ArrayList<String>>();
		int uniquePairs = 0; // Keep track of unique pairs encountered
		// Loop through each pair of names
		for (int i = 0; i < namesArr.length; i++) {
			String firstName = namesArr[i][0];
			String secondName = namesArr[i][1];
			// Check to see whether the first name was already encountered
			if (!hashNameMap.containsKey(firstName)) { // New first name
				ArrayList<String> secondNames = new ArrayList<String>(); // Create a new empty ArrayList for linking to this first name
				secondNames.add(secondName); // Add this second name
				// Add this key-value to the hash map
				hashNameMap.put(firstName, secondNames);
				uniquePairs++;
			} else { // First name was previously encountered
				// Grab ArrayList of names linked to this already found firstName
				ArrayList<String> secondNames = hashNameMap.get(firstName);
				if (!secondNames.contains(secondName)) { // If we have a new second person linked to this first name
					secondNames.add(secondName); // Add this new second person
					hashNameMap.replace(firstName, secondNames); // Relink this key to the modified ArrayList
					uniquePairs++;
				}
			}
			System.out.println(uniquePairs); // Print number of unique pairs after each check
		}
	}
	
	/*
	 * String[][] names = {
				{"John","Tom"}, // Point to one spot in memory
				{"John","Mary"},
				{"John","Tom"}, // Point to another spot in memory
				{"Adrian","Kim"},
				{"John","Tom"},
				{"Adrian","Tom"},
				{"Adrian","Kim"},	
		};
	 */
}
