package InterviewProblems.Arrays.FindMissingNumber.BitManipulation;

public class FindMissingNumber {

    // Time: O(1)
    // --> O(1) to xor all elements in the array
    // --> O(1) to compute missing number ^ 100
    // Space: O(1)
    // --> No extra data structures required

    public static void main(String[] args) {
        FindMissingNumber findMissingNumber = new FindMissingNumber();

        // Input: nums = [100, 99, _, 97, 96, 95 ...]
        // Output: 98
        int[] nums1 = {
            100, 99, /* 98, */ 97, 96, 95, 94, 93, 92, 91, 90,
            89, 88, 87, 86, 85, 84, 83, 82, 81, 80,
            79, 78, 77, 76, 75, 74, 73, 72, 71, 70,
            69, 68, 67, 66, 65, 64, 63, 62, 61, 60,
            59, 58, 57, 56, 55, 54, 53, 52, 51, 50,
            49, 48, 47, 46, 45, 44, 43, 42, 41, 40,
            39, 38, 37, 36, 35, 34, 33, 32, 31, 30,
            29, 28, 27, 26, 25, 24, 23, 22, 21, 20,
            19, 18, 17, 16, 15, 14, 13, 12, 11, 10,
            9, 8, 7, 6, 5, 4, 3, 2, 1
        };
        int missingNumber1 = findMissingNumber.findMissingNumber(nums1);
        System.out.println(missingNumber1);  // 98

        // Input: nums = [1, 2, _, 4, 5, 6, ...]
        // Output: 3
        int[] nums2 = {
            1, 2, /* 3, */ 4, 5, 6, 7, 8, 9, 10, 11,
            12, 13, 14, 15, 16, 17, 18, 19, 20, 21,
            22, 23, 24, 25, 26, 27, 28, 29, 30, 31,
            32, 33, 34, 35, 36, 37, 38, 39, 40, 41,
            42, 43, 44, 45, 46, 47, 48, 49, 50, 51,
            52, 53, 54, 55, 56, 57, 58, 59, 60, 61,
            62, 63, 64, 65, 66, 67, 68, 69, 70, 71,
            72, 73, 74, 75, 76, 77, 78, 79, 80, 81,
            82, 83, 84, 85, 86, 87, 88, 89, 90, 91,
            92, 93, 94, 95, 96, 97, 98, 99, 100
        };
        int missingNumber2 = findMissingNumber.findMissingNumber(nums2);
        System.out.println(missingNumber2);  // 3

        // Input: nums =
        // [1, 100,  2, 99,  3, 98,  4, 97,  5, 96,
        //  6,  95,  7, 94,  8, 93,  9, 92, 10, 91,
        //  11, 90, 12, 89, 13, 88, 14, 87, 15, 86,
        //  16, 85, 17, 84, 18, 83, 19, 82, 20, 81,
        //  21, 80, 22, 79, 23, 78, 24, 77, 25, 76,
        //  26, 75, 27, 74, 28, 73, 29, 72, 30, 71,
        //  31, 70, 32, 69, 33, 68, 34, 67, 35, 66,
        //  36, 65, 37, 64, 38, 63, 39, 62, 40, 61,
        //  41, 60, 42, 59, 43, 58, 44, 57, 45, 56,
        //  46, 55, 47, 54, 48, 53, 49, 52, _, 50]
        // Output: 51
        int[] nums3 = {
            1, 100,  2, 99,  3, 98,  4, 97,  5, 96,
            6,  95,  7, 94,  8, 93,  9, 92, 10, 91,
            11, 90, 12, 89, 13, 88, 14, 87, 15, 86,
            16, 85, 17, 84, 18, 83, 19, 82, 20, 81,
            21, 80, 22, 79, 23, 78, 24, 77, 25, 76,
            26, 75, 27, 74, 28, 73, 29, 72, 30, 71,
            31, 70, 32, 69, 33, 68, 34, 67, 35, 66,
            36, 65, 37, 64, 38, 63, 39, 62, 40, 61,
            41, 60, 42, 59, 43, 58, 44, 57, 45, 56,
            46, 55, 47, 54, 48, 53, 49, 52, /* 51, */ 50
        };
        int missingNumber3 = findMissingNumber.findMissingNumber(nums3);
        System.out.println(missingNumber3);  // 51
    }

    /**
     * Find the missing number in an array from 1 to 100.
     *
     * Preconditions:
     * - array.length == 99.
     * - array contains no duplicate elements.
     * - array contains only one missing number.
     * - array need not be sorted.
     */
    public int findMissingNumber(int[] nums) {
        int missingNumber = 0;
        for (int num : nums) {
            missingNumber ^= num;
        }
        return missingNumber ^ 100;
    }
}
