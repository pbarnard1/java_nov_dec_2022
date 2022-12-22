package com.adrianbarnard.datastructuresweek8.tests;

import com.adrianbarnard.datastructuresweek8.classes.Node;
import com.adrianbarnard.datastructuresweek8.classes.Queue;
import com.adrianbarnard.datastructuresweek8.classes.Stack;

public class Week8Test {

	public static void main(String[] args) {
		Stack myStack = new Stack();
		myStack.push(new Node("Hello!"));
//		System.out.println(myStack.getTopValue());
		myStack.push(new Node("World!"));
		myStack.printStack();
		System.out.println(myStack.getTopValue());
		System.out.println(myStack.getTop().getValue());
		System.out.println("Now testing removing a node:");
		Node removedNode = myStack.pop();
		System.out.println(myStack.getTop().getValue());
		System.out.println(removedNode.getValue());
		Queue myQueue = new Queue();
		myQueue.enqueue(new Node(1));
		System.out.println(myQueue.getBack().getValue());
//		System.out.println(myQueue.getFront().getValue());
		myQueue.enqueue(new Node(2));
//		System.out.println(myQueue.getFront().getNext().getValue());
		System.out.println(myQueue.getBack().getValue());
		
	}

}
