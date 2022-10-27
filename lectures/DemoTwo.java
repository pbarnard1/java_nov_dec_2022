public class DemoTwo {

    public static void main(String[] args) {
        // If statement demo
        int myGrade = 95;
        if (myGrade >= 90) {
            System.out.println("Awesome job!");
        } else if (myGrade >= 80) {
            System.out.println("Good work!");
        }
        System.out.println("Done with if block");

        // For loop demos
        for (int i = 5; i <= 15; i++) {
            System.out.println(i);
        }

        // Loop printing even values from 0 through 50
        for (int num = 0; num <= 50; num += 2) {
            System.out.println(num);
        }

        // Countdown
        for (int val = 10; val > 0; val--) {
            System.out.println(val);
        }
        System.out.println("Blastoff!");

        // String demo
        String food = "hamburger";
        int myNumber = 20;
        System.out.println("My favorite food is "+ food + ", and my number is "+myNumber);
        // System.out.println("My favorite food is", food + ", and my number is",myNumber);
        String food2 = new String("hamburger");

        // INOCRRECT WAY TO COMPARE STRINGS - DO NOT USE THE "==" OPERATOR!
        // Explanation here: https://stackoverflow.com/questions/9698260/what-makes-reference-comparison-work-for-some-strings-in-java
        // By doing String item = ""; you're making a String literal, NOT a String object.  You can still use many of the same methods, however.
        // System.out.println(food == "hamburger");
        // System.out.println(food2 == "hamburger");

        // Correct way to compare strings: .equals() or .equalsIgnoreCase()
        System.out.println(food.equalsIgnoreCase("HamBURGer"));

        // Using our House class
        House myHouse = new House();
        myHouse.repaint("blue");
        System.out.println(myHouse.calculateArea(10,15));
        System.out.println(myHouse.calculateArea(22.0,33.5));
        
    }
}