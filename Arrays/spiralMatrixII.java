/**
 * Problem: Spiral Matrix II
 * Platform: LeetCode 59
 *
 * Description:
 * Given an integer n, generate an n x n matrix filled with elements
 * from 1 to n^2 in spiral order.
 *
 * Example:
 * Input: n = 3
 * Output:
 * [
 *  [1, 2, 3],
 *  [8, 9, 4],
 *  [7, 6, 5]
 * ]
 *
 * Approach:
 * - Use 4 boundaries: top, bottom, left, right
 * - Fill the matrix in spiral order:
 *   1. Left → Right
 *   2. Top → Bottom
 *   3. Right → Left
 *   4. Bottom → Top
 * - After each step, shrink the boundaries
 *
 * Time Complexity: O(n^2)
 * Space Complexity: O(n^2)
 */

public class SpiralMatrixII {

    public static void main(String[] args) {
        int n = 3; // You can change this value

        int[][] result = generateMatrix(n);

        // Print the matrix
        System.out.println("Spiral Matrix for n = " + n + ":\n");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(result[i][j] + "\t");
            }
            System.out.println();
        }
    }

    /**
     * Generates a spiral matrix of size n x n
     */
    public static int[][] generateMatrix(int n) {

        // Create n x n matrix
        int[][] matrix = new int[n][n];

        // Define boundaries
        int top = 0;
        int bottom = n - 1;
        int left = 0;
        int right = n - 1;

        int num = 1; // Start filling from 1

        // Loop until boundaries cross
        while (top <= bottom && left <= right) {

            // 1. Fill top row (left → right)
            for (int i = left; i <= right; i++) {
                matrix[top][i] = num++;
            }
            top++; // move top boundary down

            // 2. Fill right column (top → bottom)
            for (int i = top; i <= bottom; i++) {
                matrix[i][right] = num++;
            }
            right--; // move right boundary left

            // 3. Fill bottom row (right → left)
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    matrix[bottom][i] = num++;
                }
                bottom--; // move bottom boundary up
            }

            // 4. Fill left column (bottom → top)
            if (left <= right) {   // ✅ Correct condition
                for (int i = bottom; i >= top; i--) {
                    matrix[i][left] = num++;
                }
                left++; // move left boundary right
            }
        }

        return matrix;
    }
}
