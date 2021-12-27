package DataStructures.BasicDataStructures.JavaArrays;

import java.util.Arrays;

public class JavaArrays {

    public static void main(String[] args) {
        // In Java and C, arrays are fixed length, not variable length like in Python.

        // Array values before initialization
        // The default value of an uninitialized int is 0.
        int[] scores = new int[5];
        System.out.println(scores); // [I@38af3868, the memory address of the array scores.
        System.out.println(Arrays.toString(scores)); // [0, 0, 0, 0, 0]

        // Array.toString() is for printing the contents of arrays.
        for (int i = 0; i < scores.length; i++) {
            scores[i] = i + 10;
        }
        System.out.println(Arrays.toString(scores)); // [10, 11, 12, 13, 14]

        // Arrays.deepToString() is for printing the contents of nested arrays.
        int[][] allScores = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(Arrays.deepToString(allScores)); // [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
    }
}
