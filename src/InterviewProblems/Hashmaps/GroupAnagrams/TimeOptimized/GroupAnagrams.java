package InterviewProblems.Hashmaps.GroupAnagrams.TimeOptimized;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

    // Let n = the number of characters across all words.
    //
    // Time: O(n)
    // --> O(n) to populate the hashmap of the anagrams of all words
    // --> O(n) to populate the list of all groups of words with the same anagrams
    // Space: O(n)
    // --> O(n) to store a hashmap of the anagrams of all words
    // --> O(n) to store a list of all groups of words with the same anagrams

    public static void main(String[] args) {
        GroupAnagrams groupAnagrams = new GroupAnagrams();

        // Input: strs = [""]
        // Output: [[""]]
        String[] strs1 = {""};
        List<List<String>> result1 = groupAnagrams.groupAnagrams(strs1);
        System.out.println(result1);  // [[""]]

        // Input: strs = ["a"]
        // Output: [["a"]]
        String[] strs2 = {"a"};
        List<List<String>> result2 = groupAnagrams.groupAnagrams(strs2);
        System.out.println(result2);  // [["a"]]

        // Input: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
        // Output: [["bat"], ["nat", "tan"], ["ate", "eat", "tea"]]
        String[] strs3 = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result3 = groupAnagrams.groupAnagrams(strs3);
        System.out.println(result3);  // [["bat"], ["nat", "tan"], ["ate", "eat", "tea"]]

        // Input: strs = ["", "", ""]
        // Output: [[""], [""], [""]]
        String[] strs4 = {"", "", ""};
        List<List<String>> result4 = groupAnagrams.groupAnagrams(strs4);
        System.out.println(result4);  // [[""], [""], [""]]
    }

    /**
     * Given an array of strings strs, group the anagrams together.
     * You can return the answer in any order.
     *
     * An anagram is a word or phrase formed by rearranging the letters of a different
     * word or phrase, typically using all the original letters exactly once.
     *
     * Preconditions:
     * - 1 <= strs.length <= 10 ^ 4
     * - 0 <= strs[i].length <= 100
     * - strs[i] consists of lowercase English letters.
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) {
            return new ArrayList<>();
        }

        Map<String, List<String>> groupsOfAnagrams = new HashMap<>();
        for (String originalString : strs) {
            char[] characterCounts = getCharacterCounts(originalString);
            recordAnagram(groupsOfAnagrams, originalString, characterCounts);
        }
        return new ArrayList<>(groupsOfAnagrams.values());
    }

    private char[] getCharacterCounts(String originalString) {
        char[] characterCounts = new char[26];
        for (char c : originalString.toCharArray()) {
            characterCounts[c - 'a']++;
        }
        return characterCounts;
    }

    private void recordAnagram(Map<String, List<String>> groupsOfAnagrams,
                               String originalString, char[] characterCounts) {
        String anagram = String.valueOf(characterCounts);
        if (!groupsOfAnagrams.containsKey(anagram)) {
            groupsOfAnagrams.put(anagram, new ArrayList<>());
        }
        groupsOfAnagrams.get(anagram).add(originalString);
    }
}
