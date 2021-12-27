package Constructs.Easy.IncrementAndDecrementOperators;

public class IncrementAndDecrementOperators {

    public static void main(String[] args) {
        // source: https://stackoverflow.com/questions/2371118/how-do-the-post-increment-i-and-pre-increment-i-operators-work-in-java
        demonstrateIncrementOperators();
        demonstrateDecrementOperators();
    }

    private static void demonstrateIncrementOperators() {
        // pre-increment (++a): increment expression before evaluating (using) it
        // temp = a;
        // a = a + 1;
        // return temp;

        // post-increment (a++): increment expression after evaluating (using) it
        // a = a + 1;
        // return a;

        int g = 10;
        // g is unchanged because we increment g in the background
        System.out.println("g is: " + g++); // g is 10
        // Now g is 11
        System.out.println("g is: " + g); // g is 11

        int h = 10;
        System.out.println("h is: " + ++h); // h is 11
    }

    private static void demonstrateDecrementOperators() {
        // pre-decrement (--a): decrement expression before evaluating (using) it
        // temp = a;
        // a = a - 1;
        // return temp;

        // post-increment (a--): decrement expression after evaluating (using) it
        // a = a - 1;
        // return a;

        int a = 10;
        // a is unchanged because we decrement a in the background
        System.out.println("a is: " + a--); // a is 10
        // Now a is 9
        System.out.println("a is: " + a); // a is 9

        int b = 10;
        System.out.println("b is: " + --b); // b is 9
    }
}
