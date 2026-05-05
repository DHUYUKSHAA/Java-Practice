/**
 * Problem: Remove Duplicates from Sorted Array
 * Platform: LeetCode 26
 *
 * Description:
 * Given a sorted array nums, remove the duplicates in-place
 * such that each unique element appears only once.
 *
 * Return the number of unique elements (k).
 * The first k elements of nums should contain the unique elements.
 *
 * Example:
 * Input: [1,1,2] → Output: 2
 * Modified array: [1,2,_]
 *
 * Input: [0,0,1,1,1,2,2,3,3,4] → Output: 5
 * Modified array: [0,1,2,3,4,_,_,_,_,_]
 *
 * Approach (Two Pointer Technique):
 * - Use one pointer (i) to traverse the array
 * - Use another pointer (index) to place unique elements
 * - Compare current element with previous
 * - If different → place it at index and increment index
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

import java.util.*;

public class RemoveDuplicatesDemo {

    public static void main(String[] args) {

        // 🔹 Hardcoded input
        int[] nums = {0,0,1,1,1,2,2,3,3,4};

        int k = removeDuplicates(nums);

        System.out.println("Number of unique elements: " + k);

        System.out.print("Modified array: ");
        for (int i = 0; i < k; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public static int removeDuplicates(int[] nums) {

        if (nums.length == 0) return 0;

        int index = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] != nums[i]) {
                nums[index++] = nums[i];
            }
        }

        return index;
    }
}
