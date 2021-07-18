package InterviewProblems.HashMapProblems.LonelyInteger;

import java.util.HashMap;

public class LonelyInteger {

    public int findLonelyInteger(int[] array) {
        HashMap<Integer, Integer> integersToNumOccurrences = new HashMap<>();
        for (int value : array) {
            if (!integersToNumOccurrences.containsKey(value)) {
                integersToNumOccurrences.put(value, 1);
            } else {
                integersToNumOccurrences.put(value, integersToNumOccurrences.get(value) + 1);
            }
        }

        // find the element with only 1 occurrence
        for (int value : array) {
            if (integersToNumOccurrences.get(value) == 1) {
                return value;
            }
        }
        return Integer.MIN_VALUE;  // You should never be able to reach here.
    }
}
