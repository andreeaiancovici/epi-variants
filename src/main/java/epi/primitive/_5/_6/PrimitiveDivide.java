package epi.primitive._5._6;

import static org.junit.Assert.assertEquals;

/**
 * Question:
 * Given two positive integers, compute their quotient, using only the addition, subtraction, and shifting operators.
 * ---
 * Solution:
 * Find largest k such that 2^k * y <= x (2^k is a multiple for y).
 * Subtract 2^k * y from and add 2^k to result.
 * ---
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class PrimitiveDivide {

    public static void main(String[] args) {
        assertEquals(3, divide(12, 4));
    }

    private static int divide(int x, int y) {
        // Start with a large power of 2 (2^32 * y)
        long yPower = (long) y << 32;
        int result = 0;
        int power = 32;
        while (x >= y) {
            // Divide 2^32 * y by 2 until it's smaller than x
            while (yPower > x) {
                yPower >>>= 1;
                power--;
            }
            // Add 2^(found power) to result
            result += (1 << power);
            // Subtract 2^(found power) * y from x
            x -= yPower;
        }
        return result;
    }
}
