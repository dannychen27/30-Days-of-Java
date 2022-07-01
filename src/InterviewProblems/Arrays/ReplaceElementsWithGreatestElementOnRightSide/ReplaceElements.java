package InterviewProblems.Arrays.ReplaceElementsWithGreatestElementOnRightSide;

import java.util.Arrays;

public class ReplaceElements {

    // Let n = the length of the arr array.
    //
    // Time: O(n)
    // --> We must traverse the array backwards once to determine the greatest element
    // among the elements on the right side of each element.
    // Space: O(n)
    // --> We create a new array greatestElementsArray of size n.

    public static void main(String[] args) {
        ReplaceElements replaceElements = new ReplaceElements();

        // Input: arr = [400]
        // Output: [-1]
        // Explanation: There are no elements to the right of index 0.
        int[] arr1 = {400};
        int[] greatestElementsArray1 = replaceElements.replaceElements(arr1);
        System.out.println(Arrays.toString(greatestElementsArray1));  // [-1]

        // Input: arr = [17, 18, 5, 4, 6, 1]
        // Output: [18, 6, 6, 6, 1, -1]
        // Explanation:
        // - index 0 --> the greatest element to the right of index 0 is index 1 (18).
        // - index 1 --> the greatest element to the right of index 1 is index 4 (6).
        // - index 2 --> the greatest element to the right of index 2 is index 4 (6).
        // - index 3 --> the greatest element to the right of index 3 is index 4 (6).
        // - index 4 --> the greatest element to the right of index 4 is index 5 (1).
        // - index 5 --> there are no elements to the right of index 5, so we put -1.
        int[] arr2 = {17, 18, 5, 4, 6, 1};
        int[] greatestElementsArray2 = replaceElements.replaceElements(arr2);
        System.out.println(Arrays.toString(greatestElementsArray2));  // [18, 6, 6, 6, 1, -1]
    }

    /**
     * Given an array arr, replace every element in that array with the greatest element among
     * the elements to its right, and replace the last element with -1.
     *
     * After doing so, return the array.
     *
     * Preconditions:
     * - 1 <= arr.length <= 10 ^ 4.
     * - 1 <= arr[i] <= 10 ^ 5.
     */
    public int[] replaceElements(int[] arr) {
        int[] greatestElementsArray = new int[arr.length];
        greatestElementsArray[arr.length - 1] = -1;

        int greatestElement = -1;
        for (int i = arr.length - 2; i >= 0; i--) {
            greatestElement = Math.max(greatestElement, arr[i + 1]);
            greatestElementsArray[i] = greatestElement;
        }
        return greatestElementsArray;
    }
}
