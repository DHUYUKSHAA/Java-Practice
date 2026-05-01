/**
 * Problem: Median of Two Sorted Arrays
 * Platform: LeetCode 4
 *
 * Description:
 * Given two sorted arrays nums1 and nums2,
 * return the median of the combined sorted array.
 *
 * Example:
 * Input: nums1 = [1,3], nums2 = [2]
 * Output: 2.0
 *
 * Input: nums1 = [1,2], nums2 = [3,4]
 * Output: 2.5
 *
 * Approach:
 * - Create a new list and add all elements from both arrays
 * - Sort the combined list
 *
 * - If size is odd:
 *      median = middle element
 *
 * - If size is even:
 *      median = average of two middle elements
 *
 * Time Complexity: O((n + m) log(n + m))   // due to sorting
 * Space Complexity: O(n + m)
 */

import java.util.*;

public class MedianOfTwoSortedArrays {

    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};

        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> res = new ArrayList<>();

        // Add elements of nums1
        for (int i = 0; i < nums1.length; i++) {
            res.add(nums1[i]);
        }

        // Add elements of nums2
        for (int i = 0; i < nums2.length; i++) {
            res.add(nums2[i]);
        }

        // Sort the combined list
        Collections.sort(res);

        int size = res.size();

        // If odd length
        if (size % 2 == 1) {
            return res.get(size / 2);
        }

        // If even length
        return (res.get(size / 2) + res.get((size / 2) - 1)) / 2.0;
    }
}