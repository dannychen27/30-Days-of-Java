package Algorithms.SortingAlgorithms.BogoSort;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class BogoSort {

    void bogoSort(Integer[] array) {
        // source: https://www.journaldev.com/32661/shuffle-array-java

        while (!isSorted(array)) {
            List<Integer> intList = Arrays.asList(array);
            Collections.shuffle(intList);  // apparently int[] has no shuffle method
        }
    }

    private boolean isSorted(Integer[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i - 1] > array[i]) {
                return false;
            }
        }
        return true;
    }
}
