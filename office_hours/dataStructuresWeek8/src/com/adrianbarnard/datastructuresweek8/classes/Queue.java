package com.adrianbarnard.datastructuresweek8.classes;

public class Queue {
	private Node front;
	private Node back;
	
	public Queue() { // Start off with an empty Queue
		this.front = null;
		this.back = null;
	}
	
	// Add a Node to the back of the Queue and we'll return the new back of the Queue
	public Node enqueue(Node newNode) {
		if (this.back == null) { // Edge case: If the Queue is empty
			// Make this new Node the front AND back
			this.front = newNode;
			this.back = newNode;
			return this.back;
		} else { // There is at least one Node in our Queue
			// Connect the back of the Queue to the new node
			this.back.setNext(newNode);
			this.back = newNode; // Move the back of the Queue to the new node
			return this.back;
		}
	}
	
	// Remove a Node from the front of the Queue and return the removed Node
	public Node dequeue() {
		if (this.front == null) { // Edge case: the Queue is empty
			return null;
		}
		Node frontNode = this.front; // Variable holding on to the original of the Queue
		this.front = frontNode.getNext(); // Move the front of the Queue down one Node
		frontNode.setNext(null); // Detach the original front of the Queue from the Queue itself
		if (this.front == null) { // Edge case - where the original Queue only had one Node, so we must have the back point to null
			this.back = null;
		}
		return frontNode;
	}

	public Node getFront() {
		return front;
	}

	public void setFront(Node front) {
		this.front = front;
	}

	public Node getBack() {
		return back;
	}

	public void setBack(Node back) {
		this.back = back;
	}
}
