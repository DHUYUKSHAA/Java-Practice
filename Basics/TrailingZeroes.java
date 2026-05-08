/**
 * Problem: Factorial Trailing Zeroes
 * Platform: LeetCode 172
 *
 * Description:
 * Given an integer n, return the number of trailing zeroes in n!.
 *
 * Trailing zeroes are formed by multiples of 10.
 * Since:
 *      10 = 2 × 5
 *
 * And factorial contains more 2s than 5s,
 * we only need to count the number of 5s.
 *
 * Example:
 * Input: 5 → Output: 1
 * Explanation:
 * 5! = 120 → one trailing zero
 *
 * Input: 10 → Output: 2
 * Explanation:
 * 10! = 3628800 → two trailing zeroes
 *
 * Approach:
 * - Count how many multiples of 5 are present
 * - Then count multiples of 25 (extra 5)
 * - Then multiples of 125, and so on
 *
 * Formula:
 *      n/5 + n/25 + n/125 + ...
 *
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 */

public class TrailingZeroes {

    public static void main(String[] args) {

        // 🔹 Hardcoded input
        int n = 100;

        System.out.println("Trailing Zeroes: " + trailingZeroes(n));
    }

    public static int trailingZeroes(int n) {

        if (n < 0) return 0;

        int sum = 0;

        while (n > 0) {
            n /= 5;
            sum += n;
        }

        return sum;
    }
}