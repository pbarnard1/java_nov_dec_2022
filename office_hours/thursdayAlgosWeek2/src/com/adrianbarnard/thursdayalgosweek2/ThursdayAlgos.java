package com.adrianbarnard.thursdayalgosweek2;

public class ThursdayAlgos {
	/*
	 * Given an array of integers, swap the 1st and last values, 2nd and second-to-last
	 * values, etc.
	 */
	public void swapValues(int[] intArray) {
		int tempValue;
		for (int i = 0; i < intArray.length / 2; i++) { // Swap each pair of values for each iteration of this loop
			tempValue = intArray[i]; // "first" index
			intArray[i] = intArray[intArray.length - i - 1]; // "last" index
			intArray[intArray.length - i - 1] = tempValue;
//			System.out.println("After i = " + i);
//			System.out.println(Arrays.toString(intArray));
		}

	}
	
	/*
	 * Given a string, return the number of NONspace characters found.
	 */
	public int countNonspaceChars(String messageStr) {
		int numNonspaceChars = 0; // Count
		char currentChar; // Current character
		for (int i = 0; i < messageStr.length(); i++) {
			currentChar = messageStr.charAt(i); // Grab character
			if (currentChar != ' ') { // Using single quotes means you're defining a character; double quotes means a string
				numNonspaceChars++; // Increment the count accordingly
			}
		}
		return numNonspaceChars;
	}
}
