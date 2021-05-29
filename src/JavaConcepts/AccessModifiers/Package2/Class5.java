package JavaConcepts.AccessModifiers.Package2;

import JavaConcepts.AccessModifiers.Package1.*;

/**
 * A different class that is a different package subclass than another.
 */
public class Class5 extends Class1 {

    public static void main(String[] args) {
        Class1.publicMethod();
        Class1.protectedMethod();
        // Class1.defaultMethod();
        // Class1.privateMethod();

        Class1 class1 = new Class1();
        System.out.println(class1.a);
        // System.out.println(class1.b);
        // System.out.println(class1.c);
        // System.out.println(class1.d);
    }
}
