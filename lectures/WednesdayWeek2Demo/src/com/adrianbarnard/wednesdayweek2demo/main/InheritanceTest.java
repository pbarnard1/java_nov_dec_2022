package com.adrianbarnard.wednesdayweek2demo.main;

// Autoimport: Ctrl + Shift + O or Cmd + Shift + O
import com.adrianbarnard.wednesdayweek2demo.models.Home;
import com.adrianbarnard.wednesdayweek2demo.models.Mansion;

public class InheritanceTest {

	public static void main(String[] args) {
		// Creating a Home and testing it out
		Home myHome = new Home(1500, 2, 3, 1);
		// Notice that since we're not in those other classes that we MUST use getters and setters!
		System.out.println(myHome.getSquareFootage());
		myHome.addBedroom();
		System.out.println(myHome.getNumberBedrooms());
		// Creating a Mansion and testing it out
		Mansion myMansion = new Mansion(25000, 8, 15, 4, true, true, "Barnard Fountain");
		System.out.println(myMansion.getFountainName());
		myMansion.addBedroom();
		System.out.println(myMansion.getNumberBedrooms());
		System.out.println(myMansion.getSquareFootage());
	}

}
