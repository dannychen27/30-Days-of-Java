package InterviewProblems.HashMapProblems.IceCreamParlor;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class IceCreamParlorHashmap {

    public static void main(String[] args) {
        // hashmap: look for complement in hashmap
        // time O(n)
        // space O(n)
        int[] menuPrices = {2, 7, 13, 5, 4, 13, 5};
        System.out.println(Arrays.toString(findChoices(menuPrices, 10))); // [3, 6]
    }

    private static int[] findChoices(int[] menuPrices, int budget) {
        int[] choices = {-1, -1};
        HashMap<Integer, Integer> indicesToPricesSeen = new HashMap<>();
        for (int i = 0; i < menuPrices.length; i++) {
            int complement = budget - menuPrices[i];
            if (!indicesToPricesSeen.containsValue(complement)) {
                indicesToPricesSeen.put(i, complement);
            } else {  // indicesToPricesSeen.containsValue(complement)
                choices[0] = getKey(indicesToPricesSeen, complement);
                choices[1] = i;
            }
        }
        return choices;
    }

    private static int getKey(Map<Integer, Integer> hashmap, Integer value) {
        // source: https://www.techiedelight.com/get-map-key-from-value-java/
        for (Map.Entry<Integer, Integer> entry : hashmap.entrySet()) {
            if (value.equals(entry.getValue())) {
                return entry.getKey();
            }
        }
        return -1;
    }
}
