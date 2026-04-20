// Problem: Spiral Matrix
// Platform: LeetCode
// Link: https://leetcode.com/problems/spiral-matrix/

// Approach:
// Traverse the matrix layer by layer using four boundaries:
// top, bottom, left, right.
// Move in 4 directions: left→right, top→bottom, right→left, bottom→top.

// Time Complexity: O(m * n)
// Space Complexity: O(1) (excluding output list)

import java.util.*;

public class spiralMatrix {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input for row
        int m = sc.nextInt();
        // Input for coloumn
        int n = sc.nextInt();

        int[][] matrix = new int[m][n];

        // Input for matrix 
        System.out.println("Enter matrix elements:");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        // Call 
        List<Integer> result = spiralOrder(matrix);

        // Output
        System.out.println("Spiral Order:");
        System.out.println(result);
    }

    public static List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> result = new ArrayList<>();

        int top = 0;
        int bottom = matrix.length - 1; // row
        int left = 0;
        int right = matrix[0].length - 1; // column

        while (top <= bottom && left <= right) {

            // left → right
            for (int j = left; j <= right; j++) {
                result.add(matrix[top][j]);
            }
            top++;

            // top → bottom
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;

            // right → left
            if (top <= bottom) {
                for (int j = right; j >= left; j--) {
                    result.add(matrix[bottom][j]);
                }
                bottom--;
            }

            // bottom → top
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }

        return result;
    }
}