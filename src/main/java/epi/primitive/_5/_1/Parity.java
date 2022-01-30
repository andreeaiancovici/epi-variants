package epi.primitive._5._1;

import static org.junit.Assert.assertEquals;

/**
 * Question:
 * The parity of a binary word is 1 if the number of 1s in the word is odd; otherwise, it is 0.
 * Compute the parity of a 64-bit number.
 * ---
 * Solution:
 * XOR trick -> 1 ^ 1 = 0 and 0 ^ 0 = 0
 * Therefore, when iterating through bits in the 64-bit number:
 * - having an even number of 1s will result in parity 0 (for each 1 there is a corresponding 1 -> 0 parity)
 * - having an odd number of 1s will result in parity 1 (there is one 1 which doesn't have a corresponding 1 -> 1 parity)
 * ---
 * Time Complexity: O(n) -> n is the number of bits in the 64-bit number
 * Space Complexity: O(1)
 */
public class Parity {

    public static void main(String[] args) {
        assertEquals(0, parity(123L));
    }

    private static short parity(long x) {
        short parity = 0;
        while(x != 0) {
            // We recompute parity at each step:
            // - if there is an even number of 1s, parity becomes 1 (each 1 has a matching partner -> 1 ^ 1 = 0)
            // - if there is an odd number  of 1s, parity becomes 0 (one 1 is left without a matching partner -> 0 ^ 1 = 1)
            parity ^= (x & 1);
            // Unsigned right shift x in order to process the next bit
            x >>>= 1;
        }
        return parity;
    }
}
