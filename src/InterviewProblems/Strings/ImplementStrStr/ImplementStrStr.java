package InterviewProblems.Strings.ImplementStrStr;

public class ImplementStrStr {

    // Let m = length of haystack, n = length of needle
    // Time: O(m * n)
    // --> Nested for loop of "substring checking"
    // Space: O(1)
    // --> We aren't storing any extra space.

    public static void main(String[] args) {
        ImplementStrStr implementStrStr = new ImplementStrStr();

        // Input: haystack = "hello", needle = "ll"
        // Output: 2
        String haystack1 = "hello";
        String needle1 = "ll";
        int result1 = implementStrStr.strStr(haystack1, needle1);
        System.out.println(result1);  // 2

        // Input: haystack = "aaaaa", needle = "bba"
        // Output: -1
        String haystack2 = "aaaaa";
        String needle2 = "bba";
        int result2 = implementStrStr.strStr(haystack2, needle2);
        System.out.println(result2);  // -1

        // Input: haystack = "", needle = ""
        // Output: 0
        String haystack3 = "";
        String needle3 = "";
        int result3 = implementStrStr.strStr(haystack3, needle3);
        System.out.println(result3);  // 0

        // Input: haystack = "bel", needle = "ll"
        // Output: -1
        String haystack4 = "bel";
        String needle4 = "ll";
        int result4 = implementStrStr.strStr(haystack4, needle4);
        System.out.println(result4);  // -1

        // Input: haystack = "bell", needle = "ll"
        // Output: 2
        String haystack5 = "bell";
        String needle5 = "ll";
        int result5 = implementStrStr.strStr(haystack5, needle5);
        System.out.println(result5);  // 2

        // Input: haystack = "lllll", needle = "ll"
        // Output: 0
        String haystack6 = "lllll";
        String needle6 = "ll";
        int result6 = implementStrStr.strStr(haystack6, needle6);
        System.out.println(result6);  // 0

        // Input: haystack = "", needle = "llll"
        // Output: -1
        String haystack7 = "";
        String needle7 = "llll";
        int result7 = implementStrStr.strStr(haystack7, needle7);
        System.out.println(result7);  // -1
    }

    /**
     * Return the index of the first occurrence of needle in haystack,
     * or -1 if needle is not part of haystack.
     *
     * Precondition:
     * - haystack and needle consist of only lower-case English characters.
     */
    public int strStr(String haystack, String needle) {
        if (needle.equals("")) {
            return 0;
        }

        if (haystack.equals("") || needle.length() > haystack.length()) {
            return -1;
        }

        // We want to stop early to make sure the window is big enough for the needle.
        int maxStartIndex = haystack.length() - needle.length() + 1;
        for (int i = 0; i < maxStartIndex; i++) {
             if (isSubstring(haystack, needle, i)) {
                 return i;
             }
        }
        return -1;
    }

    private boolean isSubstring(String word, String substring, int startIndex) {
        for (int i = 0; i < substring.length(); i++) {
            if (word.charAt(startIndex + i) != substring.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
