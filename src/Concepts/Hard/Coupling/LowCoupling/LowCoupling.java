package Concepts.Hard.Coupling.LowCoupling;

public class LowCoupling {

    public static void main(String[] args) {
        // - Noticed we used polymorphism to achieve low coupling.
        // - The output is the same as the high coupled code.

        // - I can add a new subclass of Animal, like
        // class Reptile and this means:
        // - I'd only have to create the Reptile class
        // which is a subclass of Animal
        // - neither the listAnimals constructor nor its
        // displayAnimals() method needs to change.

        Animal monkey = new Monkey("Max");
        Animal lion = new Lion("Tom");
        ListAnimals listAnimals = new ListAnimals();
        listAnimals.addAnimalToList(monkey);
        listAnimals.addAnimalToList(lion);
        listAnimals.displayAnimals();

        // dependency = a class depends on another if it uses it
        // association = a class is associated with another class
        // composition (has-a) = a class contains an instance of another class
        // inheritance (is-a)= a class is a subclass of another class
    }
}
