package epi.primitive;

import static org.junit.Assert.assertEquals;

/**
 * Question:
 * Count the number of bits that are set to 1 in an integer.
 * ---
 * Solution:
 * We start iterating through each bit in the integer, starting from right to left.
 * When one bit is processed using a 1 MASK, unsigned right-shift operation is applied
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
        while (x != 0) {
            // Check if last bit is 1
            if ((x & 1) == 1) {
                count++;
            }
            // Unsigned right shift x in order to process the next bit
            x >>>= 1;
        }
        return count;
    }
}
