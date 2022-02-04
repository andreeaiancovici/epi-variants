package epi.primitive._5._9;

import static org.junit.Assert.assertTrue;

/**
 * Question:
 * Write a program that takes an integer and determines if that integer's representation
 * as a decimal string is a palindrome.
 * ---
 * Solution:
 * The main idea is to store the last half digits of x into a variable y, while changing their order.
 * In the end, if the number is palindromic, x and y should be the same.
 * E.g. x = 1234321
 * 1. x = 123432, y = 1
 * 2. x = 12343, y = 12
 * 3. x = 1234, y = 123
 * 4. x = 123, y = 1234
 * 5. Remove last digit from y => y = 123
 * 6. Compare x ~ y
 * Be careful to check if number has trailing zeros => 12343210000 is not palindromic,
 * but follows the same pattern as the example above.
 * ---
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class IsNumberPalindromic {

    public static void main(String[] args) {
        assertTrue(isPalindromeNumber(123454321));
    }

    private static boolean isPalindromeNumber(int x) {
        // If number is negative, it cannot be a palindrome
        if (x < 0) {
            return false;
        }

        boolean hasTrailingZero = false;

        int y = 0;
        while (y < x) {
            // Add last digit of x to y
            y *= 10;
            y += x % 10;
            if (y == 0) {
                // Last digit of x may be 0, in this case number will not be palindromic
                hasTrailingZero = true;
                break;
            }
            // Remove last digit from x
            x /= 10;
        }

        // If x has odd number of digits, y > x, so we need to remove the last digit of y
        if (y > x) {
            y /= 10;
        }

        // Number is palindromic only if there are no trailing zeros and y = x
        // Or in other words, first half of x equals last half of x in reversed order
        return !hasTrailingZero && y == x;
    }
}

