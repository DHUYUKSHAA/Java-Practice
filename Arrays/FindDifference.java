/**
 * Problem: Find the Difference of Two Arrays
 * Platform: LeetCode 2215
 *
 * Description:
 * Given two integer arrays nums1 and nums2,
 * return a list answer of size 2 where:
 *
 * answer[0]:
 *      distinct integers in nums1
 *      not present in nums2
 *
 * answer[1]:
 *      distinct integers in nums2
 *      not present in nums1
 *
 * Example:
 * Input:
 * nums1 = [1,2,3]
 * nums2 = [2,4,6]
 *
 * Output:
 * [[1,3],[4,6]]
 *
 * Explanation:
 * - 1 and 3 are present only in nums1
 * - 4 and 6 are present only in nums2
 *
 * Approach:
 * - Use nested loops to compare arrays
 * - For nums1:
 *      check whether element exists in nums2
 *      if not → add to set val1
 *
 * - For nums2:
 *      check whether element exists in nums1
 *      if not → add to set val2
 *
 * Why use HashSet?
 * - Automatically removes duplicates
 * - Stores only distinct elements
 *
 * Finally:
 * - Convert sets into lists
 * - Add both lists into result
 *
 * Time Complexity: O(n * m)
 * Space Complexity: O(n + m)
 */

import java.util.*;

public class FindDifference {

    public static void main(String[] args) {

        // 🔹 Hardcoded input
        int[] nums1 = {1, 2, 3};
        int[] nums2 = {2, 4, 6};

        List<List<Integer>> result = findDifference(nums1, nums2);

        System.out.println("Difference: " + result);
    }

    public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {

        List<List<Integer>> res = new ArrayList<>();

        Set<Integer> val1 = new HashSet<>();
        Set<Integer> val2 = new HashSet<>();

        // Elements present in nums1 but not in nums2
        for (int i = 0; i < nums1.length; i++) {

            boolean found = false;

            for (int j = 0; j < nums2.length; j++) {

                if (nums1[i] == nums2[j]) {

                    found = true;
                    break;
                }
            }

            if (!found) {

                val1.add(nums1[i]);
            }
        }

        // Elements present in nums2 but not in nums1
        for (int i = 0; i < nums2.length; i++) {

            boolean found = false;

            for (int j = 0; j < nums1.length; j++) {

                if (nums2[i] == nums1[j]) {

                    found = true;
                    break;
                }
            }

            if (!found) {

                val2.add(nums2[i]);
            }
        }

        // Add both lists into result
        res.add(new ArrayList<>(val1));
        res.add(new ArrayList<>(val2));

        return res;
    }
}