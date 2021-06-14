package Concepts.Hard.Coupling.LowCoupling;

import java.util.ArrayList;

public class ListAnimals {

    private ArrayList<Animal> animals = new ArrayList<>();

    public void addAnimalToList(Animal newAnimal) {
        animals.add(newAnimal);
    }

    public void displayAnimals() {
        for (Animal animal : animals) {
            System.out.println(animal);
        }
    }
}
