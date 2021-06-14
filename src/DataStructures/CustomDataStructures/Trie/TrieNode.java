package DataStructures.CustomDataStructures.Trie;

import java.util.HashMap;

public class TrieNode {

    // Using an array is okay too, however a HashMap...
    // - takes up more memory
    // - but allows me to add as many TrieNodes as I want
    private HashMap<Character, TrieNode> children;
    private char value;
    private boolean isCompleteWord;
    private int size;

    TrieNode(char newCharacter) {
        children = new HashMap<>();
        value = newCharacter;
        isCompleteWord = false;
        size = 0;
    }

    /**
     * Insert this word into the trie.
     */
    public void insert(String newWord) {
        insertRecursive(newWord, 0);
    }

    /**
     * Return the number of words with this prefix.
     */
    public int countNumPrefixes(String prefix) {
        return countNumPrefixes(prefix, 0);
    }

    /**
     * Return the trie node corresponding to character c.
     *
     * Precondition: c is in the children hashmap.
     */
    private TrieNode getTrieNode(char character) {
        return children.get(character);
    }

    private void setTrieNode(char character, TrieNode trieNode) {
        children.put(character, trieNode);
    }

    private void insertRecursive(String newWord, int index) {
        size++;

        if (index == newWord.length()) {
            isCompleteWord = true;
            return;
        }

        char currentCharacter = newWord.charAt(index);
        TrieNode child = getTrieNode(currentCharacter);

        if (child == null) {
            child = new TrieNode(currentCharacter);
            setTrieNode(currentCharacter, child);
        }

        child.insertRecursive(newWord, index + 1);
    }

    private int countNumPrefixes(String prefix, int index) {
        if (index == prefix.length()) {
            return size;
        }

        TrieNode child = getTrieNode(prefix.charAt(index));

        if (child == null) {
            return 0;  // substring not found
        }

        return child.countNumPrefixes(prefix, index + 1);
    }
}
