public class House {

    // Adding methods to our House class
    public void repaint(String newColor) {
        System.out.println("The house's color is now "+ newColor);
    }

    /*
    Demo of overloading: note the different signatures even though the
    method names are the same:
    "public int calculateArea(int length, int width)"
    vs.
    "public double calculateArea(double length, double width)"
    */

    public int calculateArea(int length, int width) {
        return length*width;
    }

    public double calculateArea(double length, double width) {
        return length*width;
    }
}