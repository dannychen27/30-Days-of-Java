package InterviewProblems.Hashmaps.DecodeTheMessage;

import java.util.HashMap;
import java.util.Map;

public class DecodeMessage {

    // Let m = the length of the key string
    // Let n = the length of the message string
    //
    // Time: O(m + n)
    // --> O(m) to construct the substitution table
    // --> O(n) to decode the message string using the substitution table
    // Space: O(1)
    // --> The substitution table we need to maintain contains at most 26 entries,
    // one for each letter of the English alphabet.

    public static void main(String[] args) {
        DecodeMessage decodeMessage = new DecodeMessage();

        // Input: key = "zyxwvutsrqponmlkjihgfedcba",
        // message = "zyxwvutsrqponmlkjihgfedcba"
        // Output: "abcdefghijklmnopqrstuvwxyz"
        String key1 = "zyxwvutsrqponmlkjihgfedcba";
        String message1 = "zyxwvutsrqponmlkjihgfedcba";
        String decodedMessage1 = decodeMessage.decodeMessage(key1, message1);
        System.out.println(decodedMessage1);  // abcdefghijklmnopqrstuvwxyz

        // Input: key = "the quick brown fox jumps over the lazy dog",
        // message = "vkbs bs t suepuv"
        // Output: "this is a secret"
        // Explanation: The diagram above shows the substitution table.
        // It is obtained by taking the first appearance of each letter in
        // "the quick brown fox jumps over the lazy dog".
        String key2 = "the quick brown fox jumps over the lazy dog";
        String message2 = "vkbs bs t suepuv";
        String decodedMessage2 = decodeMessage.decodeMessage(key2, message2);
        System.out.println(decodedMessage2);  // this is a secret

        // Input: key = "eljuxhpwnyrdgtqkviszcfmabo",
        // message = "zwx hnfx lqantp mnoeius ycgk vcnjrdb"
        // Output: "the five boxing wizards jump quickly"
        // Explanation: The diagram above shows the substitution table.
        // It is obtained by taking the first appearance of each letter in
        // "eljuxhpwnyrdgtqkviszcfmabo".
        String key3 = "eljuxhpwnyrdgtqkviszcfmabo";
        String message3 = "zwx hnfx lqantp mnoeius ycgk vcnjrdb";
        String decodedMessage3 = decodeMessage.decodeMessage(key3, message3);
        System.out.println(decodedMessage3);  // the five boxing wizards jump quickly
    }

    /**
     * You are given the strings key and message, which represent a cipher key and a
     * secret message, respectively. The steps to decode message are as follows:
     *
     * 1. Use the first appearance of all 26 lowercase English letters in key as
     * the order of the substitution table.
     * 2. Align the substitution table with the regular English alphabet.
     * 3. Each letter in message is then substituted using the table.
     * 4. Spaces ' ' are transformed to themselves.
     *
     * For example, given key = "happy boy" (actual key would have at least one
     * instance of each letter in the alphabet), we have the partial substitution
     * table of ('h' -> 'a', 'a' -> 'b', 'p' -> 'c', 'y' -> 'd', 'b' -> 'e', 'o' -> 'f').
     *
     * Return the decoded message.
     *
     * Preconditions:
     * - 26 <= key.length <= 2000.
     * - key consists of lowercase English letters and ' '.
     * - key contains every letter in the English alphabet ('a' to 'z') at least once.
     * - 1 <= message.length <= 2000.
     * - message consists of lowercase English letters and ' '.
     */
    public String decodeMessage(String key, String message) {
        Map<Character, Character> substitutionTable = getSubstitutionTable(key);
        return substituteLetters(message, substitutionTable);
    }

    private Map<Character, Character> getSubstitutionTable(String key) {
        Map<Character, Character> substitutionTable = new HashMap<>();
        char currentLetter = 'a';
        for (char originalLetter : key.toCharArray()) {
            if (originalLetter != ' ' && !substitutionTable.containsKey(originalLetter)) {
                // Use the first appearance of all 26 lowercase English letters
                // in key as the order of the substitution table.
                substitutionTable.put(originalLetter, currentLetter);
                currentLetter++;
            }
        }
        return substitutionTable;
    }

    private String substituteLetters(String message,
                                     Map<Character, Character> substitutionTable) {
        StringBuilder newString = new StringBuilder();
        for (char originalLetter : message.toCharArray()) {
            if (originalLetter != ' ') {
                char targetLetter = substitutionTable.get(originalLetter);
                newString.append(targetLetter);
            } else {  // originalLetter == ' '
                newString.append(' ');
            }
        }
        return newString.toString();
    }
}
