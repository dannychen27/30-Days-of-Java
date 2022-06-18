package InterviewProblems.Strings.ThousandSeparator.StringBuilderPrepend;

public class ThousandSeparator {

    // Let n = the number of digits of n.
    //
    // Time: O(n)
    // --> There are n while loop iterations since we eliminate the last digit of n each iteration.
    // --> The while loop body runs in constant time because we're prepending characters to a string
    // using a string builder.
    // --> Since prepending digits to the thousands-separated digit string places the digits in the correct
    // order, we don't have the reverse any of the digits in the thousands-separated digit string.
    // Space: O(1)
    // --> For this problem, integers can only span the closed interval [0, 2 ^ 31 - 1], so the
    // thousand-separated digit string can only contain at most 10 digits, since 2 ^ 31 - 1 = 2,147,483,647.

    public static void main(String[] args) {
        ThousandSeparator thousandSeparator = new ThousandSeparator();

        // Input: n = 0
        // Output: "0"
        String thousandSeparatedDigits0 = thousandSeparator.thousandSeparator(0);
        System.out.println(thousandSeparatedDigits0);  // 0

        // Input: n = 1
        // Output: "1"
        String thousandSeparatedDigits00 = thousandSeparator.thousandSeparator(1);
        System.out.println(thousandSeparatedDigits00);  // 1

        // Input: n = 10
        // Output: "10"
        String thousandSeparatedDigits000 = thousandSeparator.thousandSeparator(10);
        System.out.println(thousandSeparatedDigits000);  // 10

        // Input: n = 987
        // Output: "987"
        String thousandSeparatedDigits1 = thousandSeparator.thousandSeparator(987);
        System.out.println(thousandSeparatedDigits1);  // 987

        // Input: n = 1234
        // Output: "1.234"
        String thousandSeparatedDigits2 = thousandSeparator.thousandSeparator(1234);
        System.out.println(thousandSeparatedDigits2);  // 1.234

        // Input: n = 123456789
        // Output: 123.456.789
        String thousandSeparatedDigits3 = thousandSeparator.thousandSeparator(123456789);
        System.out.println(thousandSeparatedDigits3);  // 123.456.789
    }

    /**
     * Given an integer n, add a dot (".") as the thousands separator and return it in string format.
     *
     * Constraints:
     * - 0 <= n <= 2 ^ 31 - 1.
     */
    public String thousandSeparator(int n) {
        if (n == 0) {
            return "0";
        }

        StringBuilder thousandSeparatedNumber = new StringBuilder();
        int numDigitsSeen = 0;
        while (n >= 1) {
            int currentDigit = n % 10;
            thousandSeparatedNumber.insert(0, currentDigit);

            // Add a "." after every third digit seen except for the last group
            // of 3 digits, starting from the right of the number n.
            if ((numDigitsSeen + 1) % 3 == 0 && n >= 10) {
                thousandSeparatedNumber.insert(0, ".");
            }

            numDigitsSeen++;
            n /= 10;
        }
        return thousandSeparatedNumber.toString();
    }
}
