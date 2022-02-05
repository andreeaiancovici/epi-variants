package epi.primitive._5._7;

import static org.junit.Assert.assertEquals;

/**
 * Question:
 * Write a program that takes a double x and an integer y and returns x^y. You can ignore overflow and underflow.
 * ---
 * Memo:
 * Fast Power Algorithm
 * for even y => x^y = x^(y/2) * x^(y/2)
 * for odd y => x^y = x^(y/2) * x^(y/2) * x
 * ---
 * Solution:
 * x => x * x = x^2 => x^2 * x^2 = x^4 => x^4 * x^4= x^8
 * Consider y is a power of 2 => y = 2^i
 * Keep y as a counter for powers of x
 * The algorithm implies 2 major multiplications:
 * - first is optional and only if number is odd -> x^1 is multiplied to initial result
 * - second is achieved when y becomes 1, and we multiplied x from x^1 to x^(2^k),
 * where k is the number of times y was divided
 * ---
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class PowerXY {

    public static void main(String[] args) {
        assertEquals(512, power(2, 9), 0);
        assertEquals(16, powerRecursive(2, 4), 0);
    }

    // Iterative
    private static double power(double x, int y) {
        // If y is negative, apply mathematical changes
        // x^(-2) -> (1/x)^2
        if(y < 0) {
            y = -y;
            x = 1/x;
        }
        double result = 1;
        // y keeps the power
        // Let's take for example y = 9 = 1 + 2 + 2 + 2 + 2 = 1 + 4 + 4 = 1 + 8 = 1 + 2^3
        while(y != 0) {
            if((y & 1) == 1) {
                // If number is odd, first multiplication will be with x^1
                // Second multiplication is when y was divided and it equals 1
                // Second multiplication implies x^(2^k), where k is the number of times the power y has been divided
                result *= x;
            }
            // Multiply x with itself at each step because we divide power y by 2
            // x^2, x^4, x^8
            x *= x;
            // Divide power by 2 until it reaches 1
            // 4, 2, 1
            y >>>= 1;
        }
        return result;
    }

    // Recursive
    private static double powerRecursive(double x, int y) {
        if(y == 0) {
            return 1;
        }
        double result = powerRecursive(x, y >>> 1);
        if((y & 1) == 1) {
            return result * result * x;
        } else {
            return result * result;
        }
    }
}
