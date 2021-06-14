package DataStructures.CollectionsFramework.PriorityQueues;

import java.util.PriorityQueue;

public class PriorityQueues {

    public static void main(String[] args) {
        // - priority queues are like regular queues, except they are in priority order
        // instead of chronological order.
        // - a queue is a special case of the priority queue where all of the priorities
        // are the same

        // - source: https://www.baeldung.com/java-comparator-comparable comparator function

        // - PriorityQueue is thread unsafe
        // - PriorityBlockingQueue is thread safe though

        // creating a new priority queue
        // - PriorityQueue also takes a comparator, which works if you want to order
        // items by an object field. (e.g. youngest to oldest fan)
        PriorityQueue<String> meetAndGreetLine = new PriorityQueue<>();

        // adding items to a priority queue
        meetAndGreetLine.add("Ross Lynch");
        meetAndGreetLine.add("Shawn Mendes");
        meetAndGreetLine.add("Grant Gustin");
        meetAndGreetLine.add("Nolan Gerard Funk");
        meetAndGreetLine.add("Darren Criss");
        // prints in alphabetical order.
        System.out.println(meetAndGreetLine); // [Darren Criss, Grant Gustin, Ross Lynch, Shawn Mendes, Nolan Gerard Funk]

        // check membership in priority queue
        System.out.println(meetAndGreetLine.isEmpty()); // false
        System.out.println(meetAndGreetLine.contains("Grant Gustin")); // true

        // get items from a priority queue
        System.out.println(meetAndGreetLine.size()); // 5
        System.out.println(meetAndGreetLine.peek()); // Darren Criss

        // traversing items in a priority queue
        for (String fan : meetAndGreetLine) {
            System.out.println(fan); // Darren Criss, Grant Gustin, Ross Lynch, Shawn Mendes, Nolan Gerard Funk
        }

        // mutate items in a priority queue

        // remove items from a priority queue
        System.out.println(meetAndGreetLine.poll()); // Darren Criss
        System.out.println(meetAndGreetLine.poll()); // Grant Gustin
        System.out.println(meetAndGreetLine.poll()); // Nolan Gerard Funk
        System.out.println(meetAndGreetLine.poll()); // Ross Lynch
        System.out.println(meetAndGreetLine.poll()); // Shawn Mendes
    }
}
