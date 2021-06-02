package Algorithms.SortingAlgorithms.QuickSort;

import java.util.Arrays;
import java.util.Stack;

public class IterativeQuickSort {

    public static void main(String[] args) {
        // source: https://www.geeksforgeeks.org/iterative-quick-sort/
        int[] numbers = {5, 4, 3, 2, 1};
        iterativeQuickSort(numbers);
        System.out.println(Arrays.toString(numbers)); // [1, 2, 3, 4, 5]
    }

    /**
     * Sort this array.
     */
    private static void iterativeQuickSort(int[] array) {
        Stack<Integer> stack = new Stack<>();

        int startIndex = 0;
        int endIndex = array.length - 1;

        stack.push(startIndex);
        stack.push(endIndex);

        while (!stack.isEmpty()) {
            endIndex = stack.pop();
            startIndex = stack.pop();

            int pivotIndex = partition(array, startIndex, endIndex);

            // if there are elements on the left side of the pivot
            // then push left side to stack.
            if (pivotIndex - 1 > 1) {
                stack.push(startIndex);
                stack.push(pivotIndex - 1);
            }

            // if there are elements on the right side of the pivot
            // then push right side to stack.
            if (pivotIndex + 1 < endIndex) {
                stack.push(pivotIndex + 1);
                stack.push(endIndex);
            }
        }
    }

    /**
     * Return the partition index after performing in place partition on the subarray
     * array[startIndex:endIndex].
     */
    private static int partition(int[] array, int startIndex, int endIndex) {
        int initialPivotIndex = startIndex; // the pivot doesn't matter
        swap(array, initialPivotIndex, endIndex);
        int pivotIndex = startIndex;
        for (int i = startIndex; i < endIndex; i++) {
            if (array[i] <= array[endIndex]) {
                swap(array, i, pivotIndex);
                pivotIndex++;
            }
        }
        swap(array, pivotIndex, endIndex);
        return pivotIndex;
    }

    /**
     * Swap the elements at index1 and index2.
     */
    private static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
