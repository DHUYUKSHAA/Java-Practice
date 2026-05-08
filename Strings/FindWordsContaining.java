/**
 * Problem: Find Words Containing Character
 * Platform: LeetCode 2942
 *
 * Description:
 * Given a 0-indexed array of strings words and a character x,
 * return an array of indices representing the words
 * that contain the character x.
 *
 * Example:
 * Input:
 * words = ["leet","code"]
 * x = 'e'
 *
 * Output:
 * [0,1]
 *
 * Explanation:
 * - "leet" contains 'e'
 * - "code" contains 'e'
 *
 * Approach:
 * - Traverse each word
 * - Convert word into character array
 * - Check whether character x exists
 * - If found:
 *      add index to result list
 *      break to avoid duplicate insertion
 *
 * Time Complexity: O(n * m)
 * n = number of words
 * m = average word length
 *
 * Space Complexity: O(1)
 * (excluding output list)
 */

import java.util.*;

public class FindWordsContaining {

    public static void main(String[] args) {

        // 🔹 Hardcoded input
        String[] words = {"leet", "code", "java", "python"};
        char x = 'e';

        List<Integer> result = findWordsContaining(words, x);

        System.out.println("Indices: " + result);
    }

    public static List<Integer> findWordsContaining(String[] words, char x) {

        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {

            char[] arr = words[i].toCharArray();

            for (int j = 0; j < arr.length; j++) {

                if (arr[j] == x) {
                    res.add(i);
                    break;
                }
            }
        }

        return res;
    }
}