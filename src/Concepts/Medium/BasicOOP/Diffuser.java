package Concepts.Medium.BasicOOP;

// OOP lets us create classes (custom types)
// Diffuser is a class
// All code must belong inside the class
// An object is an instance of a class
// Every class extends Object
public class Diffuser {
    // name is an attribute
    // we can associate different variable names with different objects

    // We want to assign access modifiers based on the principle of least privilege:
    // only provide the least amount of access necessary for the object to do its job
    // properly.
    public String name;
    public boolean onStatus;

    // The default constructor is used if a more specific constructor
    // is not already defined.
    public Diffuser() { }

    // We can use the diffuser class as a template, think of it as
    // a diffuser maker that lets you create lots of diffuser objects
    public Diffuser(String name) {
        this.name = name;
        this.onStatus = false;
    }
}
