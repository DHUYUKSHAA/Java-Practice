/**
 * Problem: Difference Between Element Sum and Digit Sum of an Array
 * Platform: LeetCode 2535
 *
 * Description:
 * Given a positive integer array nums:
 *
 * - Element Sum:
 *      Sum of all elements in the array
 *
 * - Digit Sum:
 *      Sum of digits of all elements
 *
 * Return the absolute difference between
 * the element sum and digit sum.
 *
 * Example:
 * Input: [1,15,6,3]
 * Output: 9
 *
 * Explanation:
 * Element Sum = 1 + 15 + 6 + 3 = 25
 *
 * Digit Sum = 1 + (1+5) + 6 + 3 = 16
 *
 * Difference = 25 - 16 = 9
 *
 * Approach:
 * - First calculate total element sum
 * - Then traverse each number:
 *      extract digits using %10
 *      add digits to digit sum
 *
 * - Return difference of both sums
 *
 * Time Complexity: O(n * d)
 * d = number of digits
 *
 * Space Complexity: O(1)
 */

public class DifferenceOfSum {

    public static void main(String[] args) {

        // 🔹 Hardcoded input
        int[] nums = {1, 15, 6, 3};

        System.out.println("Difference: " + differenceOfSum(nums));
    }

    public static int differenceOfSum(int[] nums) {

        int n = nums.length;

        int sum = 0;

        // Element sum
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }

        int sum1 = 0;

        // Digit sum
        for (int i = 0; i < n; i++) {

            int val = nums[i];

            while (val != 0) {
                sum1 += val % 10;
                val /= 10;
            }
        }

        return sum - sum1;
    }
}