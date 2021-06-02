package DataStructures.CollectionsFramework.ArrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ArrayLists {

    public static void main(String[] args) {
        // - An ArrayList is a dynamically resizable array
        // - Similar to a C++ vector

        // add items to ArrayList
        List<String> array = new ArrayList<>(); // we're using the List interface to achieve abstraction
        array.add("Hello");
        array.add(0, "L");
        array.add(2, "P");
        System.out.println(array);  // [L, Hello, P]

        ArrayList<String> array2 = new ArrayList<>();
        array2.add("Hello");
        System.out.println(array2);  // [Hello]

        ArrayList<String> clonedArray = (ArrayList<String>) array2.clone();
        System.out.println(clonedArray);  // [Hello]

        List<Integer> scores = Arrays.asList(5, 4, 3, 2, 1);
        System.out.println(scores); // [5, 4, 3, 2, 1]
        // TODO: - Arrays.parallelSort()
        // TODO: - Arrays.equals()
        // TODO: - Arrays.deepEquals() <- for nested arrays
        // TODO: - Arrays.fill() <- replace all entries in array with specified value

        // check membership in arraylist
        System.out.println(array.isEmpty());            // false
        System.out.println(array.contains("Hello"));    // true
        System.out.println(array2.equals(clonedArray)); // true, (value equality)

        // get items from arraylist
        System.out.println(array.get(0));   // L
        System.out.println(array.size());   // 3

        // set items in arraylist
        System.out.println(array.set(0, "Helium"));     // L (return old item)
        System.out.println(array);                      // [Helium, Hello, P]

        // traversing an arraylist
        for (String s : array) {
            System.out.println(s);   // Helium, Hello, P
        }

        // search for items in an arraylist
        System.out.println(array.indexOf("Hello")); // 1
        System.out.println(array.indexOf("Goodbye")); // -1

        // sort items in arraylist
        Arrays.sort(array.toArray());
        System.out.println(array);  // [Helium, Hello, P]
        scores.sort(Comparator.naturalOrder());
        System.out.println(scores); // [1, 2, 3, 4, 5]

        // remove items from arraylist
        System.out.println(array.remove("Helium"));  // true
        System.out.println(array.remove(1));      // P
        System.out.println(array);                       // [Hello]
        array2.clear();
        System.out.println(array2); // []

        // Q1: What kind of side effect does ArrayList.clone() produce? Is there a corresponding method
        // that produces a deep copy?
        //
        // (clone creates a shallow copy) <- copy by reference, changes to copy reflected in new object
        // ( ... creates a deep copy) <- copy by value, changes to copy not reflected in new object
    }
}
