package epi.primitive._5._3;

import static org.junit.Assert.assertEquals;

/**
 * Question:
 * Write a program that takes a 64-bit word and returns the 64-bit word consisting of
 * the bits of the input word in reverse order.
 * ---
 * Memo:
 * OR trick: You can compute bit sub-parts of a number and then combine them using OR operator.
 * ---
 * Solution:
 * Brute-force: Reverse the first 32 bits with their counterparts.
 * For repeatedly performed operation, we can use a look-up table (CACHE).
 * In our case, we chose to have a look-up table containing all reversed mappings for 16-bit numbers.
 * We will split our 64-bit number into 4 sections of 16 bits.
 * TO-DO:
 * Why did we choose 16-bit CACHE?
 * An array size is defined by an integer, which in Java can have a maximum size of 2^31−1.
 * Therefore we cannot define a CACHE for 32-bit numbers.
 * ---
 * Time Complexity for computing CACHE (one time): O(2^16) = 65536
 * Time Complexity: O(n/L) - L is size of cache; repeatedly performed operation
 * Space Complexity: O(1)
 */
public class ReverseBits {

    // 16 bit long cache
    private static final long[] precomputedReverse = new long[1 << 16];

    private static long swapBits(long x, int i, int j) {
        // If bits at positions i and j are different, we swap them
        if (((x >>> i) & 1) != ((x >>> j) & 1)) {
            // XOR-ing a bit with 1 will swap its value
            // 0 ^ 1 -> 1
            // 1 ^ 1 -> 0
            x ^= (1L << i);
            x ^= (1L << j);
        }
        return x;
    }

    private static long reverseBits(long x, int n) {
        // Until i = 0 meets j = 15, we reverse each bit with its counterpart
        // Or simply put, until we get to the middle
        for (int i = 0, j = n; i < j; i++, j--) {
            x = swapBits(x, i, j);
        }
        return x;
    }

    static {
        // For all 16-bit numbers we compute the reversed bit form
        for (int i = 0; i < (1 << 16); i++) {
            precomputedReverse[i] = reverseBits(i, 15);
        }
    }

    public static void main(String[] args) {
        assertEquals(405942121183313920L, reverseBits(1351510410656L));
    }

    private static long reverseBits(long x) {
        int WORD_SIZE = 16;
        int BIT_MASK = 0xffff;
        return  // Compute from CACHE 16 bits from positions [47;63] and move them to positions [0;15]
                precomputedReverse[(int) (x & BIT_MASK)] << (3 * WORD_SIZE)
                        // Compute from CACHE 16 bits from positions [31;47] and move them to positions [15;31]
                        | precomputedReverse[(int) ((x >>> WORD_SIZE) & BIT_MASK)] << (2 * WORD_SIZE)
                        // Compute from CACHE 16 bits from positions [15;31] and move them to positions [31;47]
                        | precomputedReverse[(int) ((x >>> (2 * WORD_SIZE)) & BIT_MASK)] << WORD_SIZE
                        // Compute from CACHE 16 bits from positions [0;15] and move them to positions [47;63]
                        | precomputedReverse[(int) ((x >>> (3 * WORD_SIZE)) & BIT_MASK)];
    }
}