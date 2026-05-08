/**
 * Problem: Squares of a Sorted Array
 * Platform: LeetCode 977
 *
 * Description:
 * Given an integer array nums sorted in non-decreasing order,
 * return an array of the squares of each number
 * sorted in non-decreasing order.
 *
 * Example:
 * Input: [-4,-1,0,3,10]
 * Output: [0,1,9,16,100]
 *
 * Explanation:
 * Squares:
 * 16,1,0,9,100
 *
 * After sorting:
 * 0,1,9,16,100
 *
 * Approach:
 * - Traverse the array
 * - Square each element
 * - Store in result array
 * - Sort the result array
 *
 * Time Complexity: O(n log n)
 * (sorting step)
 *
 * Space Complexity: O(n)
 */

import java.util.*;

public class SortedSquares {

    public static void main(String[] args) {

        // 🔹 Hardcoded input
        int[] nums = {-4, -1, 0, 3, 10};

        int[] result = sortedSquares(nums);

        System.out.print("Sorted Squares: ");

        for (int val : result) {
            System.out.print(val + " ");
        }
    }

    public static int[] sortedSquares(int[] nums) {

        int n = nums.length;

        int[] res = new int[n];

        // Square each element
        for (int i = 0; i < n; i++) {

            int val = nums[i] * nums[i];

            res[i] = val;
        }

        // Sort squared values
        Arrays.sort(res);

        return res;
    }
}