package com.adrianbarnard.datastructuresweek8.classes;

public class Node {
	// Attributes
	private Object value; // Generic Object - Integer, String, etc.
	private Node next; // Attribute that points to the next Node
	
	// Overloaded constructors
	public Node() {
		this.value = null;
		this.next = null;
	}
	
	public Node(Object value) {
		this.value = value;
		this.next = null;
	}
	
	public Node(Object value, Node nextNode) {
		this.value = value;
		this.next = nextNode;
	}

	// Getters and setters
	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}
}
