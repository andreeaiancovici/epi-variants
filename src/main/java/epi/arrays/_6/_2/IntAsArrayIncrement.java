package epi.arrays._6._2;

import static org.junit.Assert.assertArrayEquals;

/**
 * Question:
 * Write a program which takes as input an array of digits encoding a decimal number D and updates the array to represent the number D + 1.
 * For example, if the input is (1,2,9), then you should update the array to (1,3,0).
 * Your algorithm should work even if it is implemented in a language that has finite-precision arithmetic.
 * ---
 * Solution:
 * The idea is to follow the primitive algorithm for addition.
 * E.g.
 * 4321+
 *    1
 * ----
 * 4322
 *
 * 129+
 *   1
 * ---
 * 130, carry = 1 when processing digit 2 from 129
 *
 * Iterate the input array, starting from right to left and process each digit, keeping a carry = 1 if necessary.
 * Note: We are not restricted to any overflow,
 * due to the fact that no Java primitive types with bounded maximum values are used.
 * ---
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class IntAsArrayIncrement {

    public static void main(String[] args) {
        assertArrayEquals(new int[]{4, 3, 2, 2}, plusOne(new int[]{4, 3, 2, 1}));
    }

    private static int[] plusOne(int[] digits) {
        // carry will be used for adding 1, as the question states
        // and also other carries while further addition is done
        int carry = 1, temp;

        // Iterate through each digit, starting from right to left
        for (int i = digits.length - 1; i >= 0; i--) {
            // start by adding 1 and keep the result in a temporary integer, which may have values in [0,18]
            // next iterations may add carry = 1 or carry = 0, depending on previous steps
            temp = digits[i] + carry;
            // if new value is >= 10, we extract the last digit and keep carry = 1
            if (temp > 9) {
                temp %= 10;
            } else {
                // otherwise carry was used, set it to 0 for next iteration
                carry = 0;
            }
            // set the computed value, which contains a digit in [0,9]
            digits[i] = temp;
        }

        // If we have a final result with carry, allocate a new array for it, adding the extra digit in front
        if (carry == 1) {
            int[] digitsWithCarry = new int[digits.length + 1];

            digitsWithCarry[0] = 1;
            System.arraycopy(digits, 0, digitsWithCarry, 1, digits.length);

            return digitsWithCarry;
        } else return digits;
    }
}
