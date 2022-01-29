package epi.primitive;

import static org.junit.Assert.assertEquals;

/**
 * Question:
 * Count the number of bits that are set to 1 in an integer.
 * ---
 * Solution:
 * We start iterating through each bit in the integer, starting from right to left.
 * When one bit is processed using a mask, unsigned right-shift operation is applied
 * in order to advance to the next left bit.
 * ---
 * Time Complexity: O(n) -> n is the number of bits in the integer
 * Space Complexity: O(1)
 */
public class CountBits {

    public static void main(String[] args) {
        assertEquals(6, countBits(123));
    }

    private static short countBits(int x) {
        short count = 0;
        int lastBit;
        while (x != 0) {
            lastBit = x & 1;
            if (lastBit == 1) {
                count++;
            }
            x >>>= 1;
        }
        return count;
    }
}
