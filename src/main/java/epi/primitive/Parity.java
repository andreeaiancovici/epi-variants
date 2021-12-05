package epi.primitive;

import static org.junit.Assert.assertEquals;

/*
The parity of a binary word is 1 if the number of Is in the word is odd; otherwise,
it is 0. Compute the parity of a 64-bit number.
Time Complexity: O(n)
Space Complexity: O(1)
 */
public class Parity {

    public static void main(String[] args) {
        assertEquals(0, parity(123L));
    }

    private static short parity(long x) {
        short parity = 0;
        while(x != 0) {
            parity ^= (x & 1);
            x >>>= 1;
        }
        return parity;
    }
}
