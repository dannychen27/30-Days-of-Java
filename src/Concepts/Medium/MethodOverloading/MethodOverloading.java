package Concepts.Medium.MethodOverloading;

import java.util.ArrayList;
import java.util.List;

public class MethodOverloading {

    public static void main(String[] args) {
        // - Method overloading is when you implement methods within the same class with the same function name,
        // same return type, but with different method signature (number or types of parameters).
        // e.g. System.out.println(int i), System.out.println(String s), System.out.println(List items), etc.
        // - Depending on the arguments passed in, Java will find the method with the exact method signature and
        // call that method, or throw a compile time error if it can't find that method:
        //          cannot resolve method
        // - Method overloading lets us use the same method name instead of using two different method names
        // that do the same thing.
        // - overloading achieves compile time polymorphism
        demonstrateMethodOverloading();

    }

    private static void demonstrateMethodOverloading() {
        // todo: what's the difference between method overloading and using generic parameters like T?
        A a = new A();
        a.emphasize(2); // 4
        a.emphasize("Ahoy"); // Ahoy Ahoy Ahoy

        List array = new ArrayList<String>();
        array.add("Hello");
        array.add("Funny");
        array.add("Goodbye");
        a.emphasize(array); // Hello (twice), Funny (twice), Goodbye (twice)
    }
}

class A {

    void emphasize(int num) {
        System.out.println(num * 2);
    }

    // This is not allowed, as it matches the method signature above.
    // void emphasize(int number) {
    //     System.out.println(num * 2);
    // }

    void emphasize(String message) {
        System.out.println(message + " " + message + " " + message);
    }

    void emphasize(List<Object> items) {
        for (Object item : items) {
            System.out.println(item + " " + item);
        }
    }
}
