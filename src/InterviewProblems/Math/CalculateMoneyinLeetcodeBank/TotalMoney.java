package InterviewProblems.Math.CalculateMoneyinLeetcodeBank;

public class TotalMoney {

    // Let n = number of days passed.
    //
    // Time: O(n)
    // --> We must count up all of the money saved for n days.
    // Space: O(1)
    // --> We don't need any additional data structures.

    public static void main(String[] args) {
        TotalMoney totalMoney = new TotalMoney();

        // Input: n = 1
        // Output: 1
        // Explanation: On day 1, we have 1 money.
        System.out.println(totalMoney.totalMoney(1));  // 1

        // Input: n = 4
        // Output: 10
        // Explanation: After the 4th day, the total is 1 + 2 + 3 + 4 = 10.
        System.out.println(totalMoney.totalMoney(4));  // 10

        // Input: n = 7
        // Output: 28
        // Explanation: After the 7th day, the total is 1 + 2 + 3 + 4 + 5 + 6 + 7 = 28.
        System.out.println(totalMoney.totalMoney(7));  // 28

        // Input: n = 10
        // Output: 37
        // Explanation: After the 10th day, the total is (1 + 2 + 3 + 4 + 5 + 6 + 7) +
        // (2 + 3 + 4) = 37. Notice that on the 2nd Monday, Hercy only puts in $2.
        System.out.println(totalMoney.totalMoney(10));  // 37

        // Input: n = 20
        // Output: 96
        // Explanation: After the 20th day, the total is (1 + 2 + 3 + 4 + 5 + 6 + 7) +
        // (2 + 3 + 4 + 5 + 6 + 7 + 8) + (3 + 4 + 5 + 6 + 7 + 8) = 96.
        System.out.println(totalMoney.totalMoney(20));  // 96
    }

    public int totalMoney(int numDays) {
        int totalMoneySaved = 0;
        for (int dayNum = 0; dayNum < numDays; dayNum++) {
            int numMondaysPassed = (dayNum / 7);
            int moneySavedThisWeek = (dayNum % 7) + 1;
            totalMoneySaved += numMondaysPassed + moneySavedThisWeek;
        }
        return totalMoneySaved;
    }
}
