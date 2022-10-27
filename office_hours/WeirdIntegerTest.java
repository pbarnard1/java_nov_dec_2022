public class WeirdIntegerTest {
    // Test cases
    public static void main(String[] args) {
        WeirdInteger myWeirdInteger = new WeirdInteger();
        for (int i = 1; i <= 40; i++) {
            System.out.println("Current value is "+i);
            myWeirdInteger.checkInteger(i);
            myWeirdInteger.checkIntegerV2(i);
        }
    }

}