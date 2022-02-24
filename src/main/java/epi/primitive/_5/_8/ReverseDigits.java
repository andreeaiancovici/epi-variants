package epi.primitive._5._8;

import static org.junit.Assert.assertEquals;

/**
 * Question:
 * Write a program which takes an integer and returns the integer corresponding to the
 * digits of the input written in reverse order. For example, the reverse of 42 is 24, and
 * the reverse of -314 is -413.
 * ---
 * Memo:
 * Overflow check
 * The maximum value an integer can store in Java is 2^31 - 1 = 2147483647.
 * The check is done in 2 steps:
 * - reversed_integer > 2147483640
 * - reversed_integer = 2147483640 and last digit of reversed_integer > 7
 * ---
 * Solution:
 * Iterate through each digit from input (x), starting from left to right.
 * At each iteration step, increase result (reversedX) by multiplying with 10 and
 * adding the previously computed input (x) digit.
 * ---
 * Time Complexity: O(n) - n is the number of digits in the input number
 * Space Complexity: O(1)
 */
public class ReverseDigits {

    public static void main(String[] args) {
        assertEquals(99598798, reverse(89789599));
    }

    public static long reverse(int x) {
        boolean isNegative = false;

        if (x < 0) {
            isNegative = true;
            x *= -1;
        }

        int reversedX = 0;

        // Iterate over each digit from x, starting from left to right;
        while (x > 0) {
            // Check if next processing of result will catch an overflow

            // First we check if result * 10 is greater than maximum integer
            if (reversedX > Integer.MAX_VALUE / 10) {
                return 0;
            }

            // Second we check if result * 10 equals maximum integer and last digit of result is higher than 7
            if (reversedX == Integer.MAX_VALUE / 10 && reversedX % 10 > 7) {
                return 0;
            }

            // Before adding left-most digit from x to result, multiply existing result with 10
            reversedX = (reversedX * 10) + x % 10;
            // Remove last digit from x
            x /= 10;
        }

        // Add correct sign to result
        if (isNegative) {
            reversedX *= -1;
        }

        return reversedX;
    }
}
