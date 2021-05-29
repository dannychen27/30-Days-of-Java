package JavaConcepts.Hard.Generics;

import java.util.ArrayList;
import java.util.List;

public class Wildcards {

    public static void main(String[] args) {
        // If aPublicMethod were to have the signature
        // void aPublicMethod(ArrayList<? extends Person> peeps) ....
        ArrayList<Admin> admins = new ArrayList<>();
        Admin a = new Admin();
        admins.add(a);
        doSomething(admins); // JavaConcepts.Hard.Generics.Admin@3c1

        List<Person> people = (List<Person>)(List<?>)admins;
        doSomething(people); // JavaConcepts.Hard.Generics.Admin@3c1
    }

    // Casting is when you have type knowledge that
    // Java doesn't have.

    // The "? extends Person" part is a wildcard.
    static void doSomething(ArrayList<? extends Person> peeps) {
        for (Person p : peeps) {
            System.out.println(p);
        }
    }

    static void doSomething(List<Person> peeps) {
        for (Person p : peeps) {
            System.out.println(p);
        }
    }
}
