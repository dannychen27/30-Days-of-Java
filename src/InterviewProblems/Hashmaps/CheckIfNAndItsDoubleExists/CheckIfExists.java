package InterviewProblems.Hashmaps.CheckIfNAndItsDoubleExists;

import java.util.HashSet;
import java.util.Set;

public class CheckIfExists {

    // Let n = the length of the array.
    //
    // Time: O(n)
    // --> We must iterate through the array once to determine whether a num and its
    // double exists in the array.
    // Space: O(n)
    // --> We maintain a hashmap to store all the values in the array.

    public static void main(String[] args) {
        CheckIfExists checkIfExists = new CheckIfExists();

        // Input: arr = [10, 2, 5, 3]
        // Output: true
        // Explanation: N = 10 is the double of M = 5, that is, 10 = 2 * 5.
        int[] arr1 = {10, 2, 5, 3};
        boolean checkIfExists1 = checkIfExists.checkIfExist(arr1);
        System.out.println(checkIfExists1);  // true

        // Input: arr = [7, 1, 14, 11]
        // Output: true
        // Explanation: N = 14 is the double of M = 7, that is, 14 = 2 * 7.
        int[] arr2 = {7, 1, 14, 11};
        boolean checkIfExists2 = checkIfExists.checkIfExist(arr2);
        System.out.println(checkIfExists2);  // true

        // Input: arr = [3, 1, 7, 11]
        // Output: false
        // Explanation: In this case does not exist N and M, such that N = 2 * M.
        int[] arr3 = {3, 1, 7, 11};
        boolean checkIfExists3 = checkIfExists.checkIfExist(arr3);
        System.out.println(checkIfExists3);  // false
    }

    /**
     * Given an array arr of integers, check if there exists two integers N and M such
     * that N is the double of M (i.e. N = 2 * M).
     *
     * More formally check if there exists two indices i and j such that:
     * - i != j
     * - 0 <= i, j < arr.length
     * - arr[i] == 2 * arr[j]
     *
     * Preconditions:
     * - 2 <= arr.length <= 500.
     * - -10 ^ 3 <= arr[i] <= 10 ^ 3.
     */
    public boolean checkIfExist(int[] arr) {
        Set<Integer> doublesSeenBefore = new HashSet<>();
        for (int num : arr) {
            if (doublesSeenBefore.contains(2 * num)) {
                return true;
            }

            if (num % 2 == 0 && doublesSeenBefore.contains(num / 2)) {
                return true;
            }

            doublesSeenBefore.add(num);
        }
        return false;
    }
}
