package InterviewProblems.Hashmaps.IceCreamParlor;

import java.util.HashMap;
import java.util.Map;

public class IceCreamParlorHashmap {

    // hashmap strategy: look for complement in hashmap
    // time O(n)
    // space O(n)

    public int[] findChoices(int[] menuPrices, int budget) {
        int[] choices = {-1, -1};
        Map<Integer, Integer> indicesToPricesSeen = new HashMap<>();
        for (int i = 0; i < menuPrices.length; i++) {
            int complement = budget - menuPrices[i];
            if (!indicesToPricesSeen.containsValue(complement)) {
                indicesToPricesSeen.put(i, complement);
            } else if (complement > 0) {  // indicesToPricesSeen.containsValue(complement)
                choices[0] = getKey(indicesToPricesSeen, complement);
                choices[1] = i;
            }
        }
        return choices;
    }

    private int getKey(Map<Integer, Integer> hashmap, Integer value) {
        // source: https://www.techiedelight.com/get-map-key-from-value-java/
        for (Map.Entry<Integer, Integer> entry : hashmap.entrySet()) {
            if (value.equals(entry.getValue())) {
                return entry.getKey();
            }
        }
        return -1;
    }
}
