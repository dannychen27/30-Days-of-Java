package Algorithms.SortingAlgorithms.RadixSort;

import java.util.Arrays;

import static Algorithms.SortingAlgorithms.CountingSort.CountingSort.countingSort;

public class RadixSort {

    private static final int BASE = 10;

    public static void main(String[] args) {
        // Source: https://www.youtube.com/watch?v=XiuSW_mEn7g Radix Sort

        // let n = length of array
        // let d = max number of digits needed to represent each number.
        // let b = the base you're using, range of keys. e.g. base 10 -> b = 10

        // radix sort is time O(d(n + b)) and space O(n + b).
        // radix sort is linear time iff b < n.

        // radix sort is a tradeoff between time and space.
        // larger b = more space required for counting sort
        // smaller d = fewer digits

        long[] numbers = {5000, 1000, 500, 100, 50, 10, 5, 1};
        radixSort(numbers, BASE);
        System.out.println(Arrays.toString(numbers)); // [1, 5, 10, 50, 100, 500, 1000, 5000]

        long[] numbers2 = {53, 89, 1000, 150, 36, 633, 234};
        radixSort(numbers2, BASE);
        System.out.println(Arrays.toString(numbers2)); // [36, 53, 89, 150, 234, 633, 1000]
    }

    /**
     * Sort this array (of base 10 numbers).
     *
     * Precondition: array is not empty.
     */
    private static void radixSort(long[] array, int base) {
        // source: https://www.geeksforgeeks.org/radix-sort/

        // We need to know the largest number to know the max number of digits needed.
        long largestNumber = getLargestValue(array);

        // Perform counting sort on each digit.
        for (int currentDigit = 0; Math.pow(base, currentDigit) <= largestNumber; currentDigit++) {
            countingSort(array, currentDigit, base);
        }
    }

    /**
     * Return the largest value in the array.
     *
     * Precondition: array is not empty.
     */
    private static long getLargestValue(long[] array) {
        long maxValue = array[0];
        for (int currentIndex = 1; currentIndex < array.length; currentIndex++) {
            if (array[currentIndex] > maxValue) {
                maxValue = array[currentIndex];
            }
        }
        return maxValue;
    }
}
