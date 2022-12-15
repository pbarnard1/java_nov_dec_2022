package com.adrianbarnard.algosweek7.tests;

import com.adrianbarnard.algosweek7.problems.WednesdayWeek7;

public class AlgoTests {

	public static void main(String[] args) {
		// Demo from Wednesday
		String[][] names = {
				{"John","Tom"},
				{"John","Mary"},
				{"John","Tom"},
				{"Adrian","Kim"},
				{"John","Tom"},
				{"Adrian","Tom"},
				{"Adrian","Kim"},	
		};
		WednesdayWeek7 week7methods = new WednesdayWeek7();
		week7methods.countUniquePairs(names);
	}

}
