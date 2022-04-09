package InterviewProblems.Strings.DetermineIfStringHalvesAreAlike;

public class AreStringHalvesAlike {

    // Let n = the length of the string s
    //
    // Time: O(n)
    // --> O(n) for slicing both halves of the string s, before passing them into the
    // countVowels helper function.
    // --> O(n) for counting the number of vowels in both halves of the string s.
    // Space: O(n)
    // --> O(n) to store the two sliced string halves.

    public static void main(String[] args) {
        AreStringHalvesAlike areStringHalvesAlike = new AreStringHalvesAlike();

        // Input: s = "ae"
        // Output: true
        String s1 = "ae";
        boolean areStringHalvesAlike1 = areStringHalvesAlike.halvesAreAlike(s1);
        System.out.println(areStringHalvesAlike1);  // true

        // Input: s = "ad"
        // Output: false
        String s2 = "ad";
        boolean areStringHalvesAlike2 = areStringHalvesAlike.halvesAreAlike(s2);
        System.out.println(areStringHalvesAlike2);  // false

        // Input: s = "book"
        // Output: true
        // Explanation: a = "bo" and b = "ok". a has 1 vowel and b has 1 vowel.
        // Therefore, they are alike.
        String s3 = "book";
        boolean areStringHalvesAlike3 = areStringHalvesAlike.halvesAreAlike(s3);
        System.out.println(areStringHalvesAlike3);  // true

        // Input: s = "textbook"
        // Output: false
        // Explanation: a = "text" and b = "book". a has 1 vowel whereas b has 2.
        // Therefore, they are not alike.
        // Notice that the vowel o is counted twice.
        String s4 = "textbook";
        boolean areStringHalvesAlike4 = areStringHalvesAlike.halvesAreAlike(s4);
        System.out.println(areStringHalvesAlike4);  // false
    }

    /**
     * You are given a string s of even length.
     * Split this string into two halves of equal lengths, and let a be the first half
     * and b be the second half.
     *
     * Two strings are alike if they have the same number of vowels ('a', 'e',
     * 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U').
     * Notice that s contains uppercase and lowercase letters.
     *
     * Return true iff a and b are alike.
     *
     * Preconditions:
     * - 2 <= s.length <= 1000
     * - s.length is even.
     * - s consists of uppercase and lowercase letters.
     */
    public boolean halvesAreAlike(String s) {
        int numVowelsFirstHalf = countVowels(s.substring(0, s.length() / 2));
        int numVowelsSecondHalf = countVowels(s.substring(s.length() / 2));
        return numVowelsFirstHalf == numVowelsSecondHalf;
    }

    private int countVowels(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (isVowel(s.charAt(i))) {
                count++;
            }
        }
        return count;
    }

    private boolean isVowel(char c) {
        return  c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
                c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
}
