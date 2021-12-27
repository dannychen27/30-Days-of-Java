package Concepts.Hard.Coupling.LowCoupling;

public class Animal {

    private String name;

    Animal(String newName) {
        name = newName;
    }

    public String toString() {
        return "Animal named " + name;
    }
}
