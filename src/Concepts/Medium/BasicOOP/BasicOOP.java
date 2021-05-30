package Concepts.Medium.BasicOOP;

public class BasicOOP {

    // - public is the access modifier
    // - static means this method belongs to the Diffuser, not to any instance of Diffuser,
    // which means you don't have to instantiate it
    // - void is the return type (we're simply printing text to stdout)
    // - main is a method that runs immediately when the program starts
    // - args is a parameter -- a variable (LHS of an assignment statement)
    public static void main(String[] args) {
        // Hello world is an argument -- a value (RHS of an assignment statement)
        System.out.println("Hello World!"); // Hello World

        // The "new" keyword allocates memory for a new Diffuser object.
        // objects describe and model real world things
        // Diffuser() is the constructor for the Diffuser class.
        // In this case it's the default constructor of Diffuser.
        //
        // Diffuser diffuser1 = new Diffuser();

        // One way to set attributes of a class is outside the class.
        // The problem is that objects and attributes can get disorganized over time as
        // the program grows.
        // It violates encapsulation (the ability of hiding the inner implementation details
        // to reduce programmer cognitive load).
        //
        // diffuser1.name = "Diffuser1";
        // diffuser1.isOn = false;
        // System.out.println(diffuser1.name); // Diffuser1
        // System.out.println(diffuser1.isOn); // false

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
