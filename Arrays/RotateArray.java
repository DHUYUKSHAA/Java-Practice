/**
 * Problem: Rotate Array
 * Platform: LeetCode 189
 *
 * Description:
 * Given an integer array nums, rotate the array to the right by k steps.
 *
 * Example:
 * Input: nums = [1,2,3,4,5,6,7], k = 3
 * Output: [5,6,7,1,2,3,4]
 *
 * Explanation:
 * Rotate right by 3 steps:
 *
 * Original:
 * [1,2,3,4,5,6,7]
 *
 * After rotation:
 * [5,6,7,1,2,3,4]
 *
 * Approach (Reversal Algorithm):
 *
 * Step 1:
 * Reverse entire array
 *
 * [1,2,3,4,5,6,7]
 * → [7,6,5,4,3,2,1]
 *
 * Step 2:
 * Reverse first k elements
 *
 * [7,6,5,4,3,2,1]
 * → [5,6,7,4,3,2,1]
 *
 * Step 3:
 * Reverse remaining elements
 *
 * [5,6,7,4,3,2,1]
 * → [5,6,7,1,2,3,4]
 *
 * Why do we use:
 *      k = k % n ?
 *
 * - Sometimes k can be greater than array length
 *
 * Example:
 * nums.length = 7
 * k = 10
 *
 * Rotating 10 times is same as rotating:
 *      10 % 7 = 3 times
 *
 * Because after every full rotation of n steps,
 * the array becomes the same again.
 *
 * So:
 *      k = k % n
 *
 * avoids unnecessary rotations and prevents index issues.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

import java.util.*;

public class RotateArray {

    public static void main(String[] args) {

        // 🔹 Hardcoded input
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;

        rotate(nums, k);

        System.out.print("Rotated Array: ");

        for (int val : nums) {
            System.out.print(val + " ");
        }
    }

    public static void rotate(int[] nums, int k) {

        int n = nums.length;

        // Reduce unnecessary full rotations
        k = k % n;

        // Reverse full array
        reverse(nums, 0, n - 1);

        // Reverse first k elements
        reverse(nums, 0, k - 1);

        // Reverse remaining elements
        reverse(nums, k, n - 1);
    }

    public static void reverse(int[] nums, int s, int e) {

        while (s < e) {

            int temp = nums[s];
            nums[s] = nums[e];
            nums[e] = temp;

            s++;
            e--;
        }
    }
}