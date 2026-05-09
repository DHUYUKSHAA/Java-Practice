/**
 * Problem: Island Perimeter
 * Platform: LeetCode 463
 *
 * Description:
 * You are given a grid where:
 * - 1 represents land
 * - 0 represents water
 *
 * The grid contains exactly one island.
 *
 * Return the perimeter of the island.
 *
 * Example:
 * Input:
 * [
 *   [0,1,0,0],
 *   [1,1,1,0],
 *   [0,1,0,0],
 *   [1,1,0,0]
 * ]
 *
 * Output: 16
 *
 * Approach (DFS):
 * - Traverse grid to find first land cell
 * - Start DFS traversal
 *
 * DFS Rules:
 * - If out of boundary OR water:
 *      contributes 1 to perimeter
 *
 * - If already visited:
 *      contributes 0
 *
 * - Mark visited land as -1
 * - Explore all 4 directions
 *
 * Time Complexity: O(m * n)
 * Space Complexity: O(m * n)
 * (recursive stack in worst case)
 */

public class IslandPerimeter {

    public static void main(String[] args) {

        // 🔹 Hardcoded input
        int[][] grid = {
            {0, 1, 0, 0},
            {1, 1, 1, 0},
            {0, 1, 0, 0},
            {1, 1, 0, 0}
        };

        System.out.println("Island Perimeter: " + islandPerimeter(grid));
    }

    public static int islandPerimeter(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        // Find first land cell
        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {

                if (grid[i][j] == 1) {
                    return dfs(i, j, grid);
                }
            }
        }

        return 0;
    }

    public static int dfs(int i, int j, int[][] grid) {

        // Water or boundary contributes 1
        if (i < 0 || j < 0 ||
            i >= grid.length ||
            j >= grid[0].length ||
            grid[i][j] == 0) {

            return 1;
        }

        // Already visited
        if (grid[i][j] == -1) {
            return 0;
        }

        // Mark visited
        grid[i][j] = -1;

        // Explore 4 directions
        return dfs(i + 1, j, grid) +
               dfs(i - 1, j, grid) +
               dfs(i, j + 1, grid) +
               dfs(i, j - 1, grid);
    }
}