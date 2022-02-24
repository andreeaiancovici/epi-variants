package epi.arrays._6._9.variant;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Question:
 * Given an array A of integers representing a permutation,
 * update A to represent the inverse permutation using only constant additional storage.
 * ---
 * Memo:
 * Inverse permutation - indexes become values and values become indexes
 * [2,3,4,5,1] - original array
 * 0,1,2,3,4  - indexes
 *
 * [1,2,3,4,5] - indexes converted to values
 * 1,2,3,4,0  - values converted to indexes
 *
 * [5,1,2,3,4] - values converted to indexes, sorted by index position -> Inverse permutation
 * 0,1,2,3,4  - indexes converted to values, sorted
 *
 * If we start at any index and iteratively jump to the target index of the current one, we will trace out a cycle.
 * If any index is not in the cycle, it will create another cycle and both cycles will be disjoint.
 * So the idea is to resolve every cycle separately, by iterating over the indices and moving every element to the place it belongs.
 * E.g. cycles in [2,3,1,5,4]
 * 1 -> 2 -> 0
 * 4 -> 3
 * ---
 * Solution:
 * Iterate through the array. For each permutation (value - 1), start a cyclic process:
 * - check if permutation was not processed (in our case we will subtract the array length from each processed position);
 * - get next permutation index;
 * - set new value at permutation index (minus size of array, so we know it was processed)
 * - get next value to set on permutation index;
 * - repeat steps above until we reach a processed permutation, which means we finished a cycle.
 * ---
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class InversePermutation {

    public static void main(String[] args) {
        assertEquals(Arrays.asList(5, 1, 2, 3, 4),
                applyInversePermutation(Arrays.asList(2, 3, 4, 5, 1)));
        assertEquals(Arrays.asList(3, 1, 2, 5, 4),
                applyInversePermutation(Arrays.asList(2, 3, 1, 5, 4)));
    }

    public static List<Integer> applyInversePermutation(List<Integer> A) {
        // Iterate through all permutations and check if a cycle will start
        for (int i = 0; i < A.size(); i++) {
            // get value to be set
            int next = i;
            // get permutation index to set
            int perm = A.get(i) - 1;
            // until permutation is not processed a cycle will start
            while (perm >= 0) {
                // save next permutation index to process
                int temp = A.get(perm) - 1;
                // mark permutation position as processed
                A.set(perm, next + 1 - A.size());
                // get next value to be set at permutation index
                next = perm;
                perm = temp;
            }
        }

        // un-mark permutations (add size of array)
        for (int i = 0; i < A.size(); i++) {
            A.set(i, A.get(i) + A.size());
        }

        return A;
    }
}