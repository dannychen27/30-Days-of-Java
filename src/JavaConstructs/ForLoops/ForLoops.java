package JavaConstructs.ForLoops;

public class ForLoops {

    public static void main(String[] args) {
        // Sometimes we want to know the index of each element, because we wish to
        // use it (e.g. traverse every other element.)

        String[] smoothies = {"strawberry", "chocolate", "avocado"};
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }

        for (int i = 0; i < smoothies.length; i += 2) {
            System.out.println(smoothies[i]);  // strawberry, avocado (every other smoothie)
        }
    }
}
