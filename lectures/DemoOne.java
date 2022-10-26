public class DemoOne { // Name of class must match name of file EXACTLY
    public static void main(String[] args) {
        System.out.println("Hello world!"); // Most lines of code MUST end in a semicolon
        int x = 3;
        // Basic calculations
        System.out.println(5 * x);
        System.out.println(5.0 * x);
        System.out.println(x * 5.0);
        // Wrapper class demo
        Integer y = 3;
        Integer z = Integer.valueOf(y);
        System.out.println(z);
    }
}