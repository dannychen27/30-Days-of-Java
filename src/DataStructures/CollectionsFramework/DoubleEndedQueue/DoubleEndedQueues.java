package DataStructures.CollectionsFramework.DoubleEndedQueue;

import java.util.ArrayDeque;
import java.util.Deque;

public class DoubleEndedQueues {

    public static void main(String[] args) {
        // deque (pronounced deck) = double ended queue
        // - can use deque like a stack (push, pop) and a queue (enqueue, dequeue),
        // where you can add/remove elements from either the beginning or
        // end of a deque

        // creating a new double-ended queue
        Deque<String> meetAndGreetLine = new ArrayDeque<>(); // Deque is an interface.

        // adding items to a double-ended queue
        meetAndGreetLine.offerLast("Ross Lynch"); // add to back of deque
        meetAndGreetLine.offerLast("Shawn Mendes");
        meetAndGreetLine.offerFirst("Grant Gustin"); // add to front of deque
        meetAndGreetLine.offerFirst("Nolan Gerard Funk");
        meetAndGreetLine.offer("Darren Criss");
        System.out.println(meetAndGreetLine); // [Nolan Gerard Funk, Grant Gustin, Ross Lynch, Shawn Mendes, Darren Criss]

        // check membership in double-ended queue
        System.out.println(meetAndGreetLine.isEmpty()); // false
        System.out.println(meetAndGreetLine.contains("Grant Gustin")); // true

        // get items from a double-ended queue
        System.out.println(meetAndGreetLine.size()); // 5
        System.out.println(meetAndGreetLine.peek()); // Nolan Gerard Funk
        System.out.println(meetAndGreetLine.peekFirst()); // Nolan Gerard Funk
        System.out.println(meetAndGreetLine.peekLast()); // Darren Criss

        // traversing items in a double-ended queue
        for (String fan : meetAndGreetLine) {
            System.out.println(fan); // Nolan Gerard Funk, Grant Gustin, Ross Lynch, Shawn Mendes, Darren Criss
        }

        // mutate items in a double-ended queue

        // remove items from a double-ended queue
        System.out.println(meetAndGreetLine.pollLast()); // Darren Criss
        System.out.println(meetAndGreetLine.pollLast()); // Shawn Mendes
        System.out.println(meetAndGreetLine.pollFirst()); // Nolan Gerard Funk
        System.out.println(meetAndGreetLine.pollFirst()); // Grant Gustin
        System.out.println(meetAndGreetLine.poll()); // Ross Lynch
    }
}
