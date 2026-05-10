/**
 * Problem: Valid Anagram
 * Platform: LeetCode 242
 *
 * Description:
 * Given two strings s and t,
 * return true if t is an anagram of s,
 * otherwise return false.
 *
 * An anagram is formed by rearranging
 * the letters of another word
 * using all original characters exactly once.
 *
 * Example:
 * Input:
 * s = "anagram"
 * t = "nagaram"
 *
 * Output:
 * true
 *
 * Example:
 * Input:
 * s = "rat"
 * t = "car"
 *
 * Output:
 * false
 *
 * Approach (Frequency Count):
 * - If lengths are different:
 *      cannot be anagram
 *
 * - Create frequency array of size 26
 *   for lowercase English letters
 *
 * - Traverse both strings together:
 *      increment count for s characters
 *      decrement count for t characters
 *
 * - If all frequencies become 0:
 *      strings are anagrams
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

public class ValidAnagram {

    public static void main(String[] args) {

        // 🔹 Hardcoded input
        String s = "anagram";
        String t = "nagaram";

        System.out.println("Is Anagram: " + isAnagram(s, t));
    }

    public static boolean isAnagram(String s, String t) {

        // Length check
        if (s.length() != t.length()) {
            return false;
        }

        int[] freq = new int[26];

        // Frequency count
        for (int i = 0; i < s.length(); i++) {

            freq[s.charAt(i) - 'a']++;

            freq[t.charAt(i) - 'a']--;
        }

        // Verify all counts become zero
        for (int charr : freq) {

            if (charr != 0) {
                return false;
            }
        }

        return true;
    }
}