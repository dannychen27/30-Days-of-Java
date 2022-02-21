package InterviewProblems.MediumQuestions.PriorityQueue.SortLettersByFrequency;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SortCharactersByFrequency {

    // Let n = the number of characters in the string s.
    // Time: O(n) + O(n log n) + O(n log n) + O(n) = O(n log n)
    // --> O(n) for building the max heap.
    // --> O(n log n) for populating the max heap.
    // --> O(n log n) for performing the Extract-Map operation n times.
    // --> O(n) for building the string builder.
    // Space: O(n)
    // --> We must store a separate hashmap and separate max heap.

    public static void main(String[] args) {
        SortCharactersByFrequency scbf = new SortCharactersByFrequency();

        // Example 1: Only one character 'a' stands out as appearing most frequently.
        // Input: s = "tree"
        // Output: "eert"
        // Explanation: 'e' appears twice while 'r' and 't' both appear once.
        // So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
        String s1 = "tree";
        System.out.println(scbf.frequencySort(s1));  // "eetr" or "eert"

        // Example 2: Multiple characters appear most frequently.
        // Input: s = "cccaaa"
        // Output: "aaaccc"
        // Explanation: Both 'c' and 'a' appear three times, so both "cccaaa" and "aaaccc" are valid answers.
        // Note that "cacaca" is incorrect, as the same characters must be together.
        String s2 = "cccaaa";
        System.out.println(scbf.frequencySort(s2));  // "aaaccc" or "cccaaa"

        // Input: s = "Aabb"
        // Output: "bbAa"
        // Explanation: "bbaA" is also a valid answer, but "Aabb" is incorrect.
        // Note that 'A' and 'a' are treated as two different characters.
        String s3 = "Aabb";
        System.out.println(scbf.frequencySort(s3));  // "bbAa" or "bbaA"

        // Input: s = "abcdefg"
        // Output: "gfedcba"
        // Explanation: "gfedcba" is the correct answer, because it's the longest word in the string.
        String s4 = "abcdefg";
        System.out.println(scbf.frequencySort(s4));  // "gfedcba" or any permutation thereof

        // Input: s = "333333"
        // Output: "333333"
        // Explanation: "333333" is the correct answer, because it's the longest word in the string.
        String s5 = "333333";
        System.out.println(scbf.frequencySort(s5));  // "333333" or any permutation thereof
    }

    /**
     * Given a string s, sort it in decreasing order based on the frequency of the
     * characters.
     *
     * The frequency of a character is the number of times it appears in the string.
     *
     * Preconditions:
     * - s.length >= 1.
     * - s consists of uppercase and lowercase English letters and digits.
     */
    public String frequencySort(String s) {
        // count the number of each character in a hashmap
        Map<Character, Integer> charactersToFrequencies = recordCharacterCounts(s);

        // put all characters in a max heap, sorted by frequency
        PriorityQueue<Character> maxHeap = new PriorityQueue<>(
            (a, b) -> charactersToFrequencies.get(b) - charactersToFrequencies.get(a)
        );
        maxHeap.addAll(charactersToFrequencies.keySet());

        // pop the top of the heap and append it to the result string
        return getSortedString(maxHeap, charactersToFrequencies);
    }

    /**
     * Return a count of every character in the string s.
     *
     * Preconditions:
     * - s.length >= 1.
     * - s consists of uppercase and lowercase English letters and digits.
     */
    private Map<Character, Integer> recordCharacterCounts(String s) {
        Map<Character, Integer> charactersToCounts = new HashMap<>();
        for (char letter : s.toCharArray()) {
            charactersToCounts.put(letter, charactersToCounts.getOrDefault(letter, 0) + 1);
        }
        return charactersToCounts;
    }

    /**
     * Return a string of characters in the max heap, sorted by frequency.
     *
     * Preconditions:
     * - maxHeap.size() >= 1.
     * - charactersToFrequencies.size() >= 1.
     * - charactersToFrequencies.keySet().containsAll(maxHeap).
     */
    private String getSortedString(PriorityQueue<Character> maxHeap,
                                   Map<Character, Integer> charactersToCounts) {
        StringBuilder sortedString = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            char mostFrequentCharacter = maxHeap.poll();
            int numberOfTimesCharacterAppears = charactersToCounts.get(mostFrequentCharacter);
            for (int i = 0; i < numberOfTimesCharacterAppears; i++) {
                sortedString.append(mostFrequentCharacter);
            }
        }
        return sortedString.toString();
    }
}
