package com.adrianbarnard.thursdayalgosweek4;

public class AlgosWeek4Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AlgosWeek4 myAlgos = new AlgosWeek4();
		System.out.println(myAlgos.isValidParens("Y(3(p)p(3)r)s"));
		System.out.println(myAlgos.isValidParens("N(0(p)3"));
		System.out.println(myAlgos.isValidParens("N(0)t )0(k"));
		System.out.println(myAlgos.isValidParens(")(())"));
		System.out.println(myAlgos.isValidParens("(()(()))"));
		System.out.println("-----------------------");
		System.out.println(myAlgos.isValidParensV2("Y(3(p)p(3)r)s"));
		System.out.println(myAlgos.isValidParensV2("N(0(p)3"));
		System.out.println(myAlgos.isValidParensV2("N(0)t )0(k"));
		System.out.println(myAlgos.isValidParensV2(")(())"));
		System.out.println(myAlgos.isValidParensV2("(()(()))"));
	}

}
