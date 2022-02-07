package InterviewProblems.Stacks.BackspaceStringCompare;

import java.util.Stack;

public class BackspaceStringCompare {

    // Let S and T be two strings
    // Time Complexity: O(len(S) + len(T))
    // --> we must process all characters of S and T
    // Space Complexity: O(len(S) + len(T))
    // --> we're using a stack to store all characters of S and T

    public static void main(String[] args) {
        BackspaceStringCompare bsc = new BackspaceStringCompare();

        String s1 = "ab#c";
        String t1 = "ad#c";
        System.out.println(bsc.backspaceCompare(s1, t1));  // true
        // Explanation: Both s1 and t1 become "ac" after backspacing.

        String s2 = "ab##";
        String t2 = "c#d#";
        System.out.println(bsc.backspaceCompare(s2, t2));  // true
        // Explanation: Both s2 and t2 become "".

        String s3 = "a#c";
        String t3 = "b";
        System.out.println(bsc.backspaceCompare(s3, t3));  // false
        // Explanation: s3 does not become "b" since there is a '#' in
        // the string.

        String s4 = "y#fo##f";
        String t4 = "y#f#o##f";
        System.out.println(bsc.backspaceCompare(s4, t4));  // true
        // Explanation: s4 becomes "f" and t4 becomes "f" after backspacing.

        // TODO: Follow up: Can you solve it in O(n) time and O(1) space?
    }

    /**
     * Return true iff strings s and t are equal after backspacing when
     * both are typed into empty text editors.
     *
     * # represents a backspace character.
     * Note that after backspacing an empty text, the text will continue empty.
     *
     * Preconditions:
     * - s and t only contain lowercase letters and '#' characters.
     */
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> stackS = buildStack(s);
        Stack<Character> stackT = buildStack(t);
        return stackS.equals(stackT);
    }

    private Stack<Character> buildStack(String s) {
        Stack<Character> stackS = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c != '#') {
                stackS.push(c);
            } else if (!stackS.isEmpty()) {
                stackS.pop();
            }
        }
        return stackS;
    }
}
