/**
 * Problem: Rotate Image
 * Platform: LeetCode 48
 *
 * Description:
 * You are given an n x n 2D matrix representing an image.
 *
 * Rotate the image by 90 degrees clockwise.
 *
 * Example:
 * Input:
 * [
 *   [1,2,3],
 *   [4,5,6],
 *   [7,8,9]
 * ]
 *
 * Output:
 * [
 *   [7,4,1],
 *   [8,5,2],
 *   [9,6,3]
 * ]
 *
 * Approach:
 * - Create a new matrix res[][]
 * - Traverse column by column
 * - Fill rows using bottom-to-top elements
 *
 * Rotation Logic:
 *
 * Original:
 * 1 2 3
 * 4 5 6
 * 7 8 9
 *
 * First column (1,4,7)
 * becomes first row in reverse:
 * 7 4 1
 *
 * Formula Used:
 *      res[j][n-1-i] = matrix[i][j]
 *
 * After filling res[][]:
 * - Copy res back into original matrix
 *
 * Time Complexity: O(n^2)
 * Space Complexity: O(n^2)
 */

public class RotateImage {

    public static void main(String[] args) {

        // 🔹 Hardcoded input
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        rotate(matrix);

        System.out.println("Rotated Matrix:");

        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }

            System.out.println();
        }
    }

    public static void rotate(int[][] matrix) {

        int n = matrix.length;

        int[][] res = new int[n][n];

        // Fill rotated matrix
        for (int j = 0; j < n; j++) {

            for (int i = n - 1; i >= 0; i--) {

                res[j][n - 1 - i] = matrix[i][j];
            }
        }

        // Copy back to original matrix
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {

                matrix[i][j] = res[i][j];
            }
        }
    }
}