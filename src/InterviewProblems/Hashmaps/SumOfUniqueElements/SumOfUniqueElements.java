package InterviewProblems.Hashmaps.SumOfUniqueElements;

import java.util.HashMap;
import java.util.Map;

public class SumOfUniqueElements {

    // Let n = the length of the nums array.
    //
    // Time: O(n)
    // --> We must traverse the array once to identify unique elements.
    // Space: O(n)
    // --> We store a hashmap of the frequencies of at most n unique numbers.

    public static void main(String[] args) {
        SumOfUniqueElements sumOfUniqueElements = new SumOfUniqueElements();

        // small array
        // Input: nums = [1]
        // Output: 1
        int[] nums0 = {1};
        int sumOfUnique0 = sumOfUniqueElements.sumOfUnique(nums0);
        System.out.println(sumOfUnique0);  // 1

        // all duplicate elements
        // Input: nums = [1, 1, 1, 1, 1]
        // Output: 0
        // Explanation: There are no unique elements, and the sum is 0.
        int[] nums1 = {1, 1, 1, 1, 1};
        int sumOfUnique1 = sumOfUniqueElements.sumOfUnique(nums1);
        System.out.println(sumOfUnique1);  // 0

        // some duplicate elements
        // Input: nums = [1, 2, 3, 2]
        // Output: 4
        // Explanation: The unique elements are [1, 3], and the sum is 4.
        int[] nums2 = {1, 2, 3, 2};
        int sumOfUnique2 = sumOfUniqueElements.sumOfUnique(nums2);
        System.out.println(sumOfUnique2);  // 4

        // no duplicate elements
        // Input: nums = [1, 2, 3, 4, 5]
        // Output: 15
        // Explanation: The unique elements are [1, 2, 3, 4, 5], and the sum is 15.
        int[] nums3 = {1, 2, 3, 4, 5};
        int sumOfUnique3 = sumOfUniqueElements.sumOfUnique(nums3);
        System.out.println(sumOfUnique3);  // 15
    }

    /**
     * You are given an integer array nums. The unique elements of an array
     * are the elements that appear exactly once in the array.
     *
     * Return the sum of all the unique elements of nums.
     *
     * Preconditions:
     * - 1 <= nums.length <= 100.
     * - 1 <= nums[i] <= 100.
     */
    public int sumOfUnique(int[] nums) {
        Map<Integer, Integer> uniqueNumbersToFrequencies = getUniqueNumbers(nums);
        return sum(uniqueNumbersToFrequencies);
    }

    private Map<Integer, Integer> getUniqueNumbers(int[] numbers) {
        Map<Integer, Integer> uniqueNumbersToFrequencies = new HashMap<>();
        for (int number : numbers) {
            if (!uniqueNumbersToFrequencies.containsKey(number)) {
                uniqueNumbersToFrequencies.put(number, 1);
            } else {  // uniqueNumbers.containsKey(number)
                uniqueNumbersToFrequencies.put(number, uniqueNumbersToFrequencies.get(number) + 1);
            }
        }
        return uniqueNumbersToFrequencies;
    }

    private int sum(Map<Integer, Integer> uniqueNumbersToFrequencies) {
        int sum = 0;
        for (Map.Entry<Integer, Integer> number : uniqueNumbersToFrequencies.entrySet()) {
            if (number.getValue() == 1) {  // frequency of number is 1
                sum += number.getKey();
            }
        }
        return sum;
    }
}
