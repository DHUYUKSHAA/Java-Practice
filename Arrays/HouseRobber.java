/**
 * Problem: House Robber
 * Platform: LeetCode 198
 *
 * Description:
 * Given an integer array nums where each element represents
 * money in a house, return the maximum amount you can rob
 * without robbing two adjacent houses.
 *
 * Example:
 * Input: [2, 7, 9, 3, 1] → Output: 12
 * Explanation:
 * Rob house 1 (2), skip 7, rob 9, skip 3, rob 1 → total = 12
 *
 * Approach:
 * - Use Dynamic Programming
 * - At each index, decide:
 *      1. Rob current house → nums[i] + dp[i-2]
 *      2. Skip current house → dp[i-1]
 * - Take maximum of both choices
 *
 * Recurrence:
 *      dp[i] = max(dp[i-1], dp[i-2] + nums[i])
 *
 * Base Cases:
 *      dp[0] = nums[0]
 *      dp[1] = max(nums[0], nums[1])
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

public class HouseRobber {

    public static void main(String[] args) {
        int[] nums = {2, 7, 9, 3, 1}; // change input here
        System.out.println(rob(nums));
    }

    public static int rob(int[] nums) {
        int n = nums.length;

        // Edge case
        if (n == 1) return nums[0];

        int[] dp = new int[n];

        // Base cases
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        // Fill dp array
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }

        return dp[n - 1];
    }
}