/**
 * Problem: Find the Duplicate Number
 * Platform: LeetCode 287
 *
 * Description:
 * Given an array nums containing n + 1 integers
 * where each integer is in the range [1, n] inclusive,
 * return the duplicate number.
 *
 * There is only one repeated number,
 * but it may appear more than once.
 *
 * Example:
 * Input: [1,3,4,2,2]
 * Output: 2
 *
 * Example:
 * Input: [3,1,3,4,2]
 * Output: 3
 *
 * Approach:
 * - Sort the array
 * - Traverse the sorted array
 * - If adjacent elements are equal:
 *      duplicate found
 *
 * Time Complexity: O(n log n)
 * (due to sorting)
 *
 * Space Complexity: O(1)
 * (ignoring sorting space)
 */

import java.util.*;

public class FindDuplicate {

    public static void main(String[] args) {

        // 🔹 Hardcoded input
        int[] nums = {1, 3, 4, 2, 2};

        System.out.println("Duplicate Number: " + findDuplicate(nums));
    }

    public static int findDuplicate(int[] nums) {

        Arrays.sort(nums);

        for (int i = 1; i < nums.length; i++) {

            if (nums[i - 1] == nums[i]) {
                return nums[i];
            }
        }

        return -1;
    }
}