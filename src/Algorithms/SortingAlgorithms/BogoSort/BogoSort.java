package Algorithms.SortingAlgorithms.BogoSort;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BogoSort {

    public static void main(String[] args) {
        Integer[] numbers = {3, 2, 1}; // I chose a small list, since it only has 6 permutations.
        bogoSort(numbers);
        System.out.println(Arrays.toString(numbers)); // [1, 2, 3]
    }

    private static void bogoSort(Integer[] array) {
        while (!isSorted(array)) {
            List<Integer> intList = Arrays.asList(array);
            Collections.shuffle(intList);  // apparently int[] has no shuffle method
        }
    }

    private static boolean isSorted(Integer[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i - 1] > array[i]) {
                return false;
            }
        }
        return true;
    }
}
