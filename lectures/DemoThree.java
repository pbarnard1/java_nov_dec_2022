import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class DemoThree {
    public static void main(String[] args) {
        // Defining an array of Strings
        String[] names = {"Adrian", "Trae", "Lisa", "Melissa"};
        System.out.println(names[0]);
        System.out.println(names); // Crazy output
        System.out.println(Arrays.toString(names)); // Much better output!
        // ArrayLists with Strings
        ArrayList<String> televisionShows = new ArrayList<String>();
        // Adding values
        televisionShows.add("Rick and Morty");
        televisionShows.add("Psych");
        televisionShows.add("Monk");
        System.out.println(televisionShows);
        System.out.println(televisionShows.get(2)); // Do NOT do televisionShows[2];
        // televisionShows.remove("Monk"); // Remove "Monk" from ArrayList
        // Two ways to loop through an ArrayList
        for (String tvShow : televisionShows) {
            System.out.println(tvShow);
        }
        for (int i = 0; i < televisionShows.size(); i++) {
            System.out.println(televisionShows.get(i));
        }
        // HashMap demo
        HashMap<String, Double> shopPriceMap = new HashMap<String, Double>();
        // Adding key-value pairs (String is the key type, Double is the value type)
        shopPriceMap.put("Laptop", 1000.00);
        shopPriceMap.put("Tablet", 200.00);
        shopPriceMap.put("Fan", 50.00);
        System.out.println(shopPriceMap); // Display key-value pairs
        System.out.println(shopPriceMap.get("Fan")); // Grabbing a key
        System.out.println(shopPriceMap.get("fan")); // Grabbing the value for a key that doesn't exist
        // Grab the keys, then display the key and value, one at a time
        Set<String> shopPriceMapKeys = shopPriceMap.keySet(); // A set of keys (Strings)
        for (String curKey : shopPriceMapKeys) {
            System.out.println(curKey + ": " + shopPriceMap.get(curKey));
        }
    }
}