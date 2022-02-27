package epi.arrays._6._10.variant;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Question:
 * Given a permutation p, return the permutation corresponding to the previous permutation
 * of p under dictionary ordering. If the permutation is the first permutation, return the
 * empty array.
 * ---
 * Solution:
 * The trick here is to take in consideration specific cases, in order to get the next permutation:
 * - [0,2,3,1]
 *  - last 2 digits are in decreasing order -> reverse them [0,2,1,3]
 * - [2,3,0,1]
 *  - starting with the end, find the first digit which is lower than its left neighbour -> 0
 *  - get the left neighbour -> 3 (if we arrived to -1, permutation is the first one)
 *  - reverse all digits from the right of left neighbour -> [0,1] -> [1,0]
 *  - starting with the end, find the biggest / last digit which is lower than the left neighbour -> 1
 *  - swap indexes -> [2,3,1,0]
 *  - final result -> [2,1,3,0]
 * ---
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class ComputePreviousPermutation {

    public static void main(String[] args) {
        assertEquals(Arrays.asList(0, 1, 3, 2), previousPermutation(Arrays.asList(0, 2, 1, 3)));
        assertEquals(Arrays.asList(0, 2, 1, 3), previousPermutation(Arrays.asList(0, 2, 3, 1)));
        assertEquals(Arrays.asList(0, 3, 1, 2), previousPermutation(Arrays.asList(0, 3, 2, 1)));
        assertEquals(Arrays.asList(3, 2, 0, 1), previousPermutation(Arrays.asList(3, 2, 1, 0)));
        assertEquals(Arrays.asList(1, 0, 3, 2), previousPermutation(Arrays.asList(1, 2, 0, 3)));
        assertEquals(Arrays.asList(2, 0, 3, 1), previousPermutation(Arrays.asList(2, 1, 0, 3)));
        assertEquals(Arrays.asList(1, 2, 3, 0), previousPermutation(Arrays.asList(1, 3, 0, 2)));
        assertEquals(Arrays.asList(2, 1, 3, 0), previousPermutation(Arrays.asList(2, 3, 0, 1)));
        assertEquals(Collections.emptyList(), previousPermutation(Arrays.asList(0, 1, 2, 3)));
    }

    private static List<Integer> previousPermutation(List<Integer> perm) {
        int n = perm.size();

        if (n == 1) {
            return Collections.emptyList();
        }

        // If last 2 digits are in decreasing order, reverse
        if (perm.get(n - 2) > perm.get(n - 1)) {
            Collections.swap(perm, n - 1, n - 2);
        } else {
            // Starting with the end, find the first digit which is lower than its left neighbour
            int index = n - 1;
            while (index > 0 && perm.get(index) >= perm.get(index - 1)) {
                index--;
            }

            // Get the left neighbour
            // If we arrived to the start, the perm is minimum
            int leftIndex = index - 1;
            if (leftIndex < 0) {
                return Collections.emptyList();
            }

            // Reverse the right side of the left neighbour
            int mid = (n - 1 - index) / 2;
            for (int j = 0; j <= mid; j++) {
                Collections.swap(perm, j + index, n - 1 - j);
            }

            // Otherwise, starting with the end, find the biggest / last digit which is lower than the left neighbour
            int rightIndex = n - 1;
            while (perm.get(rightIndex) < perm.get(leftIndex)) {
                rightIndex--;
            }

            Collections.swap(perm, leftIndex, rightIndex + 1);
        }

        return perm;
    }
}
