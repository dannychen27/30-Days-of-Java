package JavaConstructs.Easy.ForEachLoops;

public class ForEachLoops {

    public static void main(String[] args) {
        // For each loops do not require knowing the index of each element, so
        // it is easier to read.

        String[] smoothies = {"strawberry", "chocolate", "avocado"};
        for (String smoothie : smoothies) {
            System.out.println(smoothie);  // strawberry, chocolate, avocado
        }
    }
}
