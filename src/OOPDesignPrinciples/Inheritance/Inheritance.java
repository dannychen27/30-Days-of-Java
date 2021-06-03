package OOPDesignPrinciples.Inheritance;

public class Inheritance {

    public static void main(String[] args) {
        // source: http://tutorials.jenkov.com/java/inheritance.html#:~:text=When%20a%20subclass%20extends%20a,are%20inherited%20by%20the%20subclass.&text=Fields%20and%20methods%20with%20default,same%20package%20as%20the%20superclass.

        // - Inheritance is the ability to create subclasses (aka derived methods) that reuse
        // code from a superclass.
        // - All public and protected fields can be inherited in java
        // - All public and protected methods can be inherited in java

        // todo: Facts about the abstract keyword
        // - Abstract methods and interfaces MUST inherit all methods in their subclasses/implementations!
        // - Abstract fields are not allowed in java

        // todo: Facts about the virtual keyword
        // - virtual methods let you override superclass methods in subclasses
        // - most subclass methods are virtual by default, except for:
        //      - static methods
        //      - private methods

        User rossLynch = new User("Ross", "Lynch");
        Student nolanFunk = new Student("Nolan", "Gould", "Kinesiology");
        rossLynch.speak();
        nolanFunk.speak();
    }
}

class User {
    String firstName;
    String lastName;

    User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    void speak() {
        System.out.println("I'm " + firstName + " " + lastName + ".");
    }
}


class Student extends User {
    // we inherit firstName and lastName from the User class
    private String collegeMajor;

    Student(String firstName, String lastName, String collegeMajor) {
        super(firstName, lastName);
        this.collegeMajor = collegeMajor;
    }

    // we can override our inherited speak() method from the User class.
    void speak() {
        System.out.println("I'm " + firstName + " " + lastName +
                           " and I study " + collegeMajor + ".");
    }
}
