package Algorithms.SortingAlgorithms.CountingSort;

import java.util.Arrays;

public class CountingSort {

    private static final int BASE = 10;

    public static void main(String[] args) {
        // Source: https://www.youtube.com/watch?v=OKd534EWcdk Counting Sort
        // let n = length of array
        // let d = max number of digits needed to represent each number.
        // let b = the base you're using, range of keys. e.g. base 10 -> b = 10

        // counting sort has time O(n + b) and space O(n + b).
        // counting sort is linear time iff b < n.
        // counting sort is a tradeoff between time and space.
        // larger b = more space required for counting sort
        // smaller d = fewer digits

        long[] numbers = {5000, 1000, 500, 100, 50, 10, 5, 1};
        countingSort(numbers, 0, BASE);
        System.out.println(Arrays.toString(numbers)); // [5000, 1000, 500, 100, 50, 10, 1, 5]

    }

    /**
     * Perform counting sort on array based on the currentDigit-th digit starting from the right.
     */
    public static void countingSort(long[] array, int currentDigit, int base) {
        int[] digitCounts = new int[base];
        int[] digitStartIndex = new int[base];
        long[] sortedArray = new long[array.length];

        // Store the occurrence of each digit in digitCounts.
        int digit;
        for (long value : array) {
            digit = (int) ((value / Math.pow(base, currentDigit)) % base);
            digitCounts[digit]++;
        }

        // Determine the first index where a value with this current digit belongs in sortedArray.
        digitStartIndex[0] = digitCounts[0];
        for (int i = 1; i < digitStartIndex.length; i++) {
            digitStartIndex[i] = digitStartIndex[i - 1] + digitCounts[i];
        }

        // Insert values in sortedArray at the specified indices in digitStartIndex.
        int[] shiftedDigitStartIndex = shiftArrayRight(digitStartIndex);
        for (long value : array) {
            digit = (int) ((value / Math.pow(base, currentDigit)) % base);
            int indexToInsert = shiftedDigitStartIndex[digit];
            sortedArray[indexToInsert] = value;
            shiftedDigitStartIndex[digit]++;
        }

        // Copy the sortedArray back to array, so that array now contains
        // sorted numbers according to the current digit.
        for (int i = 0; i < array.length; i++) {
            array[i] = sortedArray[i];
        }
    }

    private static int[] shiftArrayRight(int[] array) {
        for (int i = array.length - 2; i >= 0; i--) {
            array[i + 1] = array[i];
        }

        array[0] = 0;
        return array;
    }
}
