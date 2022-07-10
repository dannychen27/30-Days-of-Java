package InterviewProblems.Greedy.MinimumTimeToTypeWordUsingSpecialTypewriter;

public class MinTimeToType {

    // Let n = the length of the string s.
    //
    // Time: O(n)
    // --> We must traverse the string s once, and each character takes O(1) time to type.
    // Space: O(1)
    // --> We don't need any additional data structures.

    public static void main(String[] args) {
        MinTimeToType minTimeToType = new MinTimeToType();

        // string size = 1
        // Input: word = "a"
        // Output: 1
        // Explanation: You must type 1 character for the first time.
        int minTimeToType1 = minTimeToType.minTimeToType("a");
        System.out.println(minTimeToType1);  // 1

        // consecutive letters in alphabet
        // Input: word = "abc"
        // Output: 5
        // Explanation:
        // The characters are printed as follows:
        // - Type the character 'a' in 1 second since the pointer is initially on 'a'.
        // - Move the pointer clockwise to 'b' in 1 second.
        // - Type the character 'b' in 1 second.
        // - Move the pointer clockwise to 'c' in 1 second.
        // - Type the character 'c' in 1 second.
        int minTimeToType2 = minTimeToType.minTimeToType("abc");
        System.out.println(minTimeToType2);  // 5

        // letters that look far apart, but aren't (letters can "wrap" around)
        // Input: word = "bza"
        // Output: 7
        // Explanation:
        // The characters are printed as follows:
        // - Move the pointer clockwise to 'b' in 1 second.
        // - Type the character 'b' in 1 second.
        // - Move the pointer counterclockwise to 'z' in 2 seconds.
        // - Type the character 'z' in 1 second.
        // - Move the pointer clockwise to 'a' in 1 second.
        // - Type the character 'a' in 1 second.
        int minTimeToType3 = minTimeToType.minTimeToType("bza");
        System.out.println(minTimeToType3);  // 7

        // letters that are decently far apart.
        // Input: word = "zjpc"
        // Output: 34
        // Explanation:
        // The characters are printed as follows:
        // - Move the pointer counterclockwise to 'z' in 1 second.
        // - Type the character 'z' in 1 second.
        // - Move the pointer clockwise to 'j' in 10 seconds.
        // - Type the character 'j' in 1 second.
        // - Move the pointer clockwise to 'p' in 6 seconds.
        // - Type the character 'p' in 1 second.
        // - Move the pointer counterclockwise to 'c' in 13 seconds.
        // - Type the character 'c' in 1 second.
        int minTimeToType4 = minTimeToType.minTimeToType("zjpc");
        System.out.println(minTimeToType4);  // 34
    }

    /**
     * There is a special typewriter with lowercase English letters 'a' to 'z' arranged
     * in a circle with a pointer. A character can only be typed if the pointer is
     * pointing to that character. The pointer is initially pointing to the character
     * 'a'.
     *
     * Each second, you may perform one of the following operations:
     * - Move the pointer one character counterclockwise or clockwise.
     * - Type the character the pointer is currently on.
     *
     * Given a string word, return the minimum number of seconds to type out
     * the characters in word.
     *
     * Preconditions:
     * - 1 <= word.length <= 100.
     * - word consists of lowercase English letters.
     */
    public int minTimeToType(String word) {
        int numSecondsElapsed = 0;
        char currentLetter = 'a';  // the letter the wheel points to
        for (char letterToType : word.toCharArray()) {
            // the +1 accounts for the time it takes to type the current letter
            numSecondsElapsed += closestWheelSpinDistance(currentLetter, letterToType) + 1;
            currentLetter = letterToType;
        }
        return numSecondsElapsed;
    }

    private int closestWheelSpinDistance(char currentLetter, char targetLetter) {
        int spinDistance = Math.abs(targetLetter - currentLetter);
        return Math.min(spinDistance, 26 - spinDistance);
    }
}
