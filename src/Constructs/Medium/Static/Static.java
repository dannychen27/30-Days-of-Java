package Constructs.Medium.Static;

public class Static {

    // This is a static variable.
    private static int value = 6;

    // This is a static method.
    public static void main(String[] args) {
        // static means that the Java entity belongs to the whole class rather than a particular instance of an object.
        // a static class does not make sense, since it leads to a circular definition of "static":
        //      "a static class belongs to the whole class rather than a particular instance of an object"
        // a static method is a method that is applicable to the entire class rather than a particular instance of an object.
        //   e.g. main()
        // a static field is a field that is applicable to the entire class rather than a particular instance of an object.
        //   e.g. Math.PI, Math.E, etc.

        // instance
        // - must create new object to access instance variables and instances methods.
        A a = new A();
        a.speak(); // I am a static method.
        System.out.println(a.value); // 5

        // static
        // - no need to create a new object from scratch to access static variables and static methods.
        Static.speak(); // I am an instance method.
        System.out.println(Static.value); // 6
    }

    private static void speak() {
        System.out.println("I am a static method.");
    }
}

class A {

    // This is an instance variable.
    int value = 5;

    // This is an instance method.
    void speak() {
        System.out.println("I am an instance method.");
    }
}

// This class declaration is not allowed.
// public static class A {
//
// }
