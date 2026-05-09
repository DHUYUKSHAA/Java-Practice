/**
 * Problem: Neither Minimum nor Maximum
 * Platform: LeetCode 2733
 *
 * Description:
 * Given an integer array nums of distinct integers,
 * return any number that is neither the minimum nor maximum value.
 *
 * If no such number exists, return -1.
 *
 * Example:
 * Input: [3,2,1,4]
 * Output: 2
 *
 * Explanation:
 * Minimum = 1
 * Maximum = 4
 * 2 is neither minimum nor maximum.
 *
 * Example:
 * Input: [1,2]
 * Output: -1
 *
 * Approach:
 * - Find minimum and maximum values in the array
 * - Traverse again:
 *      return first element that is not min and not max
 *
 * - If no such element exists:
 *      return -1
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

public class FindNonMinOrMax {

    public static void main(String[] args) {

        // 🔹 Hardcoded input
        int[] nums = {3, 2, 1, 4};

        System.out.println("Answer: " + findNonMinOrMax(nums));
    }

    public static int findNonMinOrMax(int[] nums) {

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        // Find max and min
        for (int i = 0; i < nums.length; i++) {

            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }

        // Find element that is neither max nor min
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] != max && nums[i] != min) {
                return nums[i];
            }
        }

        return -1;
    }
}