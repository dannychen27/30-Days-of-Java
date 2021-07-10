package InterviewProblems.Miscellaneous;

public class FizzFuzzConverter {

    /**
     * Write a program that prints the numbers from 1 to 100.
     * But for multiples of 3, print "Fizz" instead of the number;
     * for multiples of 5, print "Fuzz" instead of the number;
     * and for multiples and 3 and 5, print "FizzFuzz" instead of the number.
     *
     * For example,
     *
     * 1 => "1"
     * 2 => "2"
     * 3 => "Fizz"
     * 4 => "4"
     * 5 => "Fuzz"
     * 6 => "Fizz"
     * 7 => "7"
     * 8 => "8"
     * 9 => "Fizz"
     * 10 => "Fuzz"
     * 11 => "11"
     * 12 => "Fizz"
     * 13 => "13"
     * 14 => "14"
     * 15 => "FizzFuzz"
     * 16 => "16"
     * ...
     */
    public static String fizzFuzz(int number) {
        if (number % 15 == 0) {
            return "FizzFuzz";
        } else if (number % 3 == 0) {
            return "Fizz";
        } else if (number % 5 == 0) {
            return "Fuzz";
        } else {
            return String.valueOf(number);
        }
    }

    public static void main(String[] args) {
        for (int number = 1; number <= 100; number++) {
            System.out.println(FizzFuzzConverter.fizzFuzz(number));
        }
    }
}
