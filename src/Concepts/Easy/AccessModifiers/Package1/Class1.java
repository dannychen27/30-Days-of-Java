package JavaConcepts.Easy.DeclarationAndInitialization.AccessModifiers.Package1;

// Access modifiers allow us to restrict/grant access to certain static/instance variables, methods, and classes:
// source 1: https://www.geeksforgeeks.org/access-modifiers-java/
// source 2: https://www.google.com/search?q=protected+class+java&source=lnms&tbm=isch&sa=X&ved=2ahUKEwjBx93wz-3wAhUUZc0KHTBZC98Q_AUoAXoECAEQAw&biw=990&bih=596#imgrc=uridaDfHKBo5DM

// - class
// - subclass
// - package

// 1. same class? (e.g. INSIDE of class A, inside same file, inside of package X)
// 2. different class? (e.g. OUTSIDE of class A, inside same file, inside of package X)

// 3. same package subclass? (e.g. classes A and B, where B EXTENDS A, INSIDE SAME package X)
// 4. different package subclass? (e.g. classes A and B, where B EXTENDS A, INSIDE DIFFERENT packages X and Y)

// 5. same package non-subclass? (e.g. classes A and B, where B DOESN'T EXTEND A, INSIDE SAME package X)
// 6. different package non-subclass? (e.g. classes A and B, where B DOESN'T EXTEND A, INSIDE DIFFERENT packages X and Y)

// private   -- same class only
// default   -- same class, same package subclass, same package non-subclass only (package private)
// protected -- same class, same package subclass, same package non-subclass, different package subclass only
// public    -- same class, same package subclass, same package non-subclass, different package subclass, different package non-subclass

// what about final, static, abstract, interface, transient, synchronized, volatile?
// source: https://www.w3schools.com/java/java_modifiers.asp
// final -- cannot change value (for variables), cannot override (for methods), cannot inherit (for classes)
// static -- the variable/method belongs to the class itself rather than its own instance.
// abstract -- a collection of methods you only intend to override in a subclass since abstract methods may have
// an empty body (i.e. abstract methods can have some code), since you cannot instantiate an abstract class
// interface -- a collection of methods whose bodies must be empty and you intend to implement
// transient -- (temporary) attributes and methods are skipped when serializing the object containing them
// synchronized -- synchronized block can only be accessed by one class at a time (basically the critical section)
// volatile -- the value of an attribute is not cached thread-locally, and is always read from the "main memory"

/**
 * The original class.
 */
public class Class1 {

    public int a = 1;
    protected int b = 2;
    int c = 3;
    private int d = 4;

    public static void main(String[] args) {
        Class1.publicMethod();
        Class1.protectedMethod();
        Class1.defaultMethod();
        Class1.privateMethod();

        Class1 class1 = new Class1();
        System.out.println(class1.a);
        System.out.println(class1.b);
        System.out.println(class1.c);
        System.out.println(class1.d);
    }

    public static void publicMethod() {
        System.out.println("I'm a public method from Class1!");
    }

    protected static void protectedMethod() {
        System.out.println("I'm a protected method from Class1!");
    }

    static void defaultMethod() {
        System.out.println("I'm a default method from Class1!");
    }

    private static void privateMethod() {
        System.out.println("I'm a private method from Class1!");
    }
}