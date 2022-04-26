package InterviewProblems.PrefixSum.SumOfAllOddLengthSubarrays;

public class SumOfAllOddLengthSubarrays {

    // Source: https://www.youtube.com/watch?v=bG83blsPlRM&t=1s

    // Let n = the length of the array arr.
    //
    // Time: O(n)
    // --> O(n) for populating the prefix sum array
    // --> O(n) for finding the sum of all subarrays of odd length (we can think of computing the
    // sum of all subarrays of odd length as a sliding window problem)
    // Space: O(n)
    // --> O(n) for creating the prefix sum array

    public static void main(String[] args) {
        SumOfAllOddLengthSubarrays sumOfAllOddLengthSubarrays = new SumOfAllOddLengthSubarrays();

        // Input: arr = [1]
        // Output: 1
        int[] arr0 = {1};
        int sum0 = sumOfAllOddLengthSubarrays.sumOddLengthSubarrays(arr0);
        System.out.println(sum0);  // 1

        // Input: arr = [1, 2]
        // Output: 3
        // Explanation: There are only 2 subarrays of odd length, [1] and [2].
        // Their sum is 3.
        int[] arr1 = {1, 2};
        int sum1 = sumOfAllOddLengthSubarrays.sumOddLengthSubarrays(arr1);
        System.out.println(sum1);  // 3

        // Input: arr = [1, 4, 2, 5, 3]
        // Output: 58
        // Explanation: The odd-length subarrays of arr and their sums are:
        // [1] = 1
        // [4] = 4
        // [2] = 2
        // [5] = 5
        // [3] = 3
        // [1, 4, 2] = 7
        // [4, 2, 5] = 11
        // [2, 5, 3] = 10
        // [1, 4, 2, 5, 3] = 15
        // If we add all these together we get 1 + 4 + 2 + 5 + 3 + 7 + 11 + 10 + 15 = 58
        int[] arr2 = {1, 4, 2, 5, 3};
        int sum2 = sumOfAllOddLengthSubarrays.sumOddLengthSubarrays(arr2);
        System.out.println(sum2);  // 58

        // Input: arr = [10, 11, 12]
        // [10] = 10
        // [11] = 11
        // [12] = 12
        // [10, 11, 12] = 33
        // If we add all these together we get 10 + 11 + 12 + 33 = 66
        // Output: 66
        int[] arr3 = {10, 11, 12};
        int sum3 = sumOfAllOddLengthSubarrays.sumOddLengthSubarrays(arr3);
        System.out.println(sum3);  // 66
    }

    /**
     * Given an array of positive integers arr, calculate the sum of all possible odd-length
     * subarrays.
     *
     * A subarray is a contiguous subsequence of the array.
     *
     * Return the sum of all odd-length subarrays of arr.
     *
     * Preconditions:
     * - 1 <= arr.length <= 100
     * - 1 <= arr[i] <= 1000
     */
    public int sumOddLengthSubarrays(int[] arr) {
        // construct the prefix sum array
        for (int i = 1; i < arr.length; i++) {
            arr[i] += arr[i - 1];
        }

        // calculate the sum of all odd-length subarrays
        int sum = 0;
        for (int start = 0; start < arr.length; start++) {
            for (int end = start; end < arr.length; end += 2) {
                sum += sumBetween(arr, start, end);
            }
        }
        return sum;
    }

    private int sumBetween(int[] arr, int start, int end) {
        return arr[end] - ((start - 1 >= 0) ? arr[start - 1] : 0);
    }
}
