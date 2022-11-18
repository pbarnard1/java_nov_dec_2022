package com.adrianbarnard.thursdayalgosweek4;

import java.util.ArrayList;

public class AlgosWeek4 {
	/* From the Algorithm Book (page 52) - Valid Parens
	 * Create a function that, given an input string str, returns a boolean whether 
	 * parentheses in str are valid. Valid sets of parentheses always open before they close, 
	 * f or example. For "Y(3(p)p(3)r)s", return true. Given "N(0(p)3", return false: not every
	 * parenthesis is closed. Given "N(0)t )0(k", return false, because the underlined ")" 
	 * is premature: there is nothing open for it to close.
	 */
	
	public boolean isValidParens(String inputStr) {
		ArrayList<Character> allParens = new ArrayList<Character>();
//		char[] allChars = inputStr.toCharArray(); // Then do for (char c : allChars) {}
		for (int i = 0; i < inputStr.length(); i++) {
			char currentChar = inputStr.charAt(i);
			if (currentChar == '(') {
				allParens.add((Character) currentChar); // Add one '('
			} else if (currentChar == ')') {
				if (allParens.isEmpty()) { // ArrayList is empty
					return false; // Can't pair up a ')', so no need to check anymore - return false
				} else { // ArrayList is NOT empty
					allParens.remove(allParens.size()-1); // Remove one '('
				}
			}
		}
		if (allParens.isEmpty()) { // All ( and ) paired up successfully
			return true;
		} else { // At least one ( NOT paired up
			return false;
		}
		// return allParens.isEmpty(); // One-line version
	}
	
	public boolean isValidParensV2(String inputStr) {
		int countUnpairedParens = 0;
		for (int i = 0; i < inputStr.length(); i++) {
			char currentChar = inputStr.charAt(i);
			if (currentChar == '(') {
				countUnpairedParens++; // Add one '(' that's unpaired
			} else if (currentChar == ')') {
				if (countUnpairedParens <= 0) { // No '(' to pair up with the found ')'
					return false; // Can't pair up a ')', so no need to check anymore - return false
				} else { // At least one '(' left to be paired
					countUnpairedParens--; // Found a '(' to go with ')', so decrease number of unpaired '(' by 1
				}
			}
		}
		return countUnpairedParens == 0; // One-line version: if there are no '(' to pair up, the number is 0, so we're good, otherwise if there is at least one, no good
	}
}
