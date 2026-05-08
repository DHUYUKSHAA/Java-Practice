/**
 * Problem: Add Digits
 * Platform: LeetCode 258
 *
 * Description:
 * Given an integer num, repeatedly add all its digits
 * until the result has only one digit.
 *
 * Return the final single digit.
 *
 * Example:
 * Input: 38
 * Output: 2
 *
 * Explanation:
 * 3 + 8 = 11
 * 1 + 1 = 2
 *
 * Since 2 is a single digit, return 2.
 *
 * Approach:
 * - Repeat until number becomes a single digit
 * - Extract digits using %10
 * - Add digits into sum
 * - Replace num with sum
 *
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 */

public class AddDigits {

    public static void main(String[] args) {

        // 🔹 Hardcoded input
        int num = 38;

        System.out.println("Single Digit Result: " + addDigits(num));
    }

    public static int addDigits(int num) {

        while (num >= 10) {

            int sum = 0;

            while (num > 0) {

                sum += num % 10;

                num /= 10;
            }

            num = sum;
        }

        return num;
    }
}