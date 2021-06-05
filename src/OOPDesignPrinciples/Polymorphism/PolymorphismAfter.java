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
        // - Polymorphism relates classes with their subclasses by sharing the same methods, and adapting its behaviour
        // (in this case introduceSelf()) depending on the class used in the inheritance hierarchy.
        // - This lets us eliminate switch statements and if-else classes that perform code depending on which class
        // is calling it, which obeys the Open Closed Principle.
        // - TODO: objects determine their own behaviour! we don't to use a switch statement/if statements to figure out
        //  todo: what type this object is to then determine its behaviour

        // Here we declare subclasses of Person abstractly -- all of them as Persons.
        // Polymorphism lets us use the class to decide its own behaviour, rather than forcing us
        // decide the appropriate behaviour based on the presented class. This is also dependency injection????
        Person charliePuth = new Person();
        Person rossLynch = new Engineer();
        Person shawnMendes = new Physicist();

        // You could treat rossLynch like a Person, or an engineer....
        // but it's easier and more generalizable to address everyone as Person.

        // Person[] famousPeople = {charliePuth, rossLynch, shawnMendes}; is equivalent
        List<Person> famousPeople = Arrays.asList(charliePuth, rossLynch, shawnMendes);
        for (Person famousPerson : famousPeople) {
            famousPerson.introduceSelf();
        }
    }
}
