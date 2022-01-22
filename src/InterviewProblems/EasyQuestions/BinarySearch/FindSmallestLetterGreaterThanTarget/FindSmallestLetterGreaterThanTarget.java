package InterviewProblems.EasyQuestions.BinarySearch.FindSmallestLetterGreaterThanTarget;

public class FindSmallestLetterGreaterThanTarget {

    public static void main(String[] args) {
        FindSmallestLetterGreaterThanTarget fslgt = new FindSmallestLetterGreaterThanTarget();

        // Example 1:
        //
        // Input: letters = ["c", "f", "j"], target = "a"
        // Output: "c"
        char[] letters = {'c', 'f', 'j'};
        char target = 'a';
        System.out.println(fslgt.nextGreatestLetter(letters, target));  // c

        // Example 2:
        //
        // Input: letters = ["c", "f", "j"], target = "c"
        // Output: "f"
        char[] letters2 = {'c', 'f', 'j'};
        char target2 = 'c';
        System.out.println(fslgt.nextGreatestLetter(letters2, target2));  // f

        // Example 3:
        //
        // Input: letters = ["c", "f", "j"], target = "d"
        // Output: "f"
        char[] letters3 = {'c', 'f', 'j'};
        char target3 = 'd';
        System.out.println(fslgt.nextGreatestLetter(letters3, target3));  // f

        // Example 4:
        //
        // Input: letters = ["e", "e", "e", "e", "e", "e", "n", "n", "n", "n"], target = "e"
        // Output: "n"
        char[] letters4 = {'e', 'e', 'e', 'e', 'e', 'e', 'n', 'n', 'n', 'n'};
        char target4 = 'e';
        System.out.println(fslgt.nextGreatestLetter(letters4, target4));  // n
    }

    /**
     * Given a characters array letters that is sorted in non-decreasing order and a character target,
     * return the smallest character in the array that is larger than target.
     *
     * Note that the letters array wrap around.
     * For example, if target == 'z' and letters == ['a', 'b'], the answer is 'a'.
     *
     * Preconditions:
     * - letters is sorted in non-decreasing order.
     * - letters[i] is a lowercase English letter.
     * - target is a lowercase English letter.
     * - letters contains at least two different characters.
     */
    public char nextGreatestLetter(char[] letters, char target) {
        int leftIndex = 0;
        int rightIndex = letters.length - 1;
        while (leftIndex <= rightIndex) {
            int middleIndex = (rightIndex + leftIndex) / 2;
            if (target == letters[middleIndex]) {
                while (middleIndex < rightIndex && letters[middleIndex + 1] == target) {
                    middleIndex++;
                }
                return letters[(middleIndex + 1) % letters.length];  // the next letter greater than target
            } else if (target < letters[middleIndex]) {
                rightIndex = middleIndex - 1;  // look in left half
            } else {  // target > letters[middleIndex]
                leftIndex = middleIndex + 1;  // look in right half
            }
        }
        return letters[leftIndex % letters.length];
    }
}
