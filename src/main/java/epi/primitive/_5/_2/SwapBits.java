package epi.primitive._5._2;

import static org.junit.Assert.assertEquals;

/**
 * Question:
 * Implement code that takes as input a 64-bit integer and swaps the bits at indices i and j.
 * ---
 * Memo:
 * XOR trick -> 0 ^ 1 = 1 and 1 ^ 1 = 0
 * Therefore, we can change a bit:
 * - from 0 to 1
 * and
 * - from 1 to 0
 * by applying XOR 1.
 * ---
 * Solution:
 * We unsigned right shift x by i and j and apply a 1 MASK to isolate the bits.
 * If these bits are different, we swap them:
 * - we generate a MASK by left shifting 1 with i bits and do XOR
 * - we generate a MASK by left shifting 1 with j bits and do XOR
 * ---
 * Time Complexity: O(1)
 * Space Complexity: O(1)
 */
public class SwapBits {

    public static void main(String[] args) {
        assertEquals(19574056063140L, swapBits(19574056046756L, 15, 14));
    }

    private static long swapBits(long x, int i, int j) {
        // Unsigned right shift x with i and j and apply 1 MASK
        // Check if bits are different
        if (((x >>> i) & 1) != ((x >>> j) & 1)) {
            // XOR the i-th bit with 1 and change it
            x ^= (1L << i);
            // XOR the j-th bit with 1 and change it
            x ^= (1L << j);
        }
        return x;
    }
}
