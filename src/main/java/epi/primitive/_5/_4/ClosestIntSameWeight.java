package epi.primitive._5._4;

import static org.junit.Assert.assertEquals;

/**
 * Question:
 * Write a program which takes as input a non-negative integer x and returns a number y which is not equal to x,
 * but has the same weight as x and their difference, |y- x|, is as small as possible.
 * Weight -> the number of 1s
 * ---
 * Solution:
 * Let's assume we found the desired number y.
 * Preserving the same weight for y means we need to swap 2 different bits in order to have the same weight.
 * In order to get the closest modified integer, we should consider comparing the right-most bit with its next left neighbour.
 * ---
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class ClosestIntSameWeight {

    public static void main(String[] args) {
        assertEquals(39698800462693L, closestIntSameBitCount(39698800462691L));
    }

    private static long closestIntSameBitCount(long x) {
        int count = 0;
        // Start from the right-most bit and compare it with its left neighbour, until they differ
        while (((x >>> count) & 1L) == ((x >>> (count + 1)) & 1L)) {
            count++;
        }
        // We found 2 consecutive bits which differ
        // We swap their values using XOR 1
        // 0 ^ 1 = 1
        // 1 ^ 1 = 0
        x ^= (1L << count);
        x ^= (1L << (count + 1));
        return x;
    }
}


