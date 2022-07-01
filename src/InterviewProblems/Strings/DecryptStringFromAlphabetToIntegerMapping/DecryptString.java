package InterviewProblems.Strings.DecryptStringFromAlphabetToIntegerMapping;

public class DecryptString {

    // Let n = the length of the string
    //
    // Time: O(n)
    // --> We must iterate through the string once.
    // Space: O(n)
    // --> We must store the decrypted string.

    public static void main(String[] args) {
        DecryptString decryptString = new DecryptString();

        // Input: s = "10#11#12"
        // Output: "jkab"
        // Explanation: "j" -> "10#" , "k" -> "11#" , "a" -> "1" , "b" -> "2".
        String decryptedString1 = decryptString.freqAlphabets("10#11#12");
        System.out.println(decryptedString1);  // jkab

        // Input: s = "1326#"
        // Output: "acz"
        // Explanation: "a" -> "1" , "c" -> "3" , "z" -> "26#".
        String decryptedString2 = decryptString.freqAlphabets("1326#");
        System.out.println(decryptedString2);  // acz
    }

    /**
     * You are given a string s formed by digits and '#'.
     * We want to map s to English lowercase characters as follows:
     *
     * Characters ('a' to 'i') are represented by ('1' to '9') respectively.
     * Characters ('j' to 'z') are represented by ('10#' to '26#') respectively.
     * Return the string formed after mapping.
     *
     * The test cases are generated so that a unique mapping will always exist.
     *
     * Preconditions:
     * - 1 <= s.length <= 1000
     * - s consists of digits and the '#' letter.
     * - s will be a valid string such that mapping is always possible.
     */
    public String freqAlphabets(String s) {
        StringBuilder decryptedString = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (i + 2 < s.length() && s.charAt(i + 2) == '#') {
                // get the number from the string
                int number = Integer.parseInt(s.substring(i, i + 2));
                char character = (char) (number + 96);
                decryptedString.append(character);
                i += 2;
            } else {
                // get the number from the string
                int number = Integer.parseInt(s.substring(i, i + 1));
                char character = (char) (number + 96);
                decryptedString.append(character);
            }
        }
        return decryptedString.toString();
    }
}
