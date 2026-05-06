/**
 * Problem: Climbing Stairs
 * Platform: LeetCode 70
 *
 * Description:
 * You are climbing a staircase. It takes n steps to reach the top.
 * Each time you can either climb 1 step or 2 steps.
 *
 * Return the number of distinct ways to reach the top.
 *
 * Example:
 * Input: n = 3 → Output: 3
 * Explanation:
 * Ways:
 * 1+1+1
 * 1+2
 * 2+1
 *
 * Input: n = 4 → Output: 5
 *
 * Approach (Dynamic Programming):
 * - dp[i] represents number of ways to reach step i
 * - At each step:
 *      You can come from (i-1) or (i-2)
 *
 * - Transition:
 *      dp[i] = dp[i-1] + dp[i-2]
 *
 * - Base cases:
 *      dp[1] = 1
 *      dp[2] = 2
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

public class ClimbStairs {

    public static void main(String[] args) {

        // 🔹 Hardcoded input
        int n = 5;

        System.out.println("Number of ways: " + climbStairs(n));
    }

    public static int climbStairs(int n) {

        if (n == 1) return n;

        int[] dp = new int[n + 1];

        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
}