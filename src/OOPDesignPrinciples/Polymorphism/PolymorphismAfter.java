package OOPDesignPrinciples.Polymorphism;

import java.util.Arrays;
import java.util.List;

class Person {
    public void introduceSelf() {
        System.out.println("I am a person.");
    }
}

class Engineer extends Person {
    public void introduceSelf() {
        System.out.println("I am an engineer.");
    }
}

class Physicist extends Person {
    public void introduceSelf() {
        System.out.println("I am a physicist.");
    }
}

public class PolymorphismAfter {
    public static void main(String[] args) {
        // Source: https://www.w3schools.com/java/java_polymorphism.asp
        // - Polymorphism lets us reuse attributes and methods of an existing class when you create a new class.
        // - Polymorphism relates classes with their subclasses by sharing the same methods, and perform a single action
        // (in this case introduceSelf()) in different ways depending on the subclass.
        // - This lets us eliminate switch statements and if-else classes that perform code depending on which class
        // is calling it, which obeys the Open Closed Principle.

        // Here we declare subclasses of Person abstractly -- all of them as Persons.
        // Polymorphism lets us use the class to decide its own behaviour, rather than forcing us
        // decide the appropriate behaviour based on the presented class. This is also dependency injection????
        Person charliePuth = new Person();
        Person rossLynch = new Engineer();
        Person shawnMendes = new Physicist();

        // Person[] famousPeople = {charliePuth, rossLynch, shawnMendes}; is equivalent
        List<Person> famousPeople = Arrays.asList(charliePuth, rossLynch, shawnMendes);
        for (Person famousPerson : famousPeople) {
            famousPerson.introduceSelf();
        }
    }
}
