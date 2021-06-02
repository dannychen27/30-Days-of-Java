package Concepts.Medium.MethodOverriding;

public class MethodOverriding {

    public static void main(String[] args) {
        // - Method overriding is when you replace an existing implementation of a method signature (same return type,
        // same method name, and same set of parameters) in a superclass method with a different implementation
        // inside a subclass method.
        // - Overriding lets you define behaviour specific to the child class that's different from a parent class.
        demonstratingMethodOverriding();
    }

    private static void demonstratingMethodOverriding() {
        // source: https://www.javatpoint.com/can-we-override-static-method-in-java#:~:text=Can%20we%20override%20a%20static,static%20binding%20at%20compile%20time.&text=If%20we%20call%20a%20static%20method%20by%20using%20the%20child,child%20class%20will%20be%20called.
        // todo: Can you override a static method?
        // no. static methods are bound at compile time
        // but overriding happens at run time.

        // todo: can you overload a static method?
        // yes, as long as both methods are static

        A a = new A();
        B b = new B();
        C c = new C();
        D d = new D();
        a.greet(); // Hello I'm A
        b.greet(); // Hello I'm B
        c.greet(); // Hello I'm C
        d.greet(); // Hello I'm A
    }
}

class A {

    void greet() {
        System.out.println("Hello I'm A");
    }
}

class B extends A {

    // Class B overrides A's greet() method.
    void greet() {
        System.out.println("Hello I'm B");
    }
}

class C extends A {

    // Class C overrides A's greet() method.
    void greet() {
        System.out.println("Hello I'm C");
    }
}

class D extends A {
    // Class D doesn't override A's greet() method.
}