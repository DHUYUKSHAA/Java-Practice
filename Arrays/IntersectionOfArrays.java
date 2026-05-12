/**
 * Problem: Intersection of Two Arrays
 * Platform: LeetCode 349
 *
 * Description:
 * Given two integer arrays nums1 and nums2,
 * return an array of their intersection.
 *
 * Each element in the result:
 * - must be unique
 * - may be returned in any order
 *
 * Example:
 * Input:
 * nums1 = [1,2,2,1]
 * nums2 = [2,2]
 *
 * Output:
 * [2]
 *
 * Example:
 * Input:
 * nums1 = [4,9,5]
 * nums2 = [9,4,9,8,4]
 *
 * Output:
 * [9,4]
 *
 * Approach:
 * - Use HashSet to store unique common elements
 * - Compare every element of nums1 with nums2
 * - If equal:
 *      add to set
 *
 * - Convert set into array
 *
 * Why use HashSet?
 * - Automatically removes duplicates
 * - Ensures unique intersection elements
 *
 * Time Complexity: O(n * m)
 * Space Complexity: O(n)
 */

import java.util.*;

public class IntersectionOfArrays {

    public static void main(String[] args) {

        // 🔹 Hardcoded input
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};

        int[] result = intersection(nums1, nums2);

        System.out.print("Intersection: ");

        for (int val : result) {
            System.out.print(val + " ");
        }
    }

    public static int[] intersection(int[] nums1, int[] nums2) {

        Set<Integer> res = new HashSet<>();

        // Find common elements
        for (int i = 0; i < nums1.length; i++) {

            for (int j = 0; j < nums2.length; j++) {

                if (nums1[i] == nums2[j]) {

                    res.add(nums1[i]);
                }
            }
        }

        // Convert set to array
        int[] arr = new int[res.size()];

        int i = 0;

        for (int num : res) {

            arr[i++] = num;
        }

        return arr;
    }
}