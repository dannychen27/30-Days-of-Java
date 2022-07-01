package InterviewProblems.Arrays.CountItemsMatchingARule;

import java.util.ArrayList;
import java.util.List;

public class CountMatches {

    // Let n = the length of the items array.
    //
    // Time: O(n)
    // --> We must traverse the items array once.
    // Space: O(1)
    // --> We don't create any additional data structures.

    public static void main(String[] args) {
        CountMatches countMatches = new CountMatches();

        // Input: items = [["phone", "blue", "pixel"], ["computer", "silver", "lenovo"], ["phone", "gold", "iphone"]],
        // ruleKey = "color", ruleValue = "silver"
        // Output: 1
        // Explanation: There is only one item matching the given rule, which is ["computer", "silver", "lenovo"].
        List<List<String>> items1 = createItems();
        int numMatches1 = countMatches.countMatches(items1, "color", "silver");
        System.out.println(numMatches1);  // 1

        // Input: items = [["phone", "blue", "pixel"], ["computer", "silver", "phone"], ["phone", "gold", "iphone"]],
        // ruleKey = "type", ruleValue = "phone"
        // Output: 2
        // Explanation: There are only two items matching the given rule, which are ["phone", "blue", "pixel"]
        // and ["phone", "gold", "iphone"]. Note that the item ["computer", "silver", "phone"] does not match.
        List<List<String>> items2 = createItems();
        int numMatches2 = countMatches.countMatches(items2, "type", "phone");
        System.out.println(numMatches2);  // 2
    }

    private static List<List<String>> createItems() {
        List<List<String>> items = new ArrayList<>();
        items.add(new ArrayList<>());
        items.add(new ArrayList<>());
        items.add(new ArrayList<>());
        items.get(0).add("phone");
        items.get(0).add("blue");
        items.get(0).add("pixel");
        items.get(1).add("computer");
        items.get(1).add("silver");
        items.get(1).add("lenovo");
        items.get(2).add("phone");
        items.get(2).add("gold");
        items.get(2).add("iphone");
        return items;
    }

    /**
     * You are given an array items, where each items[i] = [typei, colori, namei] describes the type, color,
     * and name of the ith item. You are also given a rule represented by two strings, ruleKey and ruleValue.
     *
     * The ith item is said to match the rule if one of the following is true:
     * - ruleKey == "type" and ruleValue == typei.
     * - ruleKey == "color" and ruleValue == colori.
     * - ruleKey == "name" and ruleValue == namei.
     *
     * Return the number of items that match the given rule.
     *
     * Preconditions:
     * - 1 <= items.length <= 10 ^ 4.
     * - 1 <= typei.length, colori.length, namei.length, ruleValue.length <= 10
     * - ruleKey is equal to either "type", "color", or "name".
     * - All strings consist only of lowercase letters.
     */
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int numMatches = 0;
        for (List<String> item : items) {
            if (matchesRule(item, ruleKey, ruleValue)) {
                numMatches++;
            }
        }
        return numMatches;
    }

    private boolean matchesRule(List<String> item, String ruleKey, String ruleValue) {
        return  (ruleKey.equals("type") && ruleValue.equals(item.get(0))) ||
                (ruleKey.equals("color") && ruleValue.equals(item.get(1))) ||
                (ruleKey.equals("name") && ruleValue.equals(item.get(2)));
    }
}
