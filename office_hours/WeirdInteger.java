public class WeirdInteger {

    /* Weird integers (from HackerRank):
    https://www.hackerrank.com/challenges/java-if-else/problem?isFullScreen=true
    Given an integer n from 1 to 100, inclusively, print:
    "Weird" if n is odd
    "Not Weird" if n is even AND from 2 to 5, inclusively
    "Weird" if n is even AND from 6 to 20, inclusively
    "Not Weird" if n is even and greater than 20
    */

    // Write the actual method here
    public void checkInteger(int n) { // Note that we need "int" for the parameter to specify that this is an integer
        /*
        % is the modulo symbol - basically 5 % 2 gives the remainder, which is 1
        n % 2 with a result of 1 means n is odd
        n % 2 with a result of 0 means n is even
        */
        if (n % 2 == 1) { // If the value is odd
            System.out.println("Weird");
        } else if (n >= 2 && n <= 5) {
            System.out.println("Not weird");
        } else if (n >= 6 && n <= 20) {
            System.out.println("Weird");
        } else { // n > 20
            System.out.println("Not weird");
        }
    }

    public void checkIntegerV2(int n) { // Note that we need "int" for the parameter to specify that this is an integer
        // Simplified code
        if (n % 2 == 1 || (n >= 6 && n <= 20)) { // If the value is odd OR even from 6 through 20
            System.out.println("Weird");
        } else { // n > 20 OR 2 <= n <= 5
            System.out.println("Not weird");
        }
    }
}