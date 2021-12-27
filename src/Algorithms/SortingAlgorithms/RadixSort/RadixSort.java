package Algorithms.SortingAlgorithms.RadixSort;

import static Algorithms.SortingAlgorithms.CountingSort.CountingSort.countingSort;

class RadixSort {

    private static final int BASE = 10;

    // Source: https://www.youtube.com/watch?v=XiuSW_mEn7g Radix Sort

    // let n = length of array
    // let d = max number of digits needed to represent each number.
    // let b = the base you're using, range of keys. e.g. base 10 -> b = 10

    // radix sort is time O(d(n + b)) and space O(n + b).
    // radix sort is linear time iff b < n.

    // radix sort is a tradeoff between time and space.
    // larger b = more space required for counting sort
    // smaller d = fewer digits

    /**
     * Sort this array (of base 10 numbers).
     *
     * Precondition: array is not empty.
     */
    void radixSort(long[] array) {
        // source: https://www.geeksforgeeks.org/radix-sort/

        if (array.length == 0) {
            return;
        }

        // We need to know the largest number to know the max number of digits needed.
        long largestNumber = getLargestValue(array);

        // Perform counting sort on each digit.
        for (int currentDigit = 0; Math.pow(BASE, currentDigit) <= largestNumber; currentDigit++) {
            countingSort(array, currentDigit);
        }
    }

    /**
     * Return the largest value in the array.
     *
     * Precondition: array is not empty.
     */
    private long getLargestValue(long[] array) {
        long maxValue = array[0];
        for (int currentIndex = 1; currentIndex < array.length; currentIndex++) {
            if (array[currentIndex] > maxValue) {
                maxValue = array[currentIndex];
            }
        }
        return maxValue;
    }
}
