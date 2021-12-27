package Concepts.Medium.PassByReferenceAndValue;

public class PassByValue {

    public static void main(String[] args) {
        // sources:
        // - https://www.infoworld.com/article/3512039/does-java-pass-by-reference-or-pass-by-value.html
        // - https://stackoverflow.com/questions/40480/is-java-pass-by-reference-or-pass-by-value/65460603#65460603
        // - https://stackoverflow.com/questions/40480/is-java-pass-by-reference-or-pass-by-value
        // - java is pass by value: it passes into its arguments the value of an object
        // rather than its memory address
        // - when you pass in objects, you're really passing in its object reference (which is
        // also pass by value) since object variables always point to the real object in the heap
        // (sort of like pass by reference in a way)

        // primitives are pass by value, so any changes to values we make are temporary.
        // and are discarded after the method terminates.
        Counter counter = new Counter();
        int x = 4;
        counter.increment(x);
        System.out.println(x); // 4
        counter.decrement(x);
        System.out.println(x); // 4
    }
}
