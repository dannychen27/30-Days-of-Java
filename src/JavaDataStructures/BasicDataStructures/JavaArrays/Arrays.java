package JavaDataStructures.PrimitiveDataStructures.Object.JavaArrays;

public class Arrays {

    public static void main(String[] args) {
        // In Java and C, arrays are fixed length, not variable length like in Python.

        // Array values before initialization
        // The default value of an uninitialized int is 0.
        int[] scores = new int[5];
        for (int score : scores) {
            System.out.println(score);  // 0, 0, 0, 0, 0
        }
        System.out.println(scores); // this prints a memory address of the array

        // Array values after initializations
        for (int i = 0; i < scores.length; i++) {
            scores[i] = i + 10;
            System.out.println(scores[i]);  // 10, 11, 12, 13, 14
        }
        System.out.println(scores); // this prints a memory address of the array
    }
}
