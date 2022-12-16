package com.adrianbarnard.algosweek7.tests;

import java.util.LinkedList;

import com.adrianbarnard.algosweek7.datastructures.Node;
import com.adrianbarnard.algosweek7.datastructures.SLL;

public class AlgoTests {

	public static void main(String[] args) {
		// Demo from Wednesday
//		String[][] names = {
//				{"John","Tom"},
//				{"John","Mary"},
//				{"John","Tom"},
//				{"Adrian","Kim"},
//				{"John","Tom"},
//				{"Adrian","Tom"},
//				{"Adrian","Kim"},	
//		};
//		WednesdayWeek7 week7methods = new WednesdayWeek7();
//		week7methods.countUniquePairs(names);
		
		// Demo of our own singly linked list that we built ourselves
		SLL mySLL = new SLL();
		Node firstNode = new Node(10);
		Node secondNode = new Node(5);
		
		mySLL.addToFront(firstNode);
		mySLL.addToFront(secondNode);
//		System.out.println(mySLL.getHead().getValue());
//		System.out.println(mySLL.getHead().getNext().getValue());
		mySLL.printNodes();
		System.out.println("Second test");
		mySLL.printNodes();
		
		// Second way to create a singly linked list
		LinkedList<Integer> myLL = new LinkedList<Integer>();
		myLL.add(5);
		myLL.add(10);
		myLL.add(8);
		System.out.println(myLL.toString());
	}

}
