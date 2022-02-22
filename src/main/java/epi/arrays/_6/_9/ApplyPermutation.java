package epi.arrays._6._9;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Question:
 * Given an array A of n elements and a permutation P, apply P to A.
 * A = [a,b,c,d]
 * P = [2,0,1,3]
 * R = [b,c,a,d]
 * ---
 * Memo:
 * If we start at any index and iteratively jump to the target index of the current one, we will trace out a cycle.
 * If any index is not in the cycle, it will create another cycle and both cycles will be disjoint.
 * So the idea is to resolve every cycle separately, by iterating over the indices and moving every element to the place it belongs.
 * E.g. cycles in above example
 * 0 -> 2 -> 1 -> 0
 * 3 -> 3
 * ---
 * Solution:
 * Iterate through the list of permutations. For each permutation, start a cyclic process:
 * - check if permutation was not processed (in our case we will make processed permutation negative);
 * - swap element at current index with permutation index;
 * - get next permutation index;
 * - mark permutation as processed (make it negative);
 * - repeat steps above until we reach a negative permutation, which means we finished a cycle.
 * ---
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class ApplyPermutation {

    public static void main(String[] args) {
        assertEquals(Arrays.asList('b', 'c', 'a', 'd'),
                applyPermutation(Arrays.asList(2, 0, 1, 3), Arrays.asList('a', 'b', 'c', 'd')));
    }

    public static List<Character> applyPermutation(List<Integer> perm, List<Character> A) {
        // Iterate through all permutations and check if a cycle will start
        for (int i = 0; i < A.size(); i++) {
            // get permutation index to swap
            int nextIndex = perm.get(i);
            // until permutation is not processed
            // this mean permutation is not negative and is different from characters (A) index
            // a cycle will start
            while (nextIndex > 0 && nextIndex != i) {
                Collections.swap(A, i, nextIndex);
                // save next permutation index to process
                int tempIndex = perm.get(nextIndex);
                // mark permutation position as processed
                perm.set(nextIndex, tempIndex - perm.size());
                nextIndex = tempIndex;
            }
        }
        return A;
    }
}
