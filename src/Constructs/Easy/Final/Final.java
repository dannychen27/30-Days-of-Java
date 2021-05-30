package Constructs.Easy.Final;

public class Final {

    final static int NUM_HOURS_IN_DAY = 24;

    void changeNumHoursInDay(int newNumHours) {
        // NUM_HOURS_IN_DAY = newNumHours;  // This variable cannot be changed!
    }

    // This method cannot be overridden!
    public final void sayHi() {
        System.out.println("Hello!");
    }

    // final has no effect on static methods, since subclasses of Final
    // can still call sayDiffuser() with this exact signature.
    public final static void sayDiffuser() {
        System.out.println("Diffuser");
    }

    public static void main(String[] args) {
        // final Java entities cannot be changed after initialization:
        // - final variables cannot be changed
        // - final methods cannot be overridden
        // - final classes cannot be subclassed
        // attempting to change a final variable results in a compilation error.
        // final variables are capitalized by convention (for readability)
        Final f = new Final();
        f.sayHi(); // Hello!
        System.out.println(Final.NUM_HOURS_IN_DAY); // 24
    }
}

// This class cannot be subclassed!
final class NewFinal extends Final {

    // This method is not allowed!
    // void sayHi() {
        // System.out.println("Ahoy ahoy!");
    // }

    public static void main(String[] args) {
        sayDiffuser(); // Diffuser
    }
}

// This class is not allowed!
// class AnotherClass extends NewFinal {
//
//    public static void main(String[] args) {
//
//    }
// }

// Interfaces cannot be final.
// The purpose of interfaces is to implement methods in other classes,
// and final takes away the ability to implement.
// Doing so gives the error message: "Illegal combination of modifiers: interface and final"
//
// Source: https://www.tutorialspoint.com/can-we-declare-an-interface-as-final-in-java#:~:text=Making%20an%20interface%20final.&text=If%20you%20make%20a%20method,final%20you%20cannot%20modify%20it.&text=If%20you%20make%20an%20interface,an%20interface%20final%20in%20Java.

// Purpose of interfaces is for abstract (loose coupling), and is a workaround for lack of multiple inheritance
// Interfaces express abilities and follow an ableness naming convention (e.g. Flyable, Readable, etc.).
// Like abstract classes, interfaces cannot be instantiated. Only their subclasses/implementations can be instantiated.
//
// Source: https://www.geeksforgeeks.org/interfaces-in-java/#:~:text=Why%20do%20we%20use%20interface,it%20can%20achieve%20multiple%20inheritance%20.&text=The%20reason%20is%2C%20abstract%20classes,are%20final%2C%20public%20and%20static.


// final interface Animal {
//
// }


// source: https://www.tutorialspoint.com/how-to-access-the-fields-of-an-interface-in-java
interface Smellable {
    boolean isSmellable = true; // all interface fields are public, final, and static by default

    // all methods are public and abstract by default
    // void smell();
}

class ChocolateScent implements Smellable {

    public static void main(String[] args) {
        System.out.println(Smellable.isSmellable); // true
        System.out.println(isSmellable); // true
    }
}
