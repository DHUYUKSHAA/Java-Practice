/**
 * Problem: Remove Duplicates from Sorted Array
 * Platform: LeetCode 26
 *
 * Description:
 * Given a sorted array nums, remove duplicates in-place such that
 * each unique element appears only once.
 *
 * Return the number of unique elements (k).
 * The first k elements of nums should contain the unique values.
 *
 * Example:
 * Input: nums = [1,1,2]
 * Output: 2
 * nums = [1,2,_]
 *
 * Input: nums = [0,0,1,1,1,2,2,3,3,4]
 * Output: 5
 * nums = [0,1,2,3,4,_...]
 *
 * Approach:
 * - Traverse the array
 * - Store unique elements in a list
 * - Skip duplicates using inner loop
 * - Copy unique elements back to original array
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)  // extra list used
 */

import java.util.*;

public class RemoveDuplicates {

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};

        int k = removeDuplicates(nums);

        System.out.println("Unique count = " + k);
        System.out.print("Array after removing duplicates: ");

        for (int i = 0; i < k; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public static int removeDuplicates(int[] nums) {

        if (nums.length == 0) return 0;

        List<Integer> res = new ArrayList<>();
        int index = 0;

        while (index < nums.length) {
            int val = nums[index];
            res.add(val);

            int j = index + 1;

            while (j < nums.length && nums[j] == val) {
                j++;
            }

            index = j; // skip duplicates
        }

        // copy back to original array
        for (int i = 0; i < res.size(); i++) {
            nums[i] = res.get(i);
        }

        return res.size();
    }
}