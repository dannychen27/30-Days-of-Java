package DataStructures.CustomDataStructures.Trie;

public class Tries {

    public static void main(String[] args) {
        // source: https://www.youtube.com/watch?v=zIjfhVPRZCg&t=2s

        // - A trie is a tree data structure often used to store words.
        // - Each node stores a character in a word, and whether it represents the end of a word.
        // - A path from root to leaf represents one word, or part of a word.
        // - Allows fast lookup, insertion, and deletion -- assuming words are relatively short
        // - The average english word is about 4.7 characters long.
        // - Great for word validation problems, like in Scrabble or
        // part of a word checker in a word processor programming

        // - don't look up each prefix from the root, build on the past prefixes.
        // e.g. The word car: Start at C ... Is A a child of C? Is R a child of A?
        // - by keeping state within trie, returning node reference.

        // Words to store:
        // Car
        // Card
        // Cards
        // Cot
        // Cots
        // Trie
        // Tried
        // Tries
        // Try

        // Find words:
        // Cot
        // Tots
        // Cards
        // Tacks
        // Card
        // Sty
        // Tries

        // Or:
        // Find
        // Swift
        // Jackson
        // Crawford
        // Zuck
        // Khan
        // Gayle

        // in:
        // OMG I <3 Taylor Swift 4Ever!!!
        // I think I just saw Zuck
        // Loving the new Michael Jackson
        // Chris Gayle has best game #Cricket
        // Khan wins all the Bollywood awards
        // Breaking news hashtags show results
        // Why is no one reading my tweets?

        TrieNode root = new TrieNode();
        String[] words = {"car", "card", "cards", "cot", "cots", "trie", "tried", "tries", "try"};
        for (String word : words) {
            root.add(word);
        }

        // how many words with prefix "car"?
        System.out.println(root.countNumWordsWithPrefix("car")); // 3

        // does the word "car" exist in the trie?
        System.out.println(root.search("car"));  // true
        System.out.println(root.search("card"));  // true
        System.out.println(root.search("cards"));  // true
        System.out.println(root.search("cot"));  // true
        System.out.println(root.search("cots"));  // true
        System.out.println(root.search("trie"));  // true
        System.out.println(root.search("tried"));  // true
        System.out.println(root.search("tries"));  // true
        System.out.println(root.search("try"));  // true
        System.out.println(root.search("carve"));  // false
        System.out.println(root.search("crown"));  // false

        // print all prefixes of "trie" -- use DFS algorithm, base case where isCompletedWord == true
        // System.out.println(root.getAllPrefixes("trie"));  // ["trie", "tries", "tried"]
    }
}
