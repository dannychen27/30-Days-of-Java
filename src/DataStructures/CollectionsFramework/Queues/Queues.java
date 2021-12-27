package DataStructures.CollectionsFramework.Queues;

import java.util.LinkedList;
import java.util.Queue;

public class Queues {

    public static void main(String[] args) {
        // creating a new queue
        // no such thing as a queue implementation in java
        // because it's an interface (cannot directly instantiate).
        Queue<String> meetAndGreetLine = new LinkedList<>();

        // adding items to a queue
        meetAndGreetLine.add("Ross Lynch");
        meetAndGreetLine.add("Shawn Mendes");
        meetAndGreetLine.add("Nolan Gerard Funk");
        System.out.println(meetAndGreetLine); // [Ross Lynch, Shawn Mendes, Nolan Gerard Funk]

        // check membership in queue
        System.out.println(meetAndGreetLine.isEmpty()); // false
        System.out.println(meetAndGreetLine.contains("Shawn Mendes")); // true

        // get items from a queue
        System.out.println(meetAndGreetLine.peek()); // Ross Lynch
        System.out.println(meetAndGreetLine.size()); // 3

        // traversing items in a queue
        for (String fan : meetAndGreetLine) {
            System.out.println(fan); // Ross Lynch, Shawn Mendes, Nolan Gerard Funk
        }

        // mutate items in a queue

        // special methods
        System.out.println(meetAndGreetLine.toArray()[1]); // Shawn Mendes

        // remove items from a queue
        System.out.println(meetAndGreetLine.poll()); // Ross Lynch
        System.out.println(meetAndGreetLine); // [Shawn Mendes, Nolan Gerard Funk]
        System.out.println(meetAndGreetLine.poll()); // Shawn Mendes
        System.out.println(meetAndGreetLine); // [Nolan Gerard Funk]
        System.out.println(meetAndGreetLine.poll()); // Nolan Gerard Funk
        System.out.println(meetAndGreetLine); // []
    }
}
