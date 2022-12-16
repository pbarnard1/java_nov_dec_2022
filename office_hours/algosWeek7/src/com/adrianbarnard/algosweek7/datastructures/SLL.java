package com.adrianbarnard.algosweek7.datastructures;

public class SLL { // Singly Linked List class
	private Node head; // First node in our list
	
	public SLL() {
		this.head = null; // No nodes to start with
	}
	
	public SLL(Node firstNode) {
		this.head = firstNode;
	}
	
	// Add a Node to the front of the existing list and return the new head of the list
	public Node addToFront(Node newNode) {
		// Take the new node we're passing in and attach it to the start of the list
		newNode.setNext(this.head);
		this.head = newNode; // Have the head point to the new first node
		return this.head;
	}
	
	// Print out all the values in our singly linked list
	public void printNodes() {
		Node currentNode = this.head;
		while (currentNode != null) {
			// Print the current Node's value
			System.out.println(currentNode.getValue());
			// Move on to the next Node in the list
			currentNode = currentNode.getNext();
		}
	}

	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}
	
	
}
