package Concepts.Hard.Coupling.HighCoupling;

public class HighCoupling {

    public static void main(String[] args) {
        // source:
        // - https://www.youtube.com/watch?v=9Y2mZger8kE&list=PLGLfVvz_LVvS5P7khyR4xDp7T9lCk9PgE&index=10
        // coupling code example only, no cohesion code example

        // - coupling = how much a class depends on another class.
        // - high coupling between classes = a change in one class may
        // result in major changes to the other coupled classes.
        // - low coupling between classes = a change in one class will result in (at most)
        // negligible changes to the other coupled classes.

        Monkey monkey = new Monkey("Max");
        Lion lion = new Lion("Tom");
        ListAnimals listAnimals = new ListAnimals(monkey, lion);
        listAnimals.displayAnimals();
        // What happens if I add a reptile?
        // - (aside) I'd need to create a new reptile class
        // - we'd have to modify the ListAnimals constructor (add more parameters).
        // - we'd have to print reptile in ListAnimals.displayAnimals() as well.

        // - cohesion = how well the methods in a class belong together (strongly-related functionality)
        // - high cohesion = a set of closely related methods in a class
        // - low cohesion = a set of loosely related methods in a class.
        // - high cohesion = adheres to single responsibility principle.
    }
}
