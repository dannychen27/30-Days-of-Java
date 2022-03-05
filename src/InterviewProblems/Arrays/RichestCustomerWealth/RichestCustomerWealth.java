package InterviewProblems.Arrays.RichestCustomerWealth;

public class RichestCustomerWealth {

    // Let n = the total number of accounts every customer has.
    //
    // Time: O(n)
    // --> We must traverse the entire matrix once.
    // Space: O(1)
    // --> We only store the variable representing the maximum wealth, and the current
    // account wealth.

    public static void main(String[] args) {
        RichestCustomerWealth richestCustomerWealth = new RichestCustomerWealth();

        // Input: accounts = [[1, 2, 3]]
        // Output: 6
        // Explanation: The only account has a balance of 1 + 2 + 3 = 6.
        int[][] accounts1 = {{1, 2, 3}};
        int maximumWealth1 = richestCustomerWealth.maximumWealth(accounts1);
        System.out.println(maximumWealth1);  // 6

        // Input: accounts = [[1], [2], [3]]
        // Output: 3
        // Explanation:
        // 1st customer has wealth = 1
        // 2nd customer has wealth = 2
        // 3rd customer has wealth = 3
        int[][] accounts2 = {{1}, {2}, {3}};
        int maximumWealth2 = richestCustomerWealth.maximumWealth(accounts2);
        System.out.println(maximumWealth2);  // 3

        // Input: accounts = [[1, 2, 3], [3, 2, 1]]
        // Output: 6
        // Explanation:
        // 1st customer has wealth = 1 + 2 + 3 = 6
        // 2nd customer has wealth = 3 + 2 + 1 = 6
        // Both customers are considered the richest with a wealth of 6 each, so return 6.
        int[][] accounts3 = {{1, 2, 3}, {3, 2, 1}};
        int maximumWealth3 = richestCustomerWealth.maximumWealth(accounts3);
        System.out.println(maximumWealth3);  // 6

        // Input: accounts = [[1, 5], [7, 3], [3, 5]]
        // Output: 10
        // Explanation:
        // 1st customer has wealth = 6
        // 2nd customer has wealth = 10
        // 3rd customer has wealth = 8
        // The 2nd customer is the richest with a wealth of 10.
        int[][] accounts4 = {{1, 5}, {7, 3}, {3, 5}};
        int maximumWealth4 = richestCustomerWealth.maximumWealth(accounts4);
        System.out.println(maximumWealth4);  // 10

        // Input: accounts = [[2, 8, 7], [7, 1, 3], [1, 9, 5]]
        // Output: 17
        // Explanation:
        // 1st customer has wealth = 2 + 8 + 7 = 17
        // 2nd customer has wealth = 7 + 1 + 3 = 10
        // 3rd customer has wealth = 1 + 9 + 5 = 17
        // The 1st and 3rd customers are considered the richest with a wealth of 17 each,
        // so return 17.
        int[][] accounts5 = {{2, 8, 7}, {7, 1, 3}, {1, 9, 5}};
        int maximumWealth5 = richestCustomerWealth.maximumWealth(accounts5);
        System.out.println(maximumWealth5);  // 17
    }

    /**
     * You are given an m x n integer grid accounts where accounts[i][j] is the amount
     * of money the ith customer has in the jth bank.
     *
     * Return the wealth that the richest customer has.
     *
     * A customer's wealth is the amount of money they have in all their bank accounts.
     * The richest customer is the customer that has the maximum wealth.
     *
     * Preconditions:
     * - accounts.length >= 1.
     * - accounts[i].length >= 1.
     * - accounts[i][j] >= 1.
     */
    public int maximumWealth(int[][] accounts) {
        int maximumWealth = 0;
        for (int[] account : accounts) {
            int accountBalance = 0;
            for (int balance : account) {
                accountBalance += balance;
            }
            maximumWealth = Math.max(maximumWealth, accountBalance);
        }
        return maximumWealth;
    }
}
