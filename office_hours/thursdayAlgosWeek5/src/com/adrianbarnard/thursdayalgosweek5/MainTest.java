package com.adrianbarnard.thursdayalgosweek5;

public class MainTest {

	public static void main(String[] args) {
		// Test cases for various book lengths and page goals
		Week5Algos ourAlgos = new Week5Algos();
		for (int bookLength = 1; bookLength <= 20; bookLength++) {
			for (int goalPage = 1; goalPage <= bookLength; goalPage++) {
				System.out.println("For book length of " + bookLength + " and a goal of page " + goalPage + ":");
				System.out.println(ourAlgos.countPageFlips(bookLength, goalPage));
			}
		}
	}

}
