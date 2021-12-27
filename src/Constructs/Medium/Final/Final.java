package Constructs.Medium.Final;

public class Final {

    private final static int NUM_HOURS_IN_DAY = 24;

    void changeNumHoursInDay(int newNumHours) {
        // NUM_HOURS_IN_DAY = newNumHours;  // This variable cannot be changed!
    }

    // This method cannot be overridden!
    private final void sayHi() {
        System.out.println("Hello!");
    }

    // final has no effect on static methods, since subclasses of Final
    // can still call sayDiffuser() with this exact signature.
    final static void sayDiffuser() {
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
    //      System.out.println("Ahoy ahoy!");
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
