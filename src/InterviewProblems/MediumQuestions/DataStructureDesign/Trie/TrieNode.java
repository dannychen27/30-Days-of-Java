package InterviewProblems.MediumQuestions.DataStructureDesign.Trie;

import java.util.HashMap;
import java.util.Map;

class TrieNode {

    TrieNode parent;
    Map<Character, TrieNode> children;
    boolean isEndOfWord;

    public TrieNode() {
        parent = null;
        children = new HashMap<>();
        isEndOfWord = false;
    }

    public TrieNode(TrieNode parent) {
        this.parent = parent;
        children = new HashMap<>();
        isEndOfWord = false;
    }
}
