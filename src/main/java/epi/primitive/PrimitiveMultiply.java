package epi.primitive;

import static org.junit.Assert.assertEquals;

/*
Write a program that multiplies two non-negative integers. The only operators you
are allowed to use are
• assignment,
• the bitwise operators >>, <<, |, &, " and
• equality checks and Boolean combinations thereof.
You may use loops and functions that you write yourself. These constraints imply,
for example, that you cannot use increment or decrement, or test if x < y.
Time Complexity: O(n^2) -> n from first while (multiply) * n from second while (add)
Space Complexity: O(1)
 */
public class PrimitiveMultiply {

    public static void main(String[] args) {
        assertEquals(12, multiply(3, 4));
    }

    private static long multiply(long x, long y) {
        long result = 0;
        long tempX = x;
        while(y != 0) {
            long currentBit = y & 1;
            if(currentBit == 1) {
                result = add(result, tempX);
            }
            y >>>= 1;
            tempX <<= 1;
        }
        return result;
    }

    private static long add(long x, long y) {
        long result = 0;
        long z = 1;
        boolean hasCarry = false;

        while(x != 0 || y != 0) {
            if((x & 1) == 1 && (y & 1) == 1) {
                if(hasCarry) {
                    result |= z;
                }
                hasCarry = true;
            }

            if(((x & 1) == 1 && (y & 1) == 0) || ((x & 1) == 0 && (y & 1) == 1)) {
                if(!hasCarry) {
                    result |= z;
                }
            }

            if((x & 1) == 0 && (y & 1) == 0) {
                if(hasCarry) {
                    result |= z;
                    hasCarry = false;
                }
            }

            x >>>= 1;
            y >>>= 1;
            z <<= 1;
        }

        if(hasCarry) {
            result |= z;
        }

        return result;
    }
}
