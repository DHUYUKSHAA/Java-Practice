/**
 * Problem: Search Insert Position
 * Platform: LeetCode 35
 *
 * Description:
 * Given a sorted array of distinct integers and a target value,
 * return the index if the target is found.
 * If not, return the index where it would be inserted
 * to maintain sorted order.
 *
 * Example:
 * Input: nums = [1,3,5,6], target = 5 → Output: 2
 * Input: nums = [1,3,5,6], target = 2 → Output: 1
 * Input: nums = [1,3,5,6], target = 7 → Output: 4
 *
 * Approach 1: Linear Search
 * - Traverse array from left to right
 * - Return first index where nums[i] >= target
 * - If not found, return nums.length
 *
 * Approach 2: Binary Search
 * - Use left, right pointers
 * - Narrow search using mid
 * - If not found, left gives insert position
 *
 * Time Complexity:
 * Linear → O(n)
 * Binary → O(log n)
 *
 * Space Complexity: O(1)
 */

public class SearchInsertPosition {
    public static void main(String[] args) {

        int[] nums = {1, 3, 5, 6};
        int target = 2;

        System.out.println("Linear Search Output: " + linearSearch(nums, target));
        System.out.println("Binary Search Output: " + binarySearch(nums, target));
    }

    public static int linearSearch(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) {
                return i;
            }
        }
        return nums.length;
    }

    public static int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) left = mid + 1;
            else right = mid - 1;
        }

        return left;
    }
}