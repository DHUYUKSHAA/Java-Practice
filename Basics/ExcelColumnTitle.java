/**
 * Problem: Excel Sheet Column Title
 * Platform: LeetCode 168
 *
 * Description:
 * Given an integer columnNumber, return its corresponding
 * Excel column title.
 *
 * Example:
 * Input: 1  → Output: "A"
 * Input: 28 → Output: "AB"
 * Input: 701 → Output: "ZY"
 *
 * Explanation:
 * Excel columns follow a pattern similar to base-26,
 * but there is no '0'. Instead it goes:
 * A = 1, B = 2, ..., Z = 26
 *
 * Approach:
 * - Use a loop while n > 0
 * - Reduce n by 1 (because no zero in Excel system)
 * - Get character:
 *      'A' + (n % 26)
 * - Add to front of result string
 * - Divide n by 26
 *
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 */

public class ExcelColumnTitle {

    public static void main(String[] args) {
        int columnNumber = 28; // change input here
        System.out.println(convertToTitle(columnNumber));
    }

    public static String convertToTitle(int columnNumber) {
        int n = columnNumber;
        String res = "";

        while (n > 0) {
            n--; // adjust for 1-based indexing

            res = (char) ('A' + (n % 26)) + res;

            n = n / 26;
        }

        return res;
    }
}