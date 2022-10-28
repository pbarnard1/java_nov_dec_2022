public class ThursdayWeek1Test {
    public static void main(String[] args) {
        ThursdayWeek1 test1 = new ThursdayWeek1();
        int[] intTest1 = {3, 5, 2, 7};
        System.out.println(test1.biggerThanSecondValue(intTest1));
        int[] intTest2 = {3};
        System.out.println(test1.biggerThanSecondValue(intTest2));
        test1.javaLoops(5,3,5);
        System.out.println("-------------");
        test1.javaLoops(0, 2, 10);
        System.out.println("-------------");
        test1.javaLoopsV2(0, 2, 10);
        System.out.println("-------------");
        test1.javaLoopsV2(5,3,5);
    }
}