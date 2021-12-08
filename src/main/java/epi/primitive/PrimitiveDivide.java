package epi.primitive;

import static org.junit.Assert.assertEquals;

/*
Given two positive integers, compute their quotient, using only the addition, sub¬
traction, and shifting operators.
Time Complexity: O(n) -> the primitive algorithm is applied, meaning that with each iteration we process another bit
Space Complexity: O(1)
 */
public class PrimitiveDivide {

    public static void main(String[] args) {
        assertEquals(3, divide(12, 4));
    }

    private static int divide(int x, int y) {
        long yPower = (long) y << 32;
        int result = 0;
        int power = 32;
        while(x >= y) {
            while(yPower > x) {
                yPower >>>= 1;
                power--;
            }
            result += (1 << power);
            x -= yPower;
        }
        return result;
    }
}
