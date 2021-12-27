package Concepts.Hard.Coupling.LowCoupling;

public class Monkey extends Animal {

    private String name;

    Monkey(String newName) {
        super(newName);
        name = newName;
    }

    public String toString() {
        return "Monkey named " + name;
    }
}
