package InterviewProblems.HashMapProblems.LonelyInteger;

import java.util.HashMap;

class LonelyInteger {

    public static void main(String[] args) {
        int[] nums = {9, 1, 2, 3, 2, 9, 1, 7, 7};
        System.out.println(findLonelyIntegerHashmap(nums)); // 3

        int[] nums2 = {1, 1, 2, 2, 3, 3, 9};
        System.out.println(findLonelyIntegerHashmap(nums2)); // 9
    }

    private static int findLonelyIntegerHashmap(int[] array) {
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
        return Integer.MIN_VALUE;
    }
}
