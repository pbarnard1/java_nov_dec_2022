package com.adrianbarnard.thursdayalgosweek2;

import java.util.Arrays;

public class AlgoTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThursdayAlgos myAlgos = new ThursdayAlgos();
		int[] x = {1, 2, 3, 4, 5, 6};
		int[] y = {5, 8, 2, 4, 3};
		System.out.println("Before:");
		System.out.println(Arrays.toString(x));
		myAlgos.swapValues(x);
		System.out.println("After:");
		System.out.println(Arrays.toString(x));
		System.out.println("Before:");
		System.out.println(Arrays.toString(y));
		myAlgos.swapValues(y);
		System.out.println("After:");
		System.out.println(Arrays.toString(y));
		int[] z = {};
		myAlgos.swapValues(z);
		System.out.println(Arrays.toString(z));
		String testStr = "I love pumpkin pie!  Yum!!!!  Yummy!!!";
		System.out.println(myAlgos.countNonspaceChars(testStr));
		
	}

	
}
