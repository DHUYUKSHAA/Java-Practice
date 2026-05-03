/**
 * Problem: Palindrome Number
 * Platform: LeetCode 9
 *
 * Description:
 * Given an integer x, return true if x is a palindrome,
 * and false otherwise.
 *
 * A palindrome reads the same forward and backward.
 *
 * Example:
 * Input: x = 121
 * Output: true
 *
 * Input: x = -121
 * Output: false
 *
 * Input: x = 123
 * Output: false
 *
 * Explanation:
 * 121 → reverse → 121 → same → palindrome ✔
 * 123 → reverse → 321 → different → not palindrome ❌
 *
 * Approach:
 * - Negative numbers are not palindrome
 *
 * - Store original number in temp
 *
 * - Reverse the number:
 *      digit = x % 10
 *      rev = rev * 10 + digit
 *      x = x / 10
 *
 * - Compare reversed number with original
 *
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 */

import java.util.*;

public class PalindromeNumber {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number: ");
        int x = sc.nextInt();

        boolean result = isPalindrome(x);

        System.out.println("Is Palindrome: " + result);
    }

    public static boolean isPalindrome(int x) {

        if (x < 0) return false;

        int temp = x;
        int rev = 0;

        while (x > 0) {
            int digit = x % 10;
            rev = rev * 10 + digit;
            x = x / 10;
        }

        return rev == temp;
    }
}