package InterviewProblems.Hashmaps.UniqueNumberOfOccurrences;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueNumberOfOccurrences {

    // Let n = the length of the nums array.
    //
    // Time: O(n)
    // --> O(n) to determine the frequencies of all the elements in the nums array.
    // --> O(n) to check if all numbers have a unique number of occurrences.
    // Space: O(n)
    // --> O(n) to must maintain a hashmap of numbers to their frequencies.
    // --> O(1) to track the unique number of occurrences that we hope no other
    // number duplicates.

    public static void main(String[] args) {
        UniqueNumberOfOccurrences uniqueNumberOfOccurrences = new UniqueNumberOfOccurrences();

        // Input: arr = [1]
        // Output: true
        int[] arr0 = {1};
        boolean uniqueOccurrences0 = uniqueNumberOfOccurrences.uniqueOccurrences(arr0);
        System.out.println(uniqueOccurrences0);  // true

        // Input: arr = [1, 2, 2, 1, 1, 3]
        // Output: true
        // Explanation: The value 1 has 3 occurrences, 2 has 2 and 3 has 1.
        // No two values have the same number of occurrences.
        int[] arr1 = {1, 2, 2, 1, 1, 3};
        boolean uniqueOccurrences1 = uniqueNumberOfOccurrences.uniqueOccurrences(arr1);
        System.out.println(uniqueOccurrences1);  // true

        // Input: arr = [1, 2]
        // Output: false
        int[] arr2 = {1, 2};
        boolean uniqueOccurrences2 = uniqueNumberOfOccurrences.uniqueOccurrences(arr2);
        System.out.println(uniqueOccurrences2);  // false

        // Input: arr = [-3, 0, 1, -3, 1, 1, 1, -3, 10, 0]
        // Output: true
        int[] arr3 = {-3, 0, 1, -3, 1, 1, 1, -3, 10, 0};
        boolean uniqueOccurrences3 = uniqueNumberOfOccurrences.uniqueOccurrences(arr3);
        System.out.println(uniqueOccurrences3);  // true

        // Input: arr = [0, 0, -2, -1, 4, 8, -3, 9, 6]
        // Output: false
        int[] arr4 = {0, 0, -2, -1, 4, 8, -3, 9, 6};
        boolean uniqueOccurrences4 = uniqueNumberOfOccurrences.uniqueOccurrences(arr4);
        System.out.println(uniqueOccurrences4);  // false
    }

    /**
     * Given an array of integers arr, return true iff the number of occurrences of
     * each value in the array is unique.
     *
     * Preconditions:
     * - 1 <= arr.length <= 1000.
     * - -1000 <= arr[i] <= 1000.
     */
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> numberFrequencies = getNumberFrequencies(arr);
        return whetherAllNumbersHaveUniqueNumberOfOccurrences(numberFrequencies);
    }

    private Map<Integer, Integer> getNumberFrequencies(int[] array) {
        Map<Integer, Integer> numberFrequencies = new HashMap<>();
        for (int number : array) {
            if (!numberFrequencies.containsKey(number)) {
                numberFrequencies.put(number, 1);
            } else {
                numberFrequencies.put(number, numberFrequencies.get(number) + 1);
            }
        }
        return numberFrequencies;
    }

    private boolean whetherAllNumbersHaveUniqueNumberOfOccurrences(Map<Integer, Integer> numberFrequencies) {
        Set<Integer> numberOfOccurrences = new HashSet<>();
        for (int frequency : numberFrequencies.values()) {
            if (!numberOfOccurrences.contains(frequency)) {
                numberOfOccurrences.add(frequency);
            } else {  // numberOfOccurrences.contains(frequency)
                return false;
            }
        }
        return true;
    }
}
