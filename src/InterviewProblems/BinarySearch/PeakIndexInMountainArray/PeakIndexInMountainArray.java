package InterviewProblems.BinarySearch.PeakIndexInMountainArray;

public class PeakIndexInMountainArray {

    public static void main(String[] args) {
        PeakIndexInMountainArray peakIndexInMountainArray = new PeakIndexInMountainArray();

        // Example 1:
        //
        // Input: arr = [0, 1, 0]
        // Output: 1
        int[] array1 = {0, 1, 0};
        System.out.println(peakIndexInMountainArray.peakIndexInMountainArray(array1));  // 1

        // Example 2:
        //
        // Input: arr = [0, 2, 1, 0]
        // Output: 1
        int[] array2 = {0, 2, 1, 0};
        System.out.println(peakIndexInMountainArray.peakIndexInMountainArray(array2));  // 1

        // Example 3:
        //
        // Input: arr = [0, 5, 10, 2]
        // Output: 2
        int[] array3 = {0, 5, 10, 2};
        System.out.println(peakIndexInMountainArray.peakIndexInMountainArray(array3));  // 2

        // Example 4:
        //
        // Input: arr = [3, 5, 3, 2, 0]
        // Output: 1
        int[] array4 = {3, 5, 3, 2, 0};
        System.out.println(peakIndexInMountainArray.peakIndexInMountainArray(array4));  // 1
    }

    public int peakIndexInMountainArray(int[] arr) {
        int leftIndex = 0;
        int rightIndex = arr.length - 1;
        while (leftIndex <= rightIndex) {
            int middleIndex = (leftIndex + rightIndex) / 2;
            if (arr[middleIndex] <= arr[middleIndex + 1]) {  // too far left
                leftIndex = middleIndex;
            } else if (arr[middleIndex - 1] >= arr[middleIndex]) {  // too far right
                rightIndex = middleIndex;
            } else {
                return middleIndex;
            }
        }
        return -1;  // this can never happen, since arr must have exactly 1 mountain
    }
}
