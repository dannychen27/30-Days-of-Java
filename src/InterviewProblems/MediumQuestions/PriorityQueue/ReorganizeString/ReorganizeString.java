package InterviewProblems.MediumQuestions.PriorityQueue.ReorganizeString;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ReorganizeString {

    // Let n = the length of the string s
    //
    // Time: O(n log n)
    // --> O(n) for populating the hashmap
    // --> O(n log n) for performing n enqueue operations on our max heap
    // --> O(n log n) for performing n dequeue operations on our max heap
    // Space: O(n)
    // --> O(n) for the hashmap
    // --> O(n) for our max heap

    public static void main(String[] args) {
        ReorganizeString r = new ReorganizeString();

        // Input: s = "aab"
        // Output: "aba"
        String reorganizedString1 = r.reorganizeString("aab");
        System.out.println(reorganizedString1);  // aba

        // Input: s = "aaab"
        // Output: ""
        String reorganizedString2 = r.reorganizeString("aaab");
        System.out.println(reorganizedString2);  // ""

        // Input: s = "aaabc"
        // Output: "abaca"
        String reorganizedString3 = r.reorganizeString("aaabc");
        System.out.println(reorganizedString3);  // abaca or acaba
    }

    /**
     * Given a string s, rearrange the characters of s so that any two adjacent
     * characters are not the same.
     *
     * Return any possible rearrangement of s or return "" if not possible.
     *
     * Preconditions:
     * - 1 <= s.length <= 500
     * - s consists of lowercase English letters.
     */
    public String reorganizeString(String s) {
        // Record the most frequent characters and their counts, in descending order
        Map<Character, Integer> characterCounts = getCharacterCounts(s);
        PriorityQueue<Character> mostFrequentCharacters = new PriorityQueue<>(
            (c1, c2) -> characterCounts.get(c2) - characterCounts.get(c1)
        );
        mostFrequentCharacters.addAll(characterCounts.keySet());

        // Reorganize the string
        return buildReorganizedString(characterCounts, mostFrequentCharacters);
    }

    private Map<Character, Integer> getCharacterCounts(String word) {
        Map<Character, Integer> characterCounts = new HashMap<>();
        for (char c : word.toCharArray()) {
            if (!characterCounts.containsKey(c)) {
                characterCounts.put(c, 1);
            } else {
                characterCounts.put(c, characterCounts.get(c) + 1);
            }
        }
        return characterCounts;
    }

    private String buildReorganizedString(Map<Character, Integer> characterCounts,
                                          PriorityQueue<Character> mostFrequentCharacters) {
        StringBuilder reorganizedString = new StringBuilder();
        char previousCharacter = ' ';
        while (!mostFrequentCharacters.isEmpty() || previousCharacter != ' ') {
            // Suppose you have no choice but to add the same character twice in a row...
            if (previousCharacter != ' ' && mostFrequentCharacters.isEmpty()) {
                return "";
            }

            // Extract the most frequent letter, except for previousCharacter.
            char mostFrequentLetter = mostFrequentCharacters.poll();
            reorganizedString.append(mostFrequentLetter);
            characterCounts.put(mostFrequentLetter, characterCounts.get(mostFrequentLetter) - 1);

            // If there was a previous character that was just used, add it back to the queue
            // so it can be used again.
            if (previousCharacter != ' ') {
                mostFrequentCharacters.add(previousCharacter);
                previousCharacter = ' ';
            }

            // If the most frequent letter appears at least once, make it the previous character.
            // so we don't add the same character twice in a row.
            if (characterCounts.get(mostFrequentLetter) >= 1) {
                previousCharacter = mostFrequentLetter;
            }
        }
        return reorganizedString.toString();
    }
}
