/**
 * Problem: Find Peak Element
 * Platform: LeetCode 162
 *
 * Description:
 * A peak element is an element that is strictly greater
 * than its neighboring elements.
 *
 * Given an integer array nums,
 * return the index of any peak element.
 *
 * You may imagine:
 *      nums[-1] = -∞
 *      nums[n]  = -∞
 *
 * Example:
 * Input: [1,2,3,1]
 * Output: 2
 *
 * Explanation:
 * nums[2] = 3
 * 3 > 2 and 3 > 1
 * so index 2 is a peak.
 *
 * Example:
 * Input: [1,2,1,3,5,6,4]
 * Output: 5
 *
 * Approach:
 * - Traverse the array
 * - Find first position where:
 *      nums[i] > nums[i+1]
 *
 * - This means nums[i] is greater than right neighbor,
 *   so it is a peak.
 *
 * - If no such position exists:
 *      last element is peak
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

public class FindPeakElement {

    public static void main(String[] args) {

        // 🔹 Hardcoded input
        int[] nums = {1, 2, 3, 1};

        System.out.println("Peak Index: " + findPeakElement(nums));
    }

    public static int findPeakElement(int[] nums) {

        for (int i = 0; i < nums.length - 1; i++) {

            if (nums[i] > nums[i + 1]) {
                return i;
            }
        }

        return nums.length - 1;
    }
}