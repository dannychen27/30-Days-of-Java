package InterviewProblems.Arrays.FindGreatestCommonDivisorOfArray;

public class GCDOfArray {

    // Let n = the length of the nums array.
    //
    // Time: O(n)
    // --> O(n) for finding the minimum and maximum number in the nums array.
    // --> O(log n) for finding the GCD of the minimum and maximum number using Euclid's algorithm.
    // Space: recursive = O(log n), iterative = O(1)
    // --> O(1) for finding the minimum and maximum number in the nums array
    // --> O(log n) for the recursive calls to gcd(a, b).

    public static void main(String[] args) {
        GCDOfArray gcdOfArray = new GCDOfArray();

        // array size = 2, max item == min item
        // Input: nums = [3, 3]
        // Output: 3
        // Explanation:
        // The smallest number in nums is 3.
        // The largest number in nums is 3.
        // The greatest common divisor of 3 and 3 is 3.
        int[] nums1 = {3, 3};
        int gcdOfArray1 = gcdOfArray.findGCD(nums1);
        System.out.println(gcdOfArray1);  // 3

        // smallest number and largest number are not relatively prime.
        // Input: nums = [2, 5, 6, 9, 10]
        // Output: 2
        // Explanation:
        // The smallest number in nums is 2.
        // The largest number in nums is 10.
        // The greatest common divisor of 2 and 10 is 2.
        int[] nums2 = {2, 5, 6, 9, 10};
        int gcdOfArray2 = gcdOfArray.findGCD(nums2);
        System.out.println(gcdOfArray2);  // 2

        // smallest number and largest number are relatively prime.
        // Input: nums = [7, 5, 6, 8, 3]
        // Output: 1
        // Explanation:
        // The smallest number in nums is 3.
        // The largest number in nums is 8.
        // The greatest common divisor of 3 and 8 is 1.
        int[] nums3 = {7, 5, 6, 8, 3};
        int gcdOfArray3 = gcdOfArray.findGCD(nums3);
        System.out.println(gcdOfArray3);  // 1
    }

    /**
     * Given an integer array nums, return the greatest common divisor of
     * the smallest number and largest number in nums.
     *
     * The greatest common divisor of two numbers is the largest positive
     * integer that evenly divides both numbers.
     *
     * Preconditions:
     * - 2 <= nums.length <= 1000.
     * - 1 <= nums[i] <= 1000.
     */
    public int findGCD(int[] nums) {
        int[] maxAndMin = findMaxAndMin(nums);
        return gcdIterative(maxAndMin[0], maxAndMin[1]);
    }

    private int[] findMaxAndMin(int[] nums) {
        int maximumNumber = Integer.MIN_VALUE;
        int minimumNumber = Integer.MAX_VALUE;
        for (int number : nums) {
            maximumNumber = Math.max(maximumNumber, number);
            minimumNumber = Math.min(minimumNumber, number);
        }
        return new int[] {maximumNumber, minimumNumber};
    }

    private int gcdRecursive(int a, int b) {
        // Euclid's algorithm for computing gcd.
        if (b == 0) {
            return a;
        } else {
            return gcdRecursive(b, a % b);
        }
    }

    private int gcdIterative(int a, int b) {
        // Euclid's algorithm for computing gcd.
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
