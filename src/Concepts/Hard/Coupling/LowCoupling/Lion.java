package Concepts.Hard.Coupling.LowCoupling;

public class Lion extends Animal {

    private String name;

    Lion(String newName) {
        super(newName);
        name = newName;
    }

    public String toString() {
        return "Lion named " + name;
    }
}