import java.util.ArrayList; // To use ArrayList

public class ThursdayWeek1 {
    /*
    Write a method that accepts an array of integers, and returns a new array (?) with the array values that are greater
    than its 2nd value. Print how many values this is. What will you do if the array is only one element long?
    */

    // MUST be ArrayList<Integer> because:
    // 1. We don't know how many items are bigger than the 2nd value (hence the ArrayList).
    // 2. It must be Integer and NOT int because for ArrayLists or most other data types, you must use
    //    a wrapper class or an object (or a class) - NO primitive types (e.g. int, double, char).

    // Also note the int[] for an array of integers!  We need the [] since it's an array!
    public ArrayList<Integer> biggerThanSecondValue(int[] intArray) {
        // Edge case: array is less than 2 elements in length
        if (intArray.length < 2) {
            System.out.println("No values bigger than 2nd since the array is too short");
            return new ArrayList<Integer>(); // A new, empty ArrayList with no elements inside
        } else { // The length of the array is 2 or more
            int secondValue = intArray[1];
            ArrayList<Integer> biggerThanSecondArrayList = new ArrayList<Integer>();
            for (int i = 0; i < intArray.length; i++) {
                if (intArray[i] > secondValue) { // OR intArray[i] > intArray[1]
                    biggerThanSecondArrayList.add(intArray[i]); // Adds this value to the ArrayList
                }
            }
            System.out.println("There are " + biggerThanSecondArrayList.size() + " values bigger than the 2nd value.");
            return biggerThanSecondArrayList;
        }
    }

    /* From HackerRank: Java Loops
    https://www.hackerrank.com/challenges/java-loops/problem?isFullScreen=true
    Given the integers a, b and n, print a sequence of values like so:
    a + 2^0*b                              <- i = 0
    a + 2^0*b + 2^1*b                      <- i = 1
    a + 2^0*b + 2^1*b + 2^2*b              <- i = 2
    a + 2^0*b + 2^1*b + 2^2*b + 2^3*b      <- i = 3
    ...
    a + 2^0*b + 2^1*b + 2^2*b + ... + 2^(n-1)*b

    1 <= n <= 15, and a and b are non-negative
    */

    public void javaLoops(int a, int b, int n) {
        int thisSum = 0;
        for (int i = 0; i < n; i++) {
            thisSum = a;
            for (int j = 0; j <= i; j++) {
                thisSum += Math.pow(2,j)*b; // (2^j)*b
            }
            System.out.println(thisSum);
        }
    }

    // More efficient version
    public void javaLoopsV2(int a, int b, int n) {
        int currentSum = a; // All sums have a 
        for (int i = 0; i < n; i++) {
            currentSum += Math.pow(2,i)*b; // Add new term: (2^i)+b
            System.out.println(currentSum);
        }
    }

}