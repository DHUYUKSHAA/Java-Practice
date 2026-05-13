/**
 * Problem: Coin Change
 * Platform: LeetCode 322
 
 * Description:
 * You are given an integer array coins representing coins of different
 * denominations and an integer amount representing a total amount.
 *
 * Return the fewest number of coins needed to make up that amount.
 * If that amount cannot be made up, return -1.
 *
 * Example:
 * Input: coins = [1,2,5], amount = 11 → Output: 3
 * Explanation: 11 = 5 + 5 + 1
 *
 * Input: coins = [2], amount = 3 → Output: -1
 *
 * Approach (Dynamic Programming - Bottom Up):
 * - Create dp array of size amount + 1
 * - dp[i] = minimum coins needed to make amount i

 * - Initialize dp with a large value (amount + 1)
 * - dp[0] = 0 (0 coins needed to make amount 0)
 * - For each amount i:
 *     Try every coin:
 *         if coin <= i:
 *             dp[i] = min(dp[i], dp[i - coin] + 1)
 *
 * - If dp[amount] is still large → return -1
 *
 * Time Complexity: O(amount * number of coins)
 * Space Complexity: O(amount)
 */

import java.util.*;

public class CoinChange{

    public static void main(String[] args) {

        // 🔹 Hardcoded input
        int[] coins = {1, 2, 5};
        int amount = 11;

        System.out.println("Minimum coins required: " + coinChange(coins, amount));
    }

    public static int coinChange(int[] coins, int amount) {

        int[] dp = new int[amount + 1];

        Arrays.fill(dp, amount + 1);

        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }
}
