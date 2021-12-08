package epi.primitive;

import static org.junit.Assert.assertEquals;

/*
Write a program that takes a 64-bit word and returns the 64-bit word consisting of
the bits of the input word in reverse order.
Time Complexity: O(n/16)
Space Complexity: O(1)
 */
public class ReverseBits {

    // 16 bit long cache
    private static final long[] precomputedReverse = new long[1 << 16];

    private static long swapBits(long x, int i, int j) {
        long iBit = (x >>> i) & 1;
        long jBit = (x >>> j) & 1;
        if(iBit != jBit) {
            x ^= (1L << i);
            x ^= (1L << j);
        }
        return x;
    }

    private static long reverseBits(long x, int n) {
        for(int i = 0, j = n; i < j; i++, j--) {
            x = swapBits(x, i, j);
        }
        return x;
    }

    static {
        for(int i = 0; i < (1 << 16); i++) {
            precomputedReverse[i] = reverseBits(i, 15);
        }
    }

    public static void main(String[] args) {
        assertEquals(405942121183313920L, reverseBits(1351510410656L));
    }

    private static long reverseBits(long x) {
        int WORD_SIZE = 16;
        int BIT_MASK = 0xffff;
        return precomputedReverse[(int) (x & BIT_MASK)] << (3 * WORD_SIZE)
                | precomputedReverse[(int) ((x >>> WORD_SIZE) & BIT_MASK)] << (2 * WORD_SIZE)
                | precomputedReverse[(int) ((x >>> (2 * WORD_SIZE)) & BIT_MASK)] << WORD_SIZE
                | precomputedReverse[(int) ((x >>> (3 * WORD_SIZE)) & BIT_MASK)];
    }
}