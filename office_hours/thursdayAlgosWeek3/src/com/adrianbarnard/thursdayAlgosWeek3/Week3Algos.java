package com.adrianbarnard.thursdayAlgosWeek3;

public class Week3Algos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String test1 = "radar";
		String test2 = "adrian";
		String test3 = "Deed";
		String test4 = "rad ar";
		System.out.println(isPalindrome(test1)); // Also test isPalindromeV2
		System.out.println(isPalindrome(test2));
		System.out.println(isPalindrome(test3));
		System.out.println(isPalindrome(test4));
	}
	
	public static boolean isPalindrome(String testStr) {
		boolean isStillAPalindrome = true;
		String newString = ""; // Reversed string
		// Loop through each character in the string
		for (int i = testStr.length() - 1; i >= 0; i--) {
			newString += testStr.charAt(i); // Add current character to new string, going in reverse order
		}
		// Compare the strings to see if they're the same
		if (!newString.equalsIgnoreCase(testStr)) { // Do NOT use ==
			isStillAPalindrome = false;
		}
		return isStillAPalindrome;
	}

	public static boolean isPalindromeV2(String testStr) {
		int endInd;
		for (int i = 0; i < testStr.length() / 2; i++) {
			// Find the index we want in the second half of the string
			endInd = testStr.length() - i - 1; // Alternately, testStr.length() - (i + 1)
			char firstCharacter = testStr.charAt(i);
			char lastCharacter = testStr.charAt(endInd);
			if (Character.toUpperCase(firstCharacter) != Character.toUpperCase(lastCharacter)) { // != okay since we're comparing char values
				return false;
			}
		}
		return true; // If we make it through the entire phrase and it's a palindrome
	}
}
