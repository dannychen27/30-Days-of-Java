package InterviewProblems.Hashmaps.GroupAnagrams.OriginalSolution;

import java.util.HashMap;
import java.util.LinkedList;
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
        Map<Map<Character, Integer>, List<String>> groupsOfAnagrams = recordGroupsOfAnagrams(strs);
        return getGroupsOfAnagrams(groupsOfAnagrams);
    }

    private Map<Map<Character, Integer>, List<String>> recordGroupsOfAnagrams(String[] strings) {
        Map<Map<Character, Integer>, List<String>> characterCompositionsToAnagrams = new HashMap<>();
        for (String originalString : strings) {
            Map<Character, Integer> anagramOfString = findAnagram(originalString);
            groupAnagrams(characterCompositionsToAnagrams, originalString, anagramOfString);
        }
        return characterCompositionsToAnagrams;
    }

    private Map<Character, Integer> findAnagram(String string) {
        Map<Character, Integer> charactersToCounts = new HashMap<>();
        for (char c : string.toCharArray()) {
            if (!charactersToCounts.containsKey(c)) {
                charactersToCounts.put(c, 0);
            }
            charactersToCounts.put(c, charactersToCounts.get(c) + 1);
        }
        return charactersToCounts;
    }

    private void groupAnagrams(Map<Map<Character, Integer>, List<String>> characterCompositionsToAnagrams,
                               String originalString, Map<Character, Integer> anagramString) {
        if (!characterCompositionsToAnagrams.containsKey(anagramString)) {
            characterCompositionsToAnagrams.put(anagramString, new LinkedList<>());
        }
        characterCompositionsToAnagrams.get(anagramString).add(originalString);
    }
    
    private List<List<String>> getGroupsOfAnagrams(Map<Map<Character, Integer>, List<String>> characterCompositionsToAnagrams) {
        List<List<String>> groupsOfAnagrams = new LinkedList<>();
        for (Map<Character, Integer> characterComposition : characterCompositionsToAnagrams.keySet()) {
            List<String> wordsWithSameAnagram = characterCompositionsToAnagrams.get(characterComposition);
            groupsOfAnagrams.add(wordsWithSameAnagram);
        }
        return groupsOfAnagrams;
    }
}
