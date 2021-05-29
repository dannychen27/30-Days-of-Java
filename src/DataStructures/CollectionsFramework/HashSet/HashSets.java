package DataStructures.CollectionsFramework.HashSet;

import java.util.HashSet;

public class HashSets {

    public static void main(String[] args) {
        // - HashSets do not maintain duplicates or order!
        // - HashSets determines where objects are inserted using
        // the object's hashcode.
        // - average case O(1) for insert, delete, access
        // NOTE: if you want order, use treeSet instead
        // if you want duplicates, use arrayList or linkedList instead

        // creating a new hashset
        HashSet<String> words = new HashSet<>();

        // adding to a hashset
        words.add("hello");
        words.add("bye");
        words.add("hello");
        words.add("ice");
        System.out.println(words); // [ice, hello, bye]

        // check membership in hashset
        System.out.println(words.contains("hello")); // true
        System.out.println(words.contains("diffusers")); // false

        // get items in hashset
        System.out.println(words.isEmpty()); // false
        System.out.println(words.size()); // 3

        // traversing items in hashsets
        for (String word : words) {
            System.out.println(word);
            // ice
            // hello
            // bye
        }

        // mutate items in hashset
        HashSet<String> currentWords = (HashSet<String>) words.clone();
        System.out.println(currentWords); // [ice, hello, bye]

        // remove items from hashset
        words.remove("hello");
        System.out.println(words); // [ice, bye]
        words.clear();
        System.out.println(words); // []
    }
}
