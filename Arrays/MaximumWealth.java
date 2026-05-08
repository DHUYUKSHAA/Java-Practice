/**
 * Problem: Richest Customer Wealth
 * Platform: LeetCode 1672
 *
 * Description:
 * You are given an m x n integer grid accounts where:
 * - accounts[i][j] represents the amount of money
 *   the ith customer has in the jth bank.
 *
 * Return the wealth that the richest customer has.
 *
 * A customer's wealth is the sum of money
 * across all their bank accounts.
 *
 * Example:
 * Input:
 * [
 *   [1,2,3],
 *   [3,2,1]
 * ]
 * Output: 6
 *
 * Explanation:
 * Customer 1 wealth = 1+2+3 = 6
 * Customer 2 wealth = 3+2+1 = 6
 *
 * Approach:
 * - Traverse each row (customer)
 * - Calculate sum of each row
 * - Track maximum wealth
 *
 * Time Complexity: O(n * m)
 * Space Complexity: O(1)
 */

public class MaximumWealth {

    public static void main(String[] args) {

        // 🔹 Hardcoded input
        int[][] accounts = {
            {1, 2, 3},
            {3, 2, 1}
        };

        System.out.println("Maximum Wealth: " + maximumWealth(accounts));
    }

    public static int maximumWealth(int[][] accounts) {

        int n = accounts.length;
        int m = accounts[0].length;

        int max = 0;

        for (int i = 0; i < n; i++) {

            int sum = 0;

            for (int j = 0; j < m; j++) {
                sum += accounts[i][j];
            }

            max = Math.max(max, sum);
        }

        return max;
    }
}