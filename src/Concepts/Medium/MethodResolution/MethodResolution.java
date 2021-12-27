package Concepts.Medium.MethodResolution;

public class MethodResolution extends A {

    public static void main(String[] args) {
        // Method resolution describes the order in which Java looks for a method in an inheritance hierarchy,
        // to determine which class method to call.
        // It starts from the current class, and if Jva can't find that method in the current class, Java will
        // proceed its way up the inheritance hierarchy until it either finds a superclass that has that method,
        // or reaches the root class without finding that method and throwing a method not found exception.
        demonstrateMethodResolution();
    }

    private static void demonstrateMethodResolution() {
        A a = new A();
        B b = new B();
        C c = new C();
        a.sing(); // Hey
        b.sing(); // Hey
        c.sing(); // Ahoy
    }
}

class A {

    void sing() {
        System.out.println("Hey");
    }
}

class B extends A {
    // class B doesn't have a sing() method, but class A does.
}

class C extends A {

    void sing() {
        System.out.println("Ahoy");
    }
}

