package epi.primitive;

import static org.junit.Assert.assertEquals;

/*
Implement code that takes as input a 64-bit integer
and swaps the bits at indices i and j.
Time Complexity: O(1)
Space Complexity: O(1)
 */
public class SwapBits {

    public static void main(String[] args) {
        assertEquals(19574056063140L, swapBits(19574056046756L, 15, 14));
    }

    private static long swapBits(long x, int i, int j) {
        if (((x >>> i) & 1) != ((x >>> j) & 1)) {
            x ^= (1L << i);
            x ^= (1L << j);
        }
        return x;
    }
}
