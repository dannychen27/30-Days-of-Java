package JavaConcepts.Hard.Iterators;

import java.util.Iterator;
import java.util.LinkedList;

public class Iterators {

    public static void main(String[] args) {
        LinkedList<String> items = new LinkedList<>();
        items.add("1");
        items.add("2");
        items.add("3");

        Iterator<String> it = items.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        // TODO: ListIterator: listIterator()

        // TODO: Add a custom iterator for your own class
        // todo. e.g. binary search tree, fibonacci sequence, etc.

        // equivalent to:
        // for (String item : items) {
        //      System.out.println(item);
        // }
    }
}
