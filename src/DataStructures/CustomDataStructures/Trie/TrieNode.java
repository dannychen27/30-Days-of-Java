package DataStructures.CustomDataStructures.Trie;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {

    // Using an array is okay too, however a HashMap...
    // - takes up more memory
    // - but allows me to add as many TrieNodes as I want
    private Map<Character, TrieNode> children;
    private char letter;
    private boolean isCompleteWord;
    private int size;

    /**
     * Create a new trie.
     */
    TrieNode() {
        this(' ');  // no such thing as the empty character.
    }

    private TrieNode(char newLetter) {
        children = new HashMap<>();
        letter = newLetter;
        isCompleteWord = false;
        size = 0;
    }

    /**
     * Insert this word into the trie.
     */
    public void add(String newWord) {
        add(newWord, 0);
    }

    /**
     * Return the number of words with this prefix.
     */
    public int countNumWordsWithPrefix(String prefix) {
        return countNumWordsWithPrefix(prefix, 0);
    }

    }

    /**
     * Return the trie node corresponding to character c.
     *
     * Precondition: character is in the children hashmap.
     */
    private TrieNode getTrieNode(char character) {
        return children.get(character);
    }

    private void setTrieNode(char character, TrieNode trieNode) {
        children.put(character, trieNode);
    }

    private void add(String newWord, int index) {
        size++;

        if (index == newWord.length()) {
            isCompleteWord = true;
            return;
        }

        char nextCharacter = newWord.charAt(index);
        TrieNode childNode = getTrieNode(nextCharacter);

        if (childNode == null) {
            childNode = new TrieNode(nextCharacter);
            setTrieNode(nextCharacter, childNode);
        }

        childNode.add(newWord, index + 1);
    }

    private int countNumWordsWithPrefix(String prefix, int index) {
        if (index == prefix.length()) {
            return size;
        }

        char nextCharacter = prefix.charAt(index);
        TrieNode child = getTrieNode(nextCharacter);

        if (child == null) {
            return 0;  // substring not found
        }

        return child.countNumWordsWithPrefix(prefix, index + 1);
    }

    }
}
