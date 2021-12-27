package Constructs.Easy.Continue;

public class Continue {

    public static void main(String[] args) {
        // print all even numbers that are a multiple of 3.
        for (int i = 0; i < 100; i++) {
            if (i % 2 != 0) {
                continue;
            }

            if (i % 3 != 0) {
                continue;
            }

            System.out.println(i);
        }
    }
}
