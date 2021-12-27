package OOPDesignPrinciples.Polymorphism;

import java.util.Arrays;
import java.util.List;

public class PolymorphismBefore {

    public static void main(String[] args) {
        Person charliePuth = new Person();
        Engineer rossLynch = new Engineer();
        Physicist shawnMendes = new Physicist();

        // Declaring concrete subclasses of Persons doesn't make sense here!
        //
        // Engineer[] engineers = {charliePuth, rossLynch, shawnMendes}; // same with Physicist[] physicists = ...;
        // for (Engineer engineer : engineers) {  // same with for (Physicist physicist : physicists) { ... }
        //      engineer.introduceSelf();
        // }

        // The problem is that not all Physicists are Engineers, and vice versa. Since we're not taking advantage
        // of the fact that Engineers and Physicists are subclasses of Person, the best we can do is assume they're
        // Objects (since all classes are just Object), and we must check their types individually to determine which
        // introduction is appropriate.
        // This is not scalable because if you want to add lots of different Person subclasses,
        // you'd need to create one more if-branch for each new Person subclass.
        List<Object> strangers = Arrays.asList(charliePuth, rossLynch, shawnMendes);
        for (Object stranger : strangers) {
            if (stranger instanceof Engineer) {
                System.out.println("I am an engineer.");
            } else if (stranger instanceof Physicist) {
                System.out.println("I am a physicist.");
            } else {
                System.out.println("I am a person.");
            }
        }

        // Since we cannot iterate through all Engineers or Physicists separately, we must call their corresponding
        // methods individually since Engineers might have some methods Physicists don't, and vice versa.
        //
        // Equivalently we could have written:
        //
        // charliePuth.introduceSelf();
        // rossLynch.introduceSelf();
        // shawnMendes.introduceSelf();
    }
}
