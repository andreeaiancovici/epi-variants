package epi.arrays._6._10.variant;

import java.util.*;

import static org.junit.Assert.assertEquals;

/**
 * Question:
 * Compute the k-th permutation under dictionary ordering, starting from the identity permutation
 * (which is the first permutation in dictionary ordering).
 * ---
 * Solution:
 * Here is an example of permutations in dictionary ordering:
 * 0,1,2,3
 * 0,1,3,2
 * 0,2,1,3
 * 0,2,3,1
 * 0,3,1,2
 * 0,3,2,1
 * -------
 * 1,0,2,3
 * 1,0,3,2
 * 1,2,0,3
 * 1,2,3,0
 * 1,3,0,2
 * 1,3,2,0
 * -------
 * 2,0,1,3
 * 2,0,3,1
 * 2,1,0,3
 * 2,1,3,0
 * 2,3,0,1
 * 2,3,1,0
 * ...and so on.
 * Let's say we want to search the 10th permutation.
 * Notice how the first digit follows an ascending order:
 * - the first 6 permutations have 0 on first position;
 * - the next 6 permutations have 1 on first position and so on.
 * We observe that there are actually 6 permutations with 0 on first position, because the last 3 digits can form 3! = 6 permutations.
 * For determining the first digit in the result, we simply divide 10 / 6 = 1, so the first position is 1.
 * Be aware that if k is a multiple of 6, we should take in consideration the previous index.
 * E.g. k = 6 -> 6 / 6 = 1, but first digit is actually 0, not 1.
 * We repeat the previous steps for next digits, minimizing k and removing used digit from permutation array.
 * ---
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class ComputeKthPermutation {

    public static void main(String[] args) {
        assertEquals(Arrays.asList(0, 3, 1, 2), kthPermutation(Arrays.asList(0, 1, 2, 3), 5));
        assertEquals(Arrays.asList(1, 2, 3, 0), kthPermutation(Arrays.asList(0, 1, 2, 3), 10));
        assertEquals(Arrays.asList(2, 0, 1, 3), kthPermutation(Arrays.asList(0, 1, 2, 3), 13));
    }

    private static List<Integer> kthPermutation(List<Integer> perm, int k) {
        List<Integer> result = new ArrayList<>(Collections.nCopies(perm.size(), 0));
        List<Integer> mutablePerm = new ArrayList<>(perm);

        // Compute (n - 1)! factorial, where n is the size of the permutation
        int permFactorial = 1;
        for (int i = perm.size() - 1; i > 1; i--) {
            permFactorial *= i;
        }

        // Compute each permutation digit
        for (int i = 0; i < perm.size() - 1; i++) {
            int c = k / permFactorial;
            int r = k % permFactorial;

            int pIndex;
            if (r == 0) {
                // Get index from permutation array
                pIndex = c - 1;
                // Recompute searched position (k) in new boundaries
                k -= (c - 1) * permFactorial;
            } else {
                // Get index from permutation array
                pIndex = c;
                k = r;
            }

            // Set permutation digit
            result.set(i, mutablePerm.get(pIndex));

            // Recompute remaining factorial
            permFactorial /= (mutablePerm.size() - 1);
            // Remove permutation digit from array
            mutablePerm.remove(pIndex);
        }

        // Set last remaining index with last remaining permutation digit
        result.set(result.size() - 1, mutablePerm.get(0));

        return result;
    }
}
