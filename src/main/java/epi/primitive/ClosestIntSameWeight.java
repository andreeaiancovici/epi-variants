package epi.primitive;

import static org.junit.Assert.assertEquals;

/*
Write a program which takes as input a non-negative integer x and returns a number
y which is not equal to x, but has the same weight as x and their difference, |y- x|, is
as small as possible.
Time Complexity: O(n)
Space Complexity: O(1)
 */
public class ClosestIntSameWeight {

    public static void main(String[] args) {
        assertEquals(39698800462693L, closestIntSameBitCount(39698800462691L));
    }

    private static long closestIntSameBitCount(long x) {
        int count = 0;
        while(((x >>> count) & 1L) == ((x >>> (count + 1)) & 1L)) {
            count++;
        }
        x ^= (1L << count);
        x ^= (1L << (count + 1));
        return x;
    }
}
