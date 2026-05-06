/**
 * Problem: Length of Last Word
 * Platform: LeetCode 58
 *
 * Description:
 * Given a string s consisting of words and spaces,
 * return the length of the last word in the string.
 *
 * A word is defined as a maximal substring consisting
 * of non-space characters only.
 *
 * Example:
 * Input: "Hello World" → Output: 5
 * Input: "   fly me   to   the moon  " → Output: 4
 *
 * Approach:
 * - Split the string using space " "
 * - Get the last word from the array
 * - Convert it to char array (optional)
 * - Return its length
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n) (due to split)
 */

public class LengthOfLastWord {

    public static void main(String[] args) {

        // 🔹 Hardcoded input
        String s = "Hello World";

        System.out.println("Length of Last Word: " + lengthOfLastWord(s));
    }

    public static int lengthOfLastWord(String s) {

        String[] arr = s.split(" ");

        String ans = arr[arr.length - 1];

        char[] arr1 = ans.toCharArray();

        int count = arr1.length;

        return count;
    }
}