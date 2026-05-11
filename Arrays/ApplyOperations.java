/**
 * Problem: Apply Operations to an Array
 * Platform: LeetCode 2460
 *
 * Description:
 * You are given a 0-indexed array nums.
 *
 * Perform the following operations:
 *
 * - If nums[i] == nums[i+1]:
 *      nums[i] = nums[i] * 2
 *      nums[i+1] = 0
 *
 * - After performing all operations,
 *   shift all zeros to the end of the array.
 *
 * Example:
 * Input: [1,2,2,1,1,0]
 * Output: [1,4,2,0,0,0]
 *
 * Explanation:
 *
 * Step 1:
 * [1,2,2,1,1,0]
 *      2 == 2 → 4,0
 * → [1,4,0,1,1,0]
 *
 * Step 2:
 *      1 == 1 → 2,0
 * → [1,4,0,2,0,0]
 *
 * Step 3:
 * Move zeros to end
 * → [1,4,2,0,0,0]
 *
 * Approach:
 * Part 1:
 * - Traverse array
 * - If adjacent elements are equal:
 *      double current element
 *      make next element 0
 *
 * Part 2 (Move Zeroes):
 * - Use two pointers:
 *      z  → position for non-zero
 *      nz → current traversal pointer
 *
 * - Swap non-zero elements forward
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

public class ApplyOperations {

    public static void main(String[] args) {

        // 🔹 Hardcoded input
        int[] nums = {1, 2, 2, 1, 1, 0};

        int[] result = applyOperations(nums);

        System.out.print("Output: ");

        for (int val : result) {
            System.out.print(val + " ");
        }
    }

    public static int[] applyOperations(int[] nums) {

        // Step 1: Apply operations
        for (int i = 0; i < nums.length - 1; i++) {

            if (nums[i] == nums[i + 1]) {

                nums[i] = nums[i] * 2;

                nums[i + 1] = 0;
            }
        }

        // Step 2: Move zeros to end
        int z = 0;
        int nz = 0;

        while (nz < nums.length) {

            if (nums[nz] == 0) {

                nz++;
            }
            else {

                int temp = nums[z];
                nums[z] = nums[nz];
                nums[nz] = temp;

                z++;
                nz++;
            }
        }

        return nums;
    }
}