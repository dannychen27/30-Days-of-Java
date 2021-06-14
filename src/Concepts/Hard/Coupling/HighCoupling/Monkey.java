package Concepts.Hard.Coupling.HighCoupling;

public class Monkey {

    private String name;

    Monkey(String newName) {
        name = newName;
    }

    public String toString() {
        return "Monkey named " + name;
    }
}
