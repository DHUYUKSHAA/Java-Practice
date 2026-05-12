/**
 * Problem: Intersection of Two Arrays II
 * Platform: LeetCode 350
 *
 * Description:
 * Given two integer arrays nums1 and nums2,
 * return an array of their intersection.
 *
 * Each element in the result should appear
 * as many times as it shows in both arrays.
 *
 * The result may be returned in any order.
 *
 * Example:
 * Input:
 * nums1 = [1,2,2,1]
 * nums2 = [2,2]
 *
 * Output:
 * [2,2]
 *
 * Example:
 * Input:
 * nums1 = [4,9,5]
 * nums2 = [9,4,9,8,4]
 *
 * Output:
 * [4,9]
 *
 * Approach:
 * - Use nested loops to compare elements
 * - If elements match:
 *      add element to result list
 *      mark nums2[j] as used using -1
 *      break to avoid duplicate matching
 *
 * Why mark nums2[j] = -1 ?
 * - Prevents reusing the same element again
 * - Ensures correct frequency count
 *
 * Example:
 * nums2 = [2,2]
 *
 * After first match:
 * nums2 = [-1,2]
 *
 * So first 2 is not reused again.
 *
 * Time Complexity: O(n * m)
 * Space Complexity: O(min(n,m))
 */

import java.util.*;

public class IntersectArraysII {

    public static void main(String[] args) {

        // 🔹 Hardcoded input
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};

        int[] result = intersect(nums1, nums2);

        System.out.print("Intersection: ");

        for (int val : result) {
            System.out.print(val + " ");
        }
    }

    public static int[] intersect(int[] nums1, int[] nums2) {

        List<Integer> res = new ArrayList<>();

        // Compare both arrays
        for (int i = 0; i < nums1.length; i++) {

            for (int j = 0; j < nums2.length; j++) {

                if (nums1[i] == nums2[j]) {

                    res.add(nums2[j]);

                    // Mark as used
                    nums2[j] = -1;

                    break;
                }
            }
        }

        // Convert list to array
        int[] arr = new int[res.size()];

        for (int i = 0; i < res.size(); i++) {

            arr[i] = res.get(i);
        }

        return arr;
    }
}