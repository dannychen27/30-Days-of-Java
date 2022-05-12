package InterviewProblems.Hashmaps.IntersectionOfTwoArrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoArrays {

    // Let m = the length of the nums1 array
    // Let n = the length of the nums2 array
    //
    // Time: O(m + n)
    // --> O(m) to create the hashset for nums1
    // --> O(n) to create the hashset for nums2
    // --> O(m + n) to find the intersection set
    // --> O(min(m, n)) to convert the intersection set to an array
    // Space: O(m + n)
    // --> O(m) to create the hashset for nums1
    // --> O(n) to create the hashset for nums2
    // --> O(m + n) to find the intersection set
    // --> O(min(m, n)) to convert the intersection set to an array

    public static void main(String[] args) {
        IntersectionOfTwoArrays intersectionOfTwoArrays = new IntersectionOfTwoArrays();

        // Input: nums1 = [1, 2, 2, 1], nums2 = [2, 2]
        // Output: [2]
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        int[] intersection1 = intersectionOfTwoArrays.intersection(nums1, nums2);
        System.out.println(Arrays.toString(intersection1));  // [2]

        // Input: nums1 = [4, 9, 5], nums2 = [9, 4, 9, 8, 4]
        // Output: [9, 4]
        // Explanation: [4, 9] is also accepted.
        int[] nums3 = {4, 9, 5};
        int[] nums4 = {9, 4, 9, 8, 4};
        int[] intersection2 = intersectionOfTwoArrays.intersection(nums3, nums4);
        System.out.println(Arrays.toString(intersection2));  // [9, 4] or [4, 9]

        // Input: nums1 = [1, 2, 3], nums2 = [3, 2, 1]
        // Output: [1, 2, 3]
        int[] nums5 = {1, 2, 3};
        int[] nums6 = {3, 2, 1};
        int[] intersection3 = intersectionOfTwoArrays.intersection(nums5, nums6);
        System.out.println(Arrays.toString(intersection3));  // [1, 2, 3] or any other permutation of [1, 2, 3]

        // Input: nums1 = [1, 2, 3], nums2 = [4, 5, 6]
        // Output: []
        int[] nums7 = {1, 2, 3};
        int[] nums8 = {4, 5, 6};
        int[] intersection4 = intersectionOfTwoArrays.intersection(nums7, nums8);
        System.out.println(Arrays.toString(intersection4));  // []
    }

    /**
     * Given two integer arrays nums1 and nums2, return an array of their intersection.
     * Each element in the result must be unique and you may return the result in any order.
     *
     * Preconditions:
     * - 1 <= nums1.length, nums2.length <= 1000.
     * - 0 <= nums1[i], nums2[i] <= 1000.
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = convertToSet(nums1);
        Set<Integer> set2 = convertToSet(nums2);

        // Find the intersection of the two sets, set1 and set2.
        Set<Integer> intersectionSet = new HashSet<>(set1);
        intersectionSet.retainAll(set2);

        return convertHashsetToArray(intersectionSet);
    }

    private Set<Integer> convertToSet(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        return set;
    }

    private int[] convertHashsetToArray(Set<Integer> intersection) {
        int[] intersectionArray = new int[intersection.size()];
        int i = 0;
        for (int num : intersection) {
            intersectionArray[i] = num;
            i++;
        }
        return intersectionArray;
    }
}
