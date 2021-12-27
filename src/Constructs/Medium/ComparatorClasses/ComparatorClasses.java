package Constructs.Medium.ComparatorClasses;

import java.util.Comparator;
import java.util.PriorityQueue;

public class ComparatorClasses {

    public static void main(String[] args) {
        // sources:
        // - https://www.geeksforgeeks.org/comparator-interface-java/

        // - a comparator class allows you to impose a natural ordering on user-defined classes.
        // - useful when you want to sort objects in a user-defined class, since
        // Collections.sort(List list, ComparatorClass c) takes a Comparator class as one of its
        // arguments.
        // - The comparator class implements comparable interface in the java.util package.
        // It contains two methods:
        //      - REQUIRED: compare(Object obj1, Object obj2)
        //          return 1 if obj1 < obj2
        //          return 0 if obj1 == obj2
        //          return -1 if obj1 > obj2
        //      - OPTIONAL: equals(Object element)
        demonstrateComparatorClasses();
    }

    private static void demonstrateComparatorClasses() {
        PriorityQueue<Person> meetAndGreetLine2 = new PriorityQueue<>(10, new SortByYoungestFanFirst());
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
    }
}

class Person {

    private String fullName;
    int age;

    Person(String fullName, int age) {
        this.fullName = fullName;
        this.age = age;
    }

    public String toString() {
        return fullName + ", age " + age;
    }
}

class SortByYoungestFanFirst implements Comparator<Person> {

    @Override
    public int compare(Person person1, Person person2) {
        int person1Age = person1.age;
        int person2Age = person2.age;
        return Integer.compare(person1Age, person2Age);
    }
}

