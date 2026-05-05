/**
 * Problem: House Robber II
 * Platform: LeetCode 213
 *
 * Description:
 * Same as House Robber, but houses are arranged in a CIRCLE.
 * That means:
 * - First and last houses are adjacent
 * - You cannot rob both
 *
 * Example:
 * Input: [2, 3, 2] → Output: 3
 * Explanation:
 * Cannot take both first and last → pick 3
 *
 * Input: [1, 2, 3, 1] → Output: 4
 *
 * Approach:
 * - Convert circular problem into two linear arrays:
 *
 *   val1 → exclude last house (0 → n-2)
 *   val2 → exclude first house (1 → n-1)
 *
 * - Apply normal House Robber DP on both arrays
 * - Return maximum of both results
 *
 * Recurrence (used in helper):
 *      dp[i] = max(dp[i-1], dp[i-2] + nums[i])
 *
 * Edge Case:
 * - If only one house → return nums[0]
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

public class HouseRobberII {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1}; // change input here
        System.out.println(rob(nums));
    }

    public static int rob(int[] nums) {
        int m = nums.length;

        // Edge case
        if (m == 1) return nums[0];

        int[] val1 = new int[m - 1]; // exclude last
        int[] val2 = new int[m - 1]; // exclude first

        for (int i = 0; i < m - 1; i++) {
            val1[i] = nums[i];
            val2[i] = nums[i + 1];
        }

        int value1 = robber(val1);
        int value2 = robber(val2);

        return Math.max(value1, value2);
    }

    // Standard House Robber (linear)
    public static int robber(int[] nums) {
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