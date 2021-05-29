package JavaOtherTopics.DynamicProgramming;

import java.util.HashMap;

public class DynamicProgramming {

    public static void main(String[] args) {
        System.out.println("The 5th fibonacci number is " + fibonacci(5));
    }

    private static int fibonacci(int number) {
        return fibonacciHelper(number, new HashMap<>());
    }

    private static int fibonacciHelper(int number, HashMap<Integer, Integer> memo) {
        if (number <= 0) {
            return 0;
        } else if (number == 1) {
            return 1;
        } else if (!memo.keySet().contains(number)) {
            int newFibonacciNumber =
                    fibonacciHelper(number - 1, memo) +
                            fibonacciHelper(number - 2, memo);
            memo.put(number, newFibonacciNumber);
        }
        return memo.get(number);
    }
}
