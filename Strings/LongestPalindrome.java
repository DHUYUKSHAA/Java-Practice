/**
 * Problem: Longest Palindromic Substring
 * Platform: LeetCode 5
 *
 * Description:
 * Given a string s, return the longest palindromic substring in s.
 *
 * A palindrome is a string that reads the same forward and backward.
 *
 * Example:
 * Input: "babad" → Output: "bab"
 * Explanation:
 * "aba" is also a valid answer.
 *
 * Input: "cbbd" → Output: "bb"
 *
 * Approach (Expand Around Center):
 * - Every palindrome expands from its center
 * - For each index:
 *      1. Check odd length palindrome (center = i)
 *      2. Check even length palindrome (center = i, i+1)
 *
 * - Expand outward while characters are equal
 * - Track the longest palindrome using start and end indices
 *
 * Time Complexity: O(n^2)
 * Space Complexity: O(1)
 */

public class LongestPalindrome {

    public static void main(String[] args) {

        // 🔹 Hardcoded input
        String s = "babad";

        System.out.println("Longest Palindrome: " + longestPalindrome(s));
    }

    public static String longestPalindrome(String s) {

        if (s == null || s.length() < 1)
            return "";

        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {

            // Odd length palindrome
            int len1 = expand(s, i, i);

            // Even length palindrome
            int len2 = expand(s, i, i + 1);

            int len = Math.max(len1, len2);

            if (len > end - start) {

                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    // Expand around center
    public static int expand(String s, int left, int right) {

        while (left >= 0 &&
               right < s.length() &&
               s.charAt(left) == s.charAt(right)) {

            left--;
            right++;
        }

        return right - left - 1;
    }
}