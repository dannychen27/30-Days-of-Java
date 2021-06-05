package Constructs.Hard.Interfaces;

public class Interfaces {

    public static void main(String[] args) {
        // sources:
        // - https://www.geeksforgeeks.org/interfaces-in-java/#:~:text=Why%20do%20we%20use%20interface,it%20can%20achieve%20multiple%20inheritance%20.&text=The%20reason%20is%2C%20abstract%20classes,are%20final%2C%20public%20and%20static.
        // - https://www.tutorialspoint.com/can-we-declare-an-interface-as-final-in-java#:~:text=Making%20an%20interface%20final.&text=If%20you%20make%20a%20method,final%20you%20cannot%20modify%20it.&text=If%20you%20make%20an%20interface,an%20interface%20final%20in%20Java.

        // - interfaces describe the required behaviour (methods) of its implementing classes
        // - by definition: "interface" -- how to work/interact with something, a common boundary
        // - interfaces express abilities and follow an ableness naming convention (e.g. Flyable, Readable, etc.).
        // - like abstract classes, interfaces cannot be instantiated. Only their subclasses/implementations can
        // be instantiated.
        // - a class can implement more than one interface
        // - purpose of interfaces is for abstract (loose coupling), and is a workaround for lack of multiple inheritance

        Smellable chocolateScent = new DiffuserScent();
        System.out.println(Smellable.isSmellable); // true
        System.out.println(chocolateScent.isSmellable); // true
    }
}

// source: https://www.tutorialspoint.com/how-to-access-the-fields-of-an-interface-in-java
interface Smellable {
    // all interface fields are public, final, and static by default
    boolean isSmellable = true;

    // all methods are public and abstract by default
    // void smell();
}

class DiffuserScent implements Smellable {

}

// Interfaces cannot be final.
// The purpose of interfaces is to enforce method implementations in other classes,
// and final takes away that ability.
// Doing so gives the error message: "Illegal combination of modifiers: interface and final"

// This is not allowed!
// final interface Animal {
//
// }