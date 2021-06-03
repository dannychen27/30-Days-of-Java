package Concepts.Medium.ShallowCopyAndDeepCopy;

import java.util.Arrays;

public class ShallowCopyAndDeepCopy {

    public static void main(String[] args) {
        // sources:
        // https://www.geeksforgeeks.org/deep-shallow-lazy-copy-java-examples/

        // two kinds of object copying:
        // - shallow copy/reference copy
        //      - copy an existing object while preserving it + copy the reference variable pointing
        //      to the object (pointer to the object)
        //      - copies the main object's fields, but not the inner (composed) objects insofar as the
        //      original and copy share those inner objects
        //      - the two objects are dependent: modifying the copy modifies the original object also

        // - two ways to perform object copying: copy constructor or clone with clone() method.



        // - string and int are immutable, they cannot be modified after assignment, so it's safe to copy them.
        // - if there are only primitive types or immutable types, they are the same

        // - if an object has only primitive fields, then obviously we should go for shallow copy,
        // but if the object has references to other objects, then based on the requirement,
        // shallow copy or deep copy should be done.

        // - lazy copy - a combination of shallow copy and deep copy


        // - deep copy/object copy
        //      - create a separate copy the object itself + create a new reference variable
        //      - copies the main object and the inner objects so that they point to different memory locations
        //      - the two objects are independent: modifying the copy has no effect on the original object
    }
}

// shallow copy
class ShallowCopy {

    private int[] data;

    // makes a shallow copy of values
    public ShallowCopy(int[] values) {
        data = values;
    }

    public void showData() {
        System.out.println( Arrays.toString(data) );
    }
}

class UsesShallowCopy {

    public static void main(String[] args) {
        int[] vals = {3, 7, 9};
        ShallowCopy e = new ShallowCopy(vals);
        e.showData(); // [3, 7, 9]
        vals[0] = 13;
        e.showData(); // [13, 7, 9]
        System.out.println(Arrays.toString(vals)); // [13, 7, 9]

        // Very confusing, because we didn't
        // intentionally change anything about
        // the object e refers to.
    }
}

// deep copy
class DeepCopy {

    private int[] data;

    // altered to make a deep copy of values
    public DeepCopy(int[] values) {
        data = new int[values.length];
        for (int i = 0; i < data.length; i++) {
            data[i] = values[i];
        }
    }

    public void showData() {
        System.out.println(Arrays.toString(data));
    }
}

class UsesDeepCopy {

    public static void main(String[] args) {
        int[] vals = {3, 7, 9};
        DeepCopy e = new DeepCopy(vals);
        e.showData(); // [3, 7, 9]
        vals[0] = 13;
        e.showData(); // [3, 7, 9]
        System.out.println(Arrays.toString(vals)); // [13, 7, 9]

        // changes in array values will not be
        // shown in data values.
    }
}