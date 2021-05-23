package JavaDataStructures.ArrayList;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayLists {

    public static void main(String[] args) {
        // add items to arraylist
        ArrayList<String> array = new ArrayList<>();
        array.add("Hello");
        array.add(0, "L");
        array.add(2, "P");
        System.out.println(array);  // [L, Hello, P]

        ArrayList<String> array2 = new ArrayList<>();
        array2.add("Hello");
        System.out.println(array2);  // [Hello]

        ArrayList<String> clonedArray = (ArrayList<String>) array2.clone();
        System.out.println(clonedArray);  // [Hello]

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

        // sort items in arraylist
        Collections.sort(array);
        System.out.println(array);                      // [Helium, Hello, P]

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
