package epi.primitive;

import static org.junit.Assert.assertEquals;

/*
Write a program that takes a double x and an integer y and returns xv. You can ignore
overflow and underflow.
Time Complexity: O(n) -> n is the number of bits in y
Space Complexity: O(1)
Iterative + Recursive
 */
public class PowerXY {

    public static void main(String[] args) {
        assertEquals(16, power(2, 4), 0);
    }

    private static double power(double x, int y) {
        if(y < 0) {
            y = -y;
            x = 1/x;
        }
        double result = 1;
        while(y != 0) {
            if((y & 1) == 1) {
                result *= x;
            }
            x *= x;
            y >>>= 1;
        }
        return result;
    }

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
