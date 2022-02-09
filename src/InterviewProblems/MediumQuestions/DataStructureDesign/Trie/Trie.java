package InterviewProblems.MediumQuestions.DataStructureDesign.Trie;

public class Trie {

    TrieNode root;

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));  // true
        System.out.println(trie.search("app"));  // false
        System.out.println(trie.startsWith("app"));  // true
        trie.insert("app");
        System.out.println(trie.search("app"));  // true

        trie.delete("app");
        System.out.println(trie.search("app"));  // false
        System.out.println(trie.startsWith("app"));  // true

        trie.delete("apple");
        System.out.println(trie.search("apple"));  // false
        System.out.println(trie.startsWith("app"));  // false

        // Add words that are prefixes of each other, and then see if the
        // trie prunes child nodes whose letters don't form words.
        trie.insert("diffuser");
        System.out.println(trie.search("diffuser"));  // true
        System.out.println(trie.startsWith("diff"));  // true

        trie.insert("diffusers");
        System.out.println(trie.search("diffuser"));  // true
        System.out.println(trie.startsWith("diffuser"));  // true

        trie.delete("diffusers");
        System.out.println(trie.search("diffuser"));  // true
        System.out.println(trie.startsWith("diffuser"));  // true

        trie.delete("diffuser");
        System.out.println(trie.search("diffuser"));  // false
        System.out.println(trie.startsWith("diffuser"));  // false
    }

    /**
     * Create a new trie.
     */
    public Trie() {
        root = new TrieNode();
    }

    /**
     * Insert the given word into the trie.
     */
    public void insert(String word) {
        TrieNode currentNode = root;
        for (char c : word.toCharArray()) {
            if (!currentNode.children.containsKey(c)) {
                currentNode.children.put(c, new TrieNode(currentNode));
            }
            currentNode = currentNode.children.get(c);
        }
        currentNode.isEndOfWord = true;
    }

    /**
     * Delete the given word from the trie.
     */
    public void delete(String word) {
        TrieNode currentNode = root;
        for (char c : word.toCharArray()) {
            if (!currentNode.children.containsKey(c)) {
                return;  // this word does not exist in the trie
            }
            currentNode = currentNode.children.get(c);
        }
        pruneTrie(word, currentNode);
    }

    /**
     * Return true iff the word is in the trie.
     */
    public boolean search(String word) {
        TrieNode currentNode = root;
        for (char c : word.toCharArray()) {
            if (!currentNode.children.containsKey(c)) {
                return false;
            }
            currentNode = currentNode.children.get(c);
        }
        return currentNode.isEndOfWord;
    }

    /**
     * Return true iff the given prefix is in the trie.
     */
    public boolean startsWith(String prefix) {
        TrieNode currentNode = root;
        for (char c : prefix.toCharArray()) {
            if (!currentNode.children.containsKey(c)) {
                return false;
            }
            currentNode = currentNode.children.get(c);
        }
        return true;
    }

    /**
     * Delete any children nodes that are not part of any word.
     */
    private void pruneTrie(String word, TrieNode currentNode) {
        currentNode.isEndOfWord = false;
        String reversedWord = reversed(word);
        for (char c : reversedWord.toCharArray()) {
            if (currentNode.parent == null || currentNode.isEndOfWord) {
                break;
            }
            currentNode = currentNode.parent;
            currentNode.children.remove(c);
        }
    }

    /**
     * Return the given string, but with the letters reversed.
     */
    private String reversed(String word) {
        String reversedWord = "";
        for (char c : word.toCharArray()) {
            reversedWord = c + reversedWord;
        }
        return reversedWord;
    }
}
