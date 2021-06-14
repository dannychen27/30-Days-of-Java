package Concepts.Hard.Coupling.HighCoupling;

public class ListAnimals {

    private Monkey monkey;
    private Lion lion;

    ListAnimals(Monkey newMonkey, Lion newLion) {
        monkey = newMonkey;
        lion = newLion;
    }

    public void displayAnimals() {
        System.out.println(monkey);
        System.out.println(lion);
    }
}
