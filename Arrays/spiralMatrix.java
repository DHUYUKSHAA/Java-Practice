// Problem: Spiral Matrix II
// Platform: LeetCode
// Link: https://leetcode.com/problems/spiral-matrix-ii/

// Description:
// Given an integer n, generate an n x n matrix filled with elements
// from 1 to n^2 in spiral order.

// Approach:
// Use four boundaries: top, bottom, left, right.
// Fill the matrix in spiral order in 4 directions:
// 1. Left → Right
// 2. Top → Bottom
// 3. Right → Left
// 4. Bottom → Top
// After each direction, shrink the boundaries.

// Time Complexity: O(n^2)
// Space Complexity: O(n^2)

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
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        // Call 
        List<Integer> result = spiralOrder(matrix);

        // Output
        System.out.println(result);
    }

    public static List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> result = new ArrayList<>();

        int top = 0;
        int bottom = matrix.length - 1; // row
        int left = 0;
        int right = matrix.length - 1; // column

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