/**
 * Problem: Fibonacci Number
 * Platform: LeetCode 509
 *
 * Description:
 * The Fibonacci sequence is defined as:
 *
 * F(0) = 0
 * F(1) = 1
 * F(n) = F(n-1) + F(n-2)
 *
 * Given n, return F(n).
 *
 * Example:
 * Input: n = 4
 * Output: 3
 *
 * Explanation:
 * F(0)=0
 * F(1)=1
 * F(2)=1
 * F(3)=2
 * F(4)=3
 *
 * Approach (Iterative - Best):
 * - Use two variables to store previous values
 * - Build result step by step
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

public class Fibonacci {

    public static void main(String[] args) {
        int n = 6;
        System.out.println(fib(n));
    }

    public static int fib(int n) {

        if (n == 0) return 0;
        if (n == 1) return 1;

        int prev1 = 1; // F(1)
        int prev2 = 0; // F(0)

        for (int i = 2; i <= n; i++) {
            int curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }
}