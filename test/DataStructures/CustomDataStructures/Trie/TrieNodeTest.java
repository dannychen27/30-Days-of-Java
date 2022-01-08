package DataStructures.CustomDataStructures.Trie;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TrieNodeTest {

    private TrieNode trieRoot;
    private final String[] wordsInTrie = {"car", "card", "cards", "cot", "cots", "trie", "tried", "tries", "try"};
    private final String[] wordsNotInTrie = {"carve", "crown"};

    @BeforeEach
    void setUp() {
        trieRoot = new TrieNode();
        for (String word : wordsInTrie) {
            trieRoot.add(word);
        }
    }

    @AfterEach
    void tearDown() {

    }

    // TODO: Implement the isEmpty() method.
    // TODO: Hint: Consider making TrieNode private, and wrapping it around a Trie class,
    // TODO: like the LinkedList class or the BinarySearchTree class.
    //
    // @Test
    // void testIsEmpty() {
    //
    // }

    @Test
    void testAdd() {
        trieRoot.add("diffuser");
        Assertions.assertTrue(trieRoot.search("diffuser"));

        trieRoot.add("cart");
        Assertions.assertTrue(trieRoot.search("cart"));
        Assertions.assertTrue(trieRoot.search("card"));
    }

    @Test
    void testCountWordsWithPrefixIfPrefixNotPartOfTrie() {
        Assertions.assertEquals(0, trieRoot.countNumWordsWithPrefix("dog"));
    }

    @Test
    void testCountWordsWithPrefixIfPrefixPartOfTrie() {
        Assertions.assertEquals(3, trieRoot.countNumWordsWithPrefix("car"));
    }

    @Test
    void testSearchIfWordNotInTrie() {
        for (String word : wordsNotInTrie) {
            Assertions.assertFalse(trieRoot.search(word));
        }
    }

    @Test
    void testSearchIfWordInTrie() {
        for (String word : wordsInTrie) {
            Assertions.assertTrue(trieRoot.search(word));
        }
    }

    // todo: implement the method getAllPrefixes()!
    // todo: print all prefixes of "trie" -- use DFS algorithm, base case where isCompletedWord == true
    // todo: System.out.println(root.getAllPrefixes("trie"));  // ["trie", "tries", "tried"]
    //
    // @Test
    // void testGetAllPrefixes() {
    //
    // }
}
