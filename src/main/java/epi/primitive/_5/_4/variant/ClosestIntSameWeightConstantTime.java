package epi.primitive._5._4.variant;

import static org.junit.Assert.assertEquals;

/**
 * Question:
 * Write a program which takes as input a non-negative integer x and returns a number y which is not equal to x,
 * but has the same weight as x and their difference, |y- x|, is as small as possible.
 * Weight -> the number of 1s
 * ---
 * Solution:
 * We find the right-most bit set to 1.
 * Case 1 (found right-most bit is not first right-most bit)
 * In this case, the right neighbour bit should be 0.
 * We can simply swap these 2 bits.
 * Case 2 (found right-most bit is first right-most bit)
 * In this case, we need to find the right-most bit set to 0 having the right neighbour set to 1.
 * We can simply swap these 2 bits.
 * Two's Complement:
 * 11101010
 * 1. Reverse bits
 * 00010101
 * 2. Add 1
 * 00010110
 * ---
 * Time Complexity: O(1)
 * Space Complexity: O(1)
 */
public class ClosestIntSameWeightConstantTime {

    public static void main(String[] args) {
        assertEquals(39698800462693L, closestIntSameBitCount(39698800462691L));
    }

    private static long closestIntSameBitCount(long x) {
        // Extract lowest set bit by using two's complement
        // x & -x (two's complement)
        long lowestSetBit = x & -x;

        // If right-most bit is exactly the first right-most bit
        if((lowestSetBit & 1L) == 1L) {
            // Extract lowest unset bit
            long lowestNotSetBit = ~x & (x + 1);
            // Swap the lowest unset bit
            x ^= lowestNotSetBit;
            // Swap its right neighbour
            // (the lowest unset bit cannot be the first right-most bit, so it has a right neighbour)
            x ^= (lowestNotSetBit >> 1);
        } else {
            // Swap the lowest set bit
            x ^= lowestSetBit;
            // Swap its right neighbour
            x ^= (lowestSetBit >> 1);
        }

        return x;
    }
}
