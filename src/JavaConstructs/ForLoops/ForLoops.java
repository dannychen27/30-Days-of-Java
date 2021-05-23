package JavaConstructs.ForLoops;

public class ForLoops {

    public static void main(String[] args) {
        String[] smoothies = {"strawberry", "chocolate", "avocado"};

        // for loops
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }

        for (int i = 0; i < smoothies.length; i += 2) {
            System.out.println(smoothies[i]);  // strawberry, avocado (every other smoothie)
        }

        // foreach loops
        for (String smoothie : smoothies) {
            System.out.println(smoothie);  // strawberry, chocolate, avocado
        }
    }
}
