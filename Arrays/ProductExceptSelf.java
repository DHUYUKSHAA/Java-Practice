/**
 * Problem: Product of Array Except Self
 * Platform: LeetCode 238
 *
 * Description:
 * Given an integer array nums, return an array answer such that
 * answer[i] is equal to the product of all elements of nums except nums[i].
 *
 * You must solve it without using division and in O(n) time.
 *
 * Example:
 * Input: [1,2,3,4] → Output: [24,12,8,6]
 *
 * Explanation:
 * For index 0 → 2*3*4 = 24
 * For index 1 → 1*3*4 = 12
 * For index 2 → 1*2*4 = 8
 * For index 3 → 1*2*3 = 6
 *
 * Approach (Prefix + Suffix Product):
 * - First pass: compute prefix products
 *      result[i] = product of all elements before i
 *
 * - Second pass: multiply with suffix products
 *      right keeps product of elements after i
 *
 * - Final result[i] = prefix * suffix
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1) (excluding output array)
 */

import java.util.*;

public class ProductExceptSelf {

    public static void main(String[] args) {

        // 🔹 Hardcoded input
        int[] nums = {1, 2, 3, 4};

        int[] result = productExceptSelf(nums);

        System.out.print("Output: ");
        for (int val : result) {
            System.out.print(val + " ");
        }
    }

    public static int[] productExceptSelf(int[] nums) {

        int n = nums.length;

        int[] result = new int[n];

        // Prefix product
        result[0] = 1;
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        // Suffix product
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] = result[i] * right;
            right *= nums[i];
        }

        return result;
    }
}