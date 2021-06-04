package Constructs.Easy.InstanceOf;

public class InstanceOf {

    public static void main(String[] args) {
        // - the instanceof keyword returns true iff class A is an instance of class B.
        // - a code smell for determining behaviour based on object -- replaceable with
        // polymorphism

        A a = new A();
        B b = new B();
        C c = new C();
        D d = new D();

        // all objects are instances of object
        // all objects are instances of themselves
        System.out.println(a instanceof Object); // true
        System.out.println(a instanceof A);

        // all objects are instances of their immediate parent class
        System.out.println(b instanceof A); // true
        System.out.println(c instanceof A); // true
        System.out.println(d instanceof B); // true

        // all objects are instances of their ancestor classes.
        System.out.println(d instanceof A); // true
    }
}

class A {

}

class B extends A {

}

class C extends A {

}

class D extends B {

}
