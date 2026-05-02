/**
 * Problem: Set Matrix Zeroes
 * Platform: LeetCode 73
 *
 * Description:
 * If any element in matrix is 0,
 * set its entire row and column to 0.
 *
 * Approach:
 * - Use two arrays to mark rows and columns
 * - First pass: mark rows[i] and cols[j] if matrix[i][j] == 0
 * - Second pass: set matrix[i][j] = 0 if row[i] or col[j] is marked
 *
 * Time Complexity: O(n * m)
 * Space Complexity: O(n + m)
 */

public class SetMatrixZeroes {

    public static void main(String[] args) {

        int[][] matrix = {
            {1,1,1},
            {1,0,1},
            {1,1,1}
        };

        setZeroes(matrix);

        // print result
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void setZeroes(int[][] matrix) {

        int n = matrix.length;
        int m = matrix[0].length;

        boolean[] row = new boolean[n];
        boolean[] col = new boolean[m];

        // mark rows and columns
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }

        // set zeroes
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (row[i] || col[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}