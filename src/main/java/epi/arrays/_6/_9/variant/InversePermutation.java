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
 * ---
 * Solution:
 * ---
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class InversePermutation {

    public static void main(String[] args) {
        assertEquals(Arrays.asList(5, 1, 2, 3, 4),
                applyInversePermutation(Arrays.asList(2, 3, 4, 5, 1)));
    }

    public static List<Integer> applyInversePermutation(List<Integer> A) {
        for (int i = 0; i < A.size(); i++) {
            int next = i;
            int perm = A.get(i) - 1;
            while (perm >= 0) {
                int temp = A.get(perm) - 1;
                A.set(perm, next + 1 - A.size());
                next = perm;
                perm = temp;
            }
        }

        for (int i = 0; i < A.size(); i++) {
            A.set(i, A.get(i) + A.size());
        }

        return A;
    }
}