package Concepts.Medium.PassByReferenceAndValue;

public class PassByReference {

    public static void main(String[] args) {
        // Objects are essentially "pass by reference" where changes
        // persist across method calls.
        Counter counter = new Counter();
        System.out.println(counter.partners); // []
        Counter counter2 = new Counter();
        counter.addPartner(counter2);
        System.out.println(counter.partners); // [Concepts.Medium.PassByReferenceAndValue.Counter@77459877]
        counter.removePartner(counter2);
        System.out.println(counter.partners); // []
    }
}
