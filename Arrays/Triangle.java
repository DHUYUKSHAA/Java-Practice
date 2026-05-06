/**
 * Problem: Triangle Minimum Path Sum
 * Platform: LeetCode 120
 *
 * Description:
 * Given a triangle array, return the minimum path sum from top to bottom.
 * At each step, you may move to adjacent numbers in the row below.
 *
 * Example:
 * Input:
 * [
 *   [2],
 *   [3,4],
 *   [6,5,7],
 *   [4,1,8,3]
 * ]
 * Output: 11
 * Explanation:
 * Path = 2 → 3 → 5 → 1 = 11
 *
 * Approach (Dynamic Programming - Bottom Up):
 * - Start from the last row and move upward
 * - dp[i][j] represents minimum path sum from (i,j) to bottom
 * - Transition:
 *      dp[i][j] = triangle[i][j] + min(dp[i+1][j], dp[i+1][j+1])
 *
 * - Extra row (n+1) avoids boundary checks
 *
 * Time Complexity: O(n^2)
 * Space Complexity: O(n^2)
 */

import java.util.*;

public class Triangle {

    public static void main(String[] args) {

        // 🔹 Hardcoded input
        List<List<Integer>> triangle = new ArrayList<>();

        triangle.add(Arrays.asList(2));
        triangle.add(Arrays.asList(3, 4));
        triangle.add(Arrays.asList(6, 5, 7));
        triangle.add(Arrays.asList(4, 1, 8, 3));

        System.out.println("Minimum Path Sum: " + minimumTotal(triangle));
    }

    public static int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();

        int[][] dp = new int[n + 1][n + 1];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = triangle.get(i).get(j) +
                           Math.min(dp[i + 1][j], dp[i + 1][j + 1]);
            }
        }

        return dp[0][0];
    }
}