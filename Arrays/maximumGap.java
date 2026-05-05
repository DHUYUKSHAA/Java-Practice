/**
 * Problem: Maximum Gap
 * Platform: LeetCode 164
 *
 * Description:
 * Given an integer array nums, return the maximum difference
 * between two successive elements in its sorted form.
 *
 * If the array contains less than 2 elements, return 0.
 *
 * Example:
 * Input: [3,6,9,1] → Output: 3
 * Explanation:
 * Sorted array = [1,3,6,9]
 * Differences = 2, 3, 3 → max = 3
 *
 * Approach:
 * - Sort the array
 * - Traverse and find difference between adjacent elements
 * - Track the maximum gap
 *
 * Time Complexity: O(n log n)
 * Space Complexity: O(1)
 */

import java.util.*;

public class maximumGap {

    public static void main(String[] args) {

        // 🔹 Hardcoded input
        int[] nums = {3, 6, 9, 1};

        System.out.println("Maximum Gap: " + maximum(nums));
    }

    public static int maximum(int[] nums) {

        // Edge case
        if (nums.length < 2) return 0;

        Arrays.sort(nums);

        int gap = 0;

        for (int i = 1; i < nums.length; i++) {
            int diff = nums[i] - nums[i - 1];

            if (diff > gap) {
                gap = diff;
            }
        }

        return gap;
    }
}