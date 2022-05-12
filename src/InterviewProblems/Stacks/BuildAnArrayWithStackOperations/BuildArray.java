package InterviewProblems.Stacks.BuildAnArrayWithStackOperations;

import java.util.ArrayList;
import java.util.List;

public class BuildArray {

    // Let m = the value of n
    // Let n = the value of the largest element in target
    //
    // Time: O(min(m, n))
    // --> We must perform at most m or n iterations, whichever is lowest.
    // Space: O(min(m, n))
    // --> We must store min(m, n) elements in the new arraylist.

    public static void main(String[] args) {
        BuildArray buildArray = new BuildArray();

        // Input: target = [1, 3], n = 3
        // Output: ["Push", "Push", "Pop", "Push"]
        // Explanation:
        // Read number 1 and automatically push in the array -> [1]
        // Read number 2 and automatically push in the array then Pop it -> [1]
        // Read number 3 and automatically push in the array -> [1, 3]
        int[] target1 = {1, 3};
        List<String> builtArray1 = buildArray.buildArray(target1, 3);
        System.out.println(builtArray1);  // ["Push", "Push", "Pop", "Push"]

        // Input: target = [1, 2, 3], n = 3
        // Output: ["Push", "Push", "Push"]
        // Explanation: Read number 1, Push,
        // then read number 2, Push,
        // then read number 3, Push,
        // then Pop everything -> [1, 2, 3]
        int[] target2 = {1, 2, 3};
        List<String> builtArray2 = buildArray.buildArray(target2, 3);
        System.out.println(builtArray2);  // ["Push", "Push", "Push"]

        // Input: target = [1, 2], n = 4
        // Output: ["Push", "Push"]
        // Explanation: You only need to read the first 2 numbers and stop.
        // Number 2 is automatically read after number 1 -> [1, 2]
        int[] target3 = {1, 2};
        List<String> builtArray3 = buildArray.buildArray(target3, 4);
        System.out.println(builtArray3);  // ["Push", "Push"]
    }

    /**
     * You are given an array target and an integer n.
     *
     * In each iteration, you will read a number from list = [1, 2, 3, ..., n].
     *
     * Build the target array using the following operations:
     *
     * "Push": Reads a new element from the beginning list, and pushes it in the array.
     * "Pop": Deletes the last element of the array.
     * If the target array is already built, stop reading more elements.
     * Return a list of the operations needed to build target.
     * The test cases are generated so that the answer is unique.
     *
     * Preconditions:
     * - 1 <= target.length <= 100
     * - 1 <= n <= 100
     * - 1 <= target[i] <= n
     * - target is strictly increasing.
     */
    public List<String> buildArray(int[] target, int n) {
        List<String> operations = new ArrayList<>();
        int currentIndex = 0;
        int i = 1;
        int threshold = Math.min(n, target[target.length - 1]);
        while (i <= threshold) {
            if (i == target[currentIndex]) {
                operations.add("Push");
                currentIndex++;
            } else {  // i != target[currentIndex]
                operations.add("Push");
                operations.add("Pop");
            }
            i++;
        }
        return operations;
    }
}
