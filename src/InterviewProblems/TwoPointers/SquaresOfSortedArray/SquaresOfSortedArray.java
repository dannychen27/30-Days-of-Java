package InterviewProblems.TwoPointers.SquaresOfSortedArray;

import java.util.Arrays;

public class SquaresOfSortedArray {

    public static void main(String[] args) {
        SquaresOfSortedArray squaresOfSortedArray = new SquaresOfSortedArray();

        int[] numbers1 = {-4, -1, 0, 3, 10};
        int[] result1 = squaresOfSortedArray.sortedSquares(numbers1);
        System.out.println(Arrays.toString(result1));  // [0, 1, 9, 16, 100]

        int[] numbers2 = {-7, -3, 2, 3, 11};
        int[] result2 = squaresOfSortedArray.sortedSquares(numbers2);
        System.out.println(Arrays.toString(result2));  // [4, 9, 9, 49, 121]
    }

    public int[] sortedSquares(int[] nums) {
        int[] squaredArray = new int[nums.length];
        int leftIndex = 0;
        int rightIndex = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[leftIndex] * nums[leftIndex] >= nums[rightIndex] * nums[rightIndex]) {
                squaredArray[i] = nums[leftIndex] * nums[leftIndex];
                leftIndex++;
            } else {  // nums[leftIndex] * nums[leftIndex] < nums[rightIndex] * nums[rightIndex]
                squaredArray[i] = nums[rightIndex] * nums[rightIndex];
                rightIndex--;
            }
        }
        return squaredArray;
    }
}
