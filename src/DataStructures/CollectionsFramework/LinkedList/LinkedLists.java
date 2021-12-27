package DataStructures.CollectionsFramework.LinkedList;

import java.util.LinkedList;

public class LinkedLists {

    public static void main(String[] args) {
        // add items to linkedlist
        LinkedList<Object> linkedList = new LinkedList<>();
        linkedList.addLast(4);
        linkedList.add(0, "Hello");
        linkedList.addFirst(5.0);

        // traversing through linkedlist
        // Iterator<Object> it = linkedList.iterator();
        // while (it.hasNext()) {
        //      System.out.println(it.next());
        // }

        // equivalently:
        for (Object obj : linkedList) {
            System.out.println(obj);   // 5.0, Hello, 4
        }

        // get items from linkedlist
        System.out.println(linkedList.peek());      // 5.0
        System.out.println(linkedList.peekFirst()); // 5.0
        System.out.println(linkedList.peekLast());  // 4

        System.out.println(linkedList.getFirst());  // 5.0
        System.out.println(linkedList.get(1));      // Hello
        System.out.println(linkedList.getLast());   // 4

        // remove items from linkedlist
        System.out.println(linkedList.poll());      // 5.0
        System.out.println(linkedList.pollFirst()); // Hello
        System.out.println(linkedList.pollLast());  // 4
        System.out.println(linkedList.isEmpty());   // true
    }
}
