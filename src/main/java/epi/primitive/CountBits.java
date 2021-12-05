package epi.primitive;

import static org.junit.Assert.assertEquals;

/*
Count the number of bits that are set to 1 in an integer.
Time Complexity: O(n)
Space Complexity: O(1)
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
