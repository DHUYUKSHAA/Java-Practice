/**
 * Problem: Roman to Integer
 * Platform: LeetCode 13
 *
 * Description:
 * Convert a Roman numeral string into an integer.
 *
 * Roman Values:
 * I = 1, V = 5, X = 10, L = 50,
 * C = 100, D = 500, M = 1000
 *
 * Example:
 * Input: "MCMXCIV"
 * Output: 1994
 *
 * Explanation:
 * M = 1000
 * CM = 900
 * XC = 90
 * IV = 4
 * Total = 1994
 *
 * Approach:
 * - Traverse from right to left
 * - Convert each Roman character to its value
 *
 * - If current value is smaller than accumulated value:
 *      subtract it
 * - Else:
 *      add it
 *
 * - Trick:
 *      if (4 * current < total) → subtract
 *      else → add
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

public class RomanToInteger {

    public static void main(String[] args) {
        String s = "MCMXCIV"; // change input here
        System.out.println(romanToInt(s));
    }

    public static int romanToInt(String s) {
        int ans = 0;
        int n = 0;

        for (int i = s.length() - 1; i >= 0; i--) {

            switch (s.charAt(i)) {
                case 'I': n = 1; break;
                case 'V': n = 5; break;
                case 'X': n = 10; break;
                case 'L': n = 50; break;
                case 'C': n = 100; break;
                case 'D': n = 500; break;
                case 'M': n = 1000; break;
            }

            if (4 * n < ans) {
                ans -= n;
            } else {
                ans += n;
            }
        }

        return ans;
    }
}