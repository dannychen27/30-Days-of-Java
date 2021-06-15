package InterviewProblems.HashMapProblems.FindPairWithSum;

public class FindPairWithSumNaive {

    public static void main(String[] args) {
        // source: https://www.youtube.com/watch?v=XKu_SEDAykw

        int[] emptyArray = {};
        int[] shortArray = {1};
        int[] nums = {1, 2, 3, 9};
        int[] nums2 = {1, 2, 4, 4};
        int[] unsortedArray = {4, 1, 2, 4};

        // time: O(n^2) because there are (n choose 2) = n(n - 1) / 2 pairs
        // space: O(1)
        System.out.println(findPairWithSum(emptyArray, 8));  // false
        System.out.println(findPairWithSum(shortArray, 8));  // false
        System.out.println(findPairWithSum(nums, 8));  // false
        System.out.println(findPairWithSum(nums2, 8));  // true
        System.out.println(findPairWithSum(unsortedArray, 8));  // true

        // TODO: What if we combined the hashmap approach, but assume the array is sorted?
    }

    /**
     * Return true iff there exist two integers whose sum is targetSum.
     */
    private static boolean findPairWithSum(int[] array, int targetSum) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                int sum = array[i] + array[j];
                if (sum == targetSum) {
                    return true;
                }
            }
        }
        return false;
    }
}
