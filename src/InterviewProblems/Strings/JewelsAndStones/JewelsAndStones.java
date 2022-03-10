package InterviewProblems.Strings.JewelsAndStones;

public class JewelsAndStones {

    // Let n = number of jewels, m = number of stones
    //
    // Time: O(m * n)
    // --> For each of the O(m) stones, we must compare them against
    // each of the O(n) jewels.
    // Space: O(1)
    // --> We don't store any auxiliary data structures.

    public static void main(String[] args) {
        JewelsAndStones jewelsAndStones = new JewelsAndStones();

        // Input: jewels = "aA", stones = "aAAbbbb"
        // Output: 3
        String jewels1 = "aA";
        String stones1 = "aAAbbbb";
        int result1 = jewelsAndStones.numJewelsInStones(jewels1, stones1);
        System.out.println(result1);  // 3

        // Input: jewels = "z", stones = "ZZ"
        // Output: 0
        String jewels2 = "z";
        String stones2 = "ZZ";
        int result2 = jewelsAndStones.numJewelsInStones(jewels2, stones2);
        System.out.println(result2);  // 0

        // TODO: How would you solve this problem with a hashmap?
    }

    /**
     * You're given strings jewels representing the types of stones that are jewels, and stones
     * representing the stones you have. Each character in stones is a type of stone you have.
     * You want to know how many of the stones you have are also jewels.
     *
     * Letters are case sensitive, so "a" is considered a different type of stone from "A".
     *
     * Preconditions:
     * - jewels.length, stones.length >= 1.
     * - jewels and stones consist of only English letters.
     * - All the characters of jewels are unique.
     */
    public int numJewelsInStones(String jewels, String stones) {
        int numJewels = 0;
        for (int i = 0; i < stones.length(); i++) {
            for (int j = 0; j < jewels.length(); j++) {
                if (stones.charAt(i) == jewels.charAt(j)) {
                    numJewels++;
                }
            }
        }
        return numJewels;
    }
}
