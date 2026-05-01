/**
 * Problem: Container With Most Water
 * Platform: LeetCode 11
 *
 * Description:
 * Given an array of integers height where each element represents
 * the height of a vertical line, find two lines that together with
 * the x-axis form a container that holds the maximum amount of water.
 *
 * You cannot tilt the container.
 *
 * Example:
 * Input: height = [1,8,6,2,5,4,8,3,7]
 * Output: 49
 *
 * Explanation:
 * The maximum water is formed between index 1 (height 8)
 * and index 8 (height 7):
 * width = 8 - 1 = 7
 * height = min(8,7) = 7
 * area = 7 * 7 = 49
 *
 * Approach (Two Pointer):
 * - Start with two pointers:
 *      left = 0
 *      right = n - 1
 *
 * - Calculate area:
 *      width = right - left
 *      height = min(height[left], height[right])
 *      area = width * height
 *
 * - Update max area
 *
 * - Move the pointer pointing to smaller height:
 *      Because area depends on smaller height
 *
 * - Repeat until left < right
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

public class containerWithMostWater {

    public static void main(String[] args) {

        int[] height = {1,8,6,2,5,4,8,3,7};

        int result = maxArea(height);

        System.out.println("Maximum Water = " + result);
    }

    /**
     * Returns maximum water that can be stored
     */
    public static int maxArea(int[] height) {

        int left = 0;
        int right = height.length - 1;

        int maxArea = 0;

        // Loop until pointers meet
        while (left < right) {

            // Calculate width
            int width = right - left;

            // Find minimum height
            int minHeight;
            if (height[left] < height[right]) {
                minHeight = height[left];
            } else {
                minHeight = height[right];
            }

            // Calculate area
            int area = width * minHeight;

            // Update maximum area
            if (area > maxArea) {
                maxArea = area;
            }

            // Move pointer with smaller height
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}