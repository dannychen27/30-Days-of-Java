package OtherTopics.Recursion;

public class Recursion {

    public static void main(String[] args) {
        System.out.println("The 5th fibonacci number is " + fibonacci(5));
    }

    private static int fibonacci(int number) {
        if (number <= 0) {
            return 0;
        } else if (number == 1) {
            return 1;
        } else {
            return fibonacci(number - 1) + fibonacci(number - 2);
        }
    }
}
