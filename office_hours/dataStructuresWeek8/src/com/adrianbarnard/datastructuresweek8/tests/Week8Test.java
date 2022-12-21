package com.adrianbarnard.datastructuresweek8.tests;

import com.adrianbarnard.datastructuresweek8.classes.Node;
import com.adrianbarnard.datastructuresweek8.classes.Stack;

public class Week8Test {

	public static void main(String[] args) {
		Stack myStack = new Stack();
		myStack.push(new Node("Hello!"));
//		System.out.println(myStack.getTopValue());
		myStack.push(new Node("World!"));
		myStack.printStack();
//		System.out.println(myStack.getTopValue());
//		System.out.println(myStack.getTop().getValue());
//		System.out.println("Now testing removing a node:");
//		Node removedNode = myStack.pop();
//		System.out.println(myStack.getTop().getValue());
//		System.out.println(removedNode.getValue());
		
	}

}
