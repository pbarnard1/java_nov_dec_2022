package com.adrianbarnard.datastructuresweek8.classes;

public class Stack {
	private Node top; // First Node in the stack (or null if the stack is empty)
	
	// Constructors
	public Stack() {
		this.top = null; // Empty stack
	}
	
	public Stack(Node firstNode) {
		this.top = firstNode; // Make the passed-in node the top of the stack
	}
	
	// Getters and setters
	public Node getTop() {
		return top;
	}

	public void setTop(Node top) {
		this.top = top;
	}
	
	public Object getTopValue() { // Get the value at the top of the stack
		// Edge case: Whether the stack is empty
		if (this.top == null) {
			return null;
		} else { // Otherwise the stack is NOT empty, so it has at least one Node
			return this.top.getValue();
		}
	}
	
	// Add a Node to the top of the stack and return the new top of the stack
	public Node push(Node newNode) {
		newNode.setNext(this.top); // Attach this new node to the top of the current stack
		this.top = newNode;// Make this node the top of the stack
		return this.top;
	}
	
	// Remove a Node from the stack and return it
	public Node pop() {
		if (this.top == null) { // Edge case - the stack is empty, so we'll return null
			return null;
		}
		Node removedNode = this.top; // New variable that will hold on to the first node in our Stack
		this.top = this.top.getNext(); // Move the top of the stack down
		removedNode.setNext(null); // Disconnect this Node from the stack
		return removedNode;
	}
	
	// Print the entire stack
	public void printStack() {
		Node curNode = this.top; // Start at the top
		while (curNode != null) {
			System.out.println(curNode.getValue());
			curNode = curNode.getNext();
		}
	}
}
