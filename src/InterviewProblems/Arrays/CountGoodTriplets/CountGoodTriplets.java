package InterviewProblems.Arrays.CountGoodTriplets;

public class CountGoodTriplets {

    // Let n = the length of the array.
    //
    // Time: O(n ^ 3)
    // --> We must enumerate all (n choose 3) = n * (n - 1) * (n - 2) / 6 triplets
    // of numbers to find the number of good triplets.
    // Space: O(1)
    // --> We don't store any additional data structures.

    public static void main(String[] args) {
        CountGoodTriplets countGoodTriplets = new CountGoodTriplets();

        // Input: arr = [1, 2, 3], a = 1, b = 2, c = 3
        // Output: 1
        // Explanation: Only triplet [1, 2, 3] is good.
        int[] arr1 = {1, 2, 3};
        int numGoodTriplets1 = countGoodTriplets.countGoodTriplets(arr1, 1, 2, 3);
        System.out.println(numGoodTriplets1);  // 1

        // Input: arr = [1, 1, 2, 2, 3], a = 0, b = 0, c = 1
        // Output: 0
        // Explanation: No triplet satisfies all conditions.
        int[] arr2 = {1, 1, 2, 2, 3};
        int numGoodTriplets2 = countGoodTriplets.countGoodTriplets(arr2, 0, 0, 1);
        System.out.println(numGoodTriplets2);  // 0

        // Input: arr = [3, 0, 1, 1, 9, 7], a = 7, b = 2, c = 3
        // Output: 4
        // Explanation: There are 4 good triplets: [(3, 0, 1), (3, 0, 1), (3, 1, 1), (0, 1, 1)].
        int[] arr3 = {3, 0, 1, 1, 9, 7};
        int numGoodTriplets3 = countGoodTriplets.countGoodTriplets(arr3, 7, 2, 3);
        System.out.println(numGoodTriplets3);  // 4
    }

    /**
     * Given an array of integers arr, and three integers a, b and c.
     * You need to find the number of good triplets.
     *
     * A triplet (arr[i], arr[j], arr[k]) is good if the following conditions are true:
     * - 0 <= i < j < k < arr.length
     * - |arr[i] - arr[j]| <= a
     * - |arr[j] - arr[k]| <= b
     * - |arr[i] - arr[k]| <= c
     * Where |x| denotes the absolute value of x.
     *
     * Return the number of good triplets.
     *
     * Preconditions:
     * - 3 <= arr.length <= 100.
     * - 0 <= arr[i] <= 1000.
     * - 0 <= a, b, c <= 1000.
     */
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    if (isGoodTriplet(arr, a, b, c, i, j, k)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    private boolean isGoodTriplet(int[] arr,
                                  int a, int b, int c,
                                  int i, int j, int k) {
        return  Math.abs(arr[i] - arr[j]) <= a &&
                Math.abs(arr[j] - arr[k]) <= b &&
                Math.abs(arr[i] - arr[k]) <= c;
    }
}
