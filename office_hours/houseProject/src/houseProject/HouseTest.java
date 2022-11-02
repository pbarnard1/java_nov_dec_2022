package houseProject;

import java.util.ArrayList;

public class HouseTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<House> myHouses = new ArrayList<House>();
//		HashSet<Integer> myNumbers = new HashSet<Integer>();
		
		myHouses.add(new House());
		myHouses.add(new House(5, 3, "blue", 1000000));
		for (House h : myHouses) {
			System.out.println(h.getColor());
		}
		System.out.println(myHouses);
	}

}
