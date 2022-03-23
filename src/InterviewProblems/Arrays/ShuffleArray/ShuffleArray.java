package InterviewProblems.Arrays.ShuffleArray;

import java.util.Arrays;

public class ShuffleArray {

    // Let n = the length of the original nums array.
    //
    // Time: O(n)
    // --> We iterate through the nums array once.
    // Space: O(n)
    // --> We create a new shuffled array that's twice the size of the original
    // nums array.

    public static void main(String[] args) {
        ShuffleArray shuffleArray = new ShuffleArray();

        // Input: nums = [1, 2], n = 1
        // Output: [1, 2]
        int[] nums1 = {1, 2};
        int n1 = 1;
        int[] result1 = shuffleArray.shuffle(nums1, n1);
        System.out.println(Arrays.toString(result1));  // [1, 2]

        // Input: nums = [2, 5, 1, 3, 4, 7], n = 3
        // Output: [2, 3, 5, 4, 1, 7]
        // Explanation: Since x1 = 2, x2 = 5, x3 = 1, y1 = 3, y2 = 4, y3 = 7
        // then the answer is [2, 3, 5, 4, 1, 7].
        int[] nums2 = {2, 5, 1, 3, 4, 7};
        int n2 = 3;
        int[] result2 = shuffleArray.shuffle(nums2, n2);
        System.out.println(Arrays.toString(result2));  // [2, 3, 5, 4, 1, 7]

        // Input: nums = [1, 2, 3, 4, 4, 3, 2, 1], n = 4
        // Output: [1, 4, 2, 3, 3, 2, 4, 1]
        // Explanation: Since x1 = 1, x2 = 2, x3 = 3, x4 = 4, y1 = 4, y2 = 3, y3 = 2, y4 = 1
        // then the answer is [1, 4, 2, 3, 3, 2, 4, 1].
        int[] nums3 = {1, 2, 3, 4, 4, 3, 2, 1};
        int n3 = 4;
        int[] result3 = shuffleArray.shuffle(nums3, n3);
        System.out.println(Arrays.toString(result3));  // [1, 4, 2, 3, 3, 2, 4, 1]

        // Input: nums = [1, 1, 2, 2], n = 2
        // Output: [1, 2, 1, 2]
        // Explanation: Since x1 = 1, x2 = 1, y1 = 2, y2 = 2
        // then the answer is [1, 2, 1, 2].
        int[] nums4 = {1, 1, 2, 2};
        int n4 = 2;
        int[] result4 = shuffleArray.shuffle(nums4, n4);
        System.out.println(Arrays.toString(result4));  // [1, 2, 1, 2]
    }

    /**
     * Given the array nums consisting of 2n elements in the form
     * [x1, x2, ... , xn, y1, y2, ... ,yn].
     *
     * Return the array in the form [x1, y1, x2, y2, ... ,xn, yn].
     *
     * Preconditions:
     * - n >= 1.
     * - nums.length == 2n.
     */
    public int[] shuffle(int[] nums, int n) {
        int[] shuffledArray = new int[2 * n];
        for (int i = 0; i < n; i++) {
            shuffledArray[2 * i] = nums[i];
            shuffledArray[2 * i + 1] = nums[i + n];
        }
        return shuffledArray;
    }
}
