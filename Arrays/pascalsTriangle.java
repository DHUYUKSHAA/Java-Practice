// Problem: Pascal's Triangle
// Platform: LeetCode
// Problem No: 118
// Link: https://leetcode.com/problems/pascals-triangle/

// Approach:
// We build the triangle row by row.
// Each row starts and ends with 1.
// For middle elements, we use the previous row:
// value = prevRow[j-1] + prevRow[j]

// Time Complexity: O(n^2)
// Space Complexity: O(n^2)

import java.util.*;

public class pascalsTriangle {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input number of rows
        int n = sc.nextInt();

        List<List<Integer>> result = generate(n);

        // Print result
        System.out.println(result);
    }

    public static List<List<Integer>> generate(int n) {

        List<List<Integer>> answer = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            List<Integer> row = new ArrayList<>();

            for (int j = 0; j <= i; j++) {

                // First and last elements are always 1
                if (j == 0 || j == i) {
                    row.add(1);
                } 
                else {
                    // Middle elements
                    int val = answer.get(i - 1).get(j - 1) 
                            + answer.get(i - 1).get(j);
                    row.add(val);
                }
            }
            
            answer.add(row);
        }

        return answer;
    }
}