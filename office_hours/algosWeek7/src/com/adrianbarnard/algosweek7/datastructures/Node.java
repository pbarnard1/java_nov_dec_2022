package com.adrianbarnard.algosweek7.datastructures;

public class Node { // Node class
	private int value;
	private Node next; // Pointing to the next Node
	
	// Create a standalone Node with a value only that's not linked to any other Nodes
	public Node(int value) {
		this.value = value;
		this.next = null;
	}
	
	// Creates a new Node while linking to a previous existing one called nextNode
	public Node(int value, Node nextNode) {
		this.value = value;
		this.next = nextNode;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}
	
	
}
