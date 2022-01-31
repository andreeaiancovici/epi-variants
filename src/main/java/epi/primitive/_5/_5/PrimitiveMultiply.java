package epi.primitive._5._5;

import static org.junit.Assert.assertEquals;

/**
 * Question:
 * Write a program that multiplies two non-negative integers.
 * The only operators you are allowed to use are:
 * • assignment;
 * • the bitwise operators >>, <<, |, &, ~, ^;
 * • equality checks and Boolean combinations thereof.
 * You may use loops and functions that you write yourself.
 * These constraints imply, for example, that you cannot use increment or decrement, or test if x < y.
 * ---
 * Solution:
 * Use primitive algorithm for multiplication:
 *   11010 *
 *      11
 *   -----
 *   11010
 *  110100
 *  ------
 * 1001110
 * ---
 * Multiply using shift and &.
 * Add using shift, & and |.
 * Time Complexity: O(n^2) -> n from first while (multiply) * n from second while (add)
 * Space Complexity: O(1)
 */
public class PrimitiveMultiply {

    public static void main(String[] args) {
        assertEquals(12, multiply(3, 4));
    }

    private static long multiply(long x, long y) {
        long result = 0;
        // x will be the number to be multiplied
        long tempX = x;
        while (y != 0) {
            // Use each bit of y, starting from right to left, in order to multiply x and perform addition to the temporary result
            long currentBit = y & 1;
            // If current y bit is zero, we don't need to do any addition
            if (currentBit == 1) {
                // Add new multiplication to the temporary result
                result = add(result, tempX);
            }
            // Unsigned right shift y in order to process the next bit
            y >>>= 1;
            // The following multiplication of x will shift left with a 0 position
            // For a better understanding, see the above example of primitive multiplication, where we do the addition step
            tempX <<= 1;
        }
        return result;
    }

    private static long add(long x, long y) {
        long result = 0;
        // Use z for applying 1 MASK in order to populate the result
        long z = 1;
        boolean hasCarry = false;

        while (x != 0 || y != 0) {
            // Both bits are 1
            if ((x & 1) == 1 && (y & 1) == 1) {
                // If precedent carry is present, set the current position in result to 1
                if (hasCarry) {
                    result |= z;
                }
                // Mark a future set of carry
                hasCarry = true;
            }

            // One bit is 0 and the other is 1
            if (((x & 1) == 1 && (y & 1) == 0) || ((x & 1) == 0 && (y & 1) == 1)) {
                // If no precedent carry, set the current position in result to 1
                if (!hasCarry) {
                    result |= z;
                }
            }

            // Both bits are 0
            if ((x & 1) == 0 && (y & 1) == 0) {
                // If precedent carry is present, set the current position in result to 1
                if (hasCarry) {
                    result |= z;
                    // Mark usage of carry
                    hasCarry = false;
                }
            }

            // Unsigned right shift x in order to process the next bit
            x >>>= 1;
            // Unsigned right shift y in order to process the next bit
            y >>>= 1;
            // Left shift z MASK in order to set the current position in result
            z <<= 1;
        }

        // If any carry is left, set current position in result to 1 (the first position in this case)
        if (hasCarry) {
            result |= z;
        }

        return result;
    }
}
