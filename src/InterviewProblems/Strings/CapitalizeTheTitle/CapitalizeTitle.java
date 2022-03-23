package InterviewProblems.Strings.CapitalizeTheTitle;

public class CapitalizeTitle {

    // Let n = the length of the original string.
    //
    // Time: O(n)
    // --> We must traverse the string once.
    // Space: O(n)
    // --> We must store another string representing the capitalized title.

    public static void main(String[] args) {
        CapitalizeTitle capitalizeTitle = new CapitalizeTitle();

        // Input: title = "dIFFUSER"
        // Output: "Diffuser"
        String title1 = "dIFFUSER";
        String result1 = capitalizeTitle.capitalizeTitle(title1);
        System.out.println(result1);  // Diffuser

        // Input: title = "capiTalIze tHe titLe"
        // Output: "Capitalize The Title"
        // Explanation:
        // Since all the words have a length of at least 3, the first letter of each word is uppercase, and the remaining letters are lowercase.
        String title2 = "capiTalIze tHe titLe";
        String result2 = capitalizeTitle.capitalizeTitle(title2);
        System.out.println(result2);  // Capitalize The Title

        // Input: title = "First leTTeR of EACH Word"
        // Output: "First Letter of Each Word"
        // Explanation:
        // The word "of" has length 2, so it is all lowercase.
        // The remaining words have a length of at least 3, so the first letter of each remaining word is uppercase, and the remaining letters are lowercase.
        String title3 = "First leTTeR of EACH Word";
        String result3 = capitalizeTitle.capitalizeTitle(title3);
        System.out.println(result3);  // First Letter of Each Word

        // Input: title = "i lOve leetcode"
        // Output: "i Love Leetcode"
        // Explanation:
        // The word "i" has length 1, so it is lowercase.
        // The remaining words have a length of at least 3, so the first letter of each remaining word is uppercase, and the remaining letters are lowercase.
        String title4 = "i lOve leetcode";
        String result4 = capitalizeTitle.capitalizeTitle(title4);
        System.out.println(result4);  // i Love Leetcode
    }

    /**
     * You are given a string title consisting of one or more words separated by a
     * single space, where each word consists of English letters.
     *
     * Capitalize the string by changing the capitalization of each word such that:
     *
     * If the length of the word is 1 or 2 letters, change all letters to lowercase.
     * Otherwise, change the first letter to uppercase and the remaining letters to
     * lowercase.
     *
     * Return the capitalized title.
     *
     * Preconditions:
     * - title.length >= 1.
     * - title consists of words separated by a single space without any leading or trailing spaces.
     * - Each word consists of uppercase and lowercase English letters and is non-empty.
     */
    public String capitalizeTitle(String title) {
        String[] words = title.split(" ");

        StringBuilder capitalizedTitle = new StringBuilder();
        for (String word : words) {
            capitalizedTitle.append(capitalize(word)).append(" ");
        }
        return capitalizedTitle.toString().trim();
    }

    private String capitalize(String word) {
        if (1 <= word.length() && word.length() <= 2) {
            // change all letters to lowercase
            return word.toLowerCase();
        }

        // change first letter to uppercase, and rest of letters to lowercase
        StringBuilder capitalizedWord = new StringBuilder();
        capitalizedWord.append(Character.toUpperCase(word.charAt(0)));
        for (int i = 1; i < word.length(); i++) {
            capitalizedWord.append(Character.toLowerCase(word.charAt(i)));
        }
        return capitalizedWord.toString();
    }
}
