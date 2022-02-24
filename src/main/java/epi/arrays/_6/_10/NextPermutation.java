package epi.arrays._6._10;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Question:
 * Write a program that takes as input a permutation, and returns the next permutation
 * under dictionary ordering. If the permutation is the last permutation, return the
 * empty array.
 * ---
 * Solution:
 * The trick here is to take in consideration specific cases, in order to get the next permutation:
 * - [0,2,1,3]
 *  - last 2 digits are in increasing order -> reverse them [0,2,3,1]
 * - [0,3,2,1]
 *  - starting with the end, find the first digit which is greater than its left neighbour -> 3
 *  - get the left neighbour (let's call it index1) -> 0 (if we arrived to -1, permutation is the last one)
 *  - starting with the end, find the first digit which is equal or lower than the digit we search at the first step (let's call it index2) -> 1
 *  - swap indexes -> [1,3,2,0]
 *  - reverse all digit from the right of our first found digit -> [2,0] -> [0,2]
 *  - final result -> [1,3,0,2]
 * ---
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class NextPermutation {

    public static void main(String[] args) {
        assertEquals(Arrays.asList(0, 2, 3, 1), nextPermutation(Arrays.asList(0, 2, 1, 3)));
        assertEquals(Arrays.asList(0, 3, 1, 2), nextPermutation(Arrays.asList(0, 2, 3, 1)));
        assertEquals(Arrays.asList(1, 0, 2, 3), nextPermutation(Arrays.asList(0, 3, 2, 1)));
        assertEquals(Collections.emptyList(), nextPermutation(Arrays.asList(3, 2, 1, 0)));
    }

    private static List<Integer> nextPermutation(List<Integer> perm) {
        int n = perm.size();

        if (n == 1) {
            return Collections.emptyList();
        }

        // If last 2 digits are in increasing order, reverse
        if (perm.get(n - 2) < perm.get(n - 1)) {
            Collections.swap(perm, n - 1, n - 2);
        } else {
            // Starting with the end, find the first digit which is greater than its left neighbour
            int index = n - 1;
            while (index > 0 && perm.get(index) <= perm.get(index - 1)) {
                index--;
            }

            // Get the left neighbour
            // If we arrived to the start, the perm is maximum
            int leftIndex = index - 1;
            if (leftIndex < 0) {
                return Collections.emptyList();
            }

            // Otherwise, starting with the end, find the first digit which is equal or lower than the index found at first step
            int rightIndex = n - 1;
            while (perm.get(rightIndex) <= perm.get(leftIndex)) {
                rightIndex--;
            }

            Collections.swap(perm, leftIndex, rightIndex);

            // Swap the right side of the found at first step
            int mid = (n - 1 - index) / 2;
            for (int j = 0; j <= mid; j++) {
                Collections.swap(perm, j + index, n - 1 - j);
            }
        }
        return perm;
    }
}
