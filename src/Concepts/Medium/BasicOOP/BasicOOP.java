package Concepts.Medium.BasicOOP;

public class BasicOOP {

    // class = a custom type -- a blueprint for creating objects, a summary of a group of related variables, methods, etc.
    // object = an instance of a class -- what you instantiate using the constructor
    // objects describe and model real world things
    // field/attribute = a variable inside of a class that describe an object's state
    // method = actions your objects can perform, or exhibit behaviour

    // constructor = a method used to initialize objects

    // identifier = something that identifies an object
    // e.g. int x <-- x is the identifier.

    // - public is the access modifier -- this describes an identifier's privileges, which classes and fields have access to it
    // - static means this method belongs to the Diffuser, not to any instance of Diffuser,
    // which means you don't have to instantiate it
    // - void is the return type (we're simply printing text to stdout)
    // - main is a method that runs immediately when the program starts
    // - args is a parameter -- a variable (LHS of an assignment statement)
    public static void main(String[] args) {
        // Hello world is an argument -- a value (RHS of an assignment statement)
        System.out.println("Hello World!"); // Hello World
        demonstrateConstructor();
        demonstrateNoEncapsulation();
        demonstrateEncapsulation();
    }

    private static void demonstrateConstructor() {
        // The "new" keyword allocates memory for a new Diffuser object.
        // Diffuser() is the constructor for the Diffuser class.
        // In this case it's the default constructor of Diffuser, and all objects have a default constructor
        // inherited from class Object.
        // Printing out the object itself returns its memory address.
        Diffuser diffuser1 = new Diffuser();
        System.out.println(diffuser1); // Concepts.Medium.BasicOOP.Diffuser@77459877
    }

    private static void demonstrateNoEncapsulation() {
        // One way to set attributes of a class is outside the class.
        // The problem is that objects and attributes can get disorganized over time as
        // the program grows.
        // It violates encapsulation (the ability of hiding the inner implementation details
        // to reduce programmer cognitive load).
        Diffuser diffuser1 = new Diffuser();
        diffuser1.name = "Diffuser1";
        diffuser1.onStatus = false;
        System.out.println(diffuser1.name); // Diffuser1
        System.out.println(diffuser1.onStatus); // false
    }

    private static void demonstrateEncapsulation() {
        // Alternatively we could write:
        Diffuser diffuser2 = new Diffuser("Diffuser2");
        diffuser2.setOn(true);
        diffuser2.setName("Diffuser2Updated");
        System.out.println(diffuser2.getOnStatus()); // true
        System.out.println(diffuser2.getName()); // Diffuser2Updated

        Diffuser diffuser3 = new Diffuser("Diffuser3");
        diffuser3.setOn(false);
        diffuser3.setName("Diffuser3Updated");
        System.out.println(diffuser3.getOnStatus()); // false
        System.out.println(diffuser3.getName()); // Diffuser3Updated
    }
}
