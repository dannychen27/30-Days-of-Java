package Constructs.Hard.AbstractClasses;

public class AbstractClasses {

    public static void main(String[] args) {
        // an abstract class:
        //      - has at least one abstract method (a method with a missing implementation -- no body)
        //      - cannot be directed instantiated
        //      - sole purpose is to be subclassed, must override all abstract methods in subclasses,
        //      but can override all other non-abstract methods in the abstract class.
        User chord = new Person("Chord", "Overstreet");
        chord.sayHello(); // Hello, my name is Chord Overstreet.
    }
}

abstract class User {
    String firstName;
    String lastName;

    // You canoot declare abstract instance variables,
    // even if you do eventually initialize them.
    // abstract int x;

    // public abstract void sayHello() {} // this is not allowed
    User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public abstract void sayHello();
}

class Person extends User {

    Person(String firstName, String lastName) {
        super(firstName, lastName);
    }

    @Override
    public void sayHello() {
        System.out.println("Hello, my name is " + firstName + " " + lastName + ".");
    }
}