package Concepts.Hard.Coupling.HighCoupling;

public class Lion {

    private String name;

    Lion(String newName) {
        name = newName;
    }

    public String toString() {
        return "Lion named " + name;
    }
}
