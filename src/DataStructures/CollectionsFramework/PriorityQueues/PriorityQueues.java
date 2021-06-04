package DataStructures.CollectionsFramework.PriorityQueues;

import java.util.Comparator;
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
        PriorityQueue<Person> meetAndGreetLine2 = new PriorityQueue<>(10, new PersonComparator());

        // adding items to a priority queue
        meetAndGreetLine.add("Ross Lynch");
        meetAndGreetLine.add("Shawn Mendes");
        meetAndGreetLine.add("Grant Gustin");
        meetAndGreetLine.add("Nolan Gerard Funk");
        meetAndGreetLine.add("Darren Criss");
        // prints in alphabetical order.
        System.out.println(meetAndGreetLine); // [Darren Criss, Grant Gustin, Ross Lynch, Shawn Mendes, Nolan Gerard Funk]

        meetAndGreetLine2.add(new Person("Ross Lynch", 25));
        meetAndGreetLine2.add(new Person("Shawn Mendes", 24));
        meetAndGreetLine2.add(new Person("Grant Gustin", 23));
        meetAndGreetLine2.add(new Person("Nolan Gerard Funk", 22));
        meetAndGreetLine2.add(new Person("Darren Criss", 21));
        for (Person fan : meetAndGreetLine2) {
            System.out.println(fan);
            // Darren Criss, age 21
            // Nolan Gerard Funk, age 22
            // Shawn Mendes, age 24
            // Ross Lynch, age 25
            // Grant Gustin, age 23
        }

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

class Person {

    String fullName;
    int age;

    Person(String fullName, int age) {
        this.fullName = fullName;
        this.age = age;
    }

    public String toString() {
        return fullName + ", age " + age;
    }
}

class PersonComparator implements Comparator<Person> {

    @Override
    public int compare(Person person1, Person person2) {
        int person1Age = person1.age;
        int person2Age = person2.age;
        return Integer.compare(person1Age, person2Age);
    }
}