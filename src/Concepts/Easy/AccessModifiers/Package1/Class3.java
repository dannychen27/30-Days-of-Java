package Concepts.Easy.AccessModifiers.Package1;

/**
 * A different class that is the same package subclass as the original class.
 */
public class Class3 extends Class1 {

    public static void main(String[] args) {
        Class1.publicMethod();
        Class1.protectedMethod();
        Class1.defaultMethod();
        // Class1.privateMethod();

        Class1 class1 = new Class1();
        System.out.println(class1.a);
        System.out.println(class1.b);
        System.out.println(class1.c);
        // System.out.println(class1.d);
    }
}
