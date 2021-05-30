package Constructs.Easy.ArithmeticOperators;

public class ArithmeticOperators {

    public static void main(String[] args) {
        // arithmetic operators in Java return either ints/longs or floats/doubles
        // + addition
        // - subtraction
        // * multiplication
        // / integer division, not float division like Python
        // % modulus, return the remainder after division

        System.out.println(15 + 4); // 19
        System.out.println(15 - 4); // 11
        System.out.println(15 * 4); // 60
        System.out.println(15 / 4); // 3
        System.out.println(15 % 4); // 3

        // % provides a clean way to "wrap around array indices"
        // let's try to wrap around this array 3 times.
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        cycleAround(numbers, 3);
    }

    private static void cycleAround(int[] numbers, int numCycles) {
        int i = 0;
        for (int j = 0; j < numCycles * numbers.length; j++) {
            System.out.println(numbers[i]);
            i = (i + 1) % 10;
        }
    }
}
