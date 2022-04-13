package InterviewProblems.Math.MissingNumber;

public class MissingNumber {

    // Let n = the length of the nums array.
    //
    // Time: O(n)
    // --> We must traverse the array once.
    // Space: O(1)
    // --> We store only one value, the sum of the elements in the nums array.

    public static void main(String[] args) {
        MissingNumber missingNumber = new MissingNumber();

        // Input: nums = [3, 0, 1]
        // Output: 2
        // Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0, 3].
        // 2 is the missing number in the range since it does not appear in nums.
        int[] nums1 = {3, 0, 1};
        int missingNumber1 = missingNumber.missingNumber(nums1);
        System.out.println(missingNumber1);  // 2

        // Input: nums = [0, 1]
        // Output: 2
        // Explanation: n = 2 since there are 2 numbers, so all numbers are in the range [0, 2].
        // 2 is the missing number in the range since it does not appear in nums.
        int[] nums2 = {0, 1};
        int missingNumber2 = missingNumber.missingNumber(nums2);
        System.out.println(missingNumber2);  // 2

        // Input: nums = [9, 6, 4, 2, 3, 5, 7, 0, 1]
        // Output: 8
        // Explanation: n = 9 since there are 9 numbers, so all numbers are in the range [0, 9].
        // 8 is the missing number in the range since it does not appear in nums.
        int[] nums3 = {9, 6, 4, 2, 3, 5, 7, 0, 1};
        int missingNumber3 = missingNumber.missingNumber(nums3);
        System.out.println(missingNumber3);  // 8
    }

    /**
     * Given an array nums containing n distinct numbers in the range [0, n],
     * return the only number in the range that is missing from the array.
     */
    public int missingNumber(int[] nums) {
        // The sum of all numbers in the range [0, n] is n * (n + 1) / 2.
        // The missing number = sum of all numbers in the range [0, n] - the sum of all numbers in the nums array.
        return nums.length * (nums.length + 1) / 2 - sum(nums);
    }

    public int sum(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }
}
