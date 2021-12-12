package epi.primitive;

import static org.junit.Assert.assertTrue;

/*
Write a program that takes an integer and determines if that integer's representation
as a decimal string is a palindrome.
Time Complexity: O(log10(n)) -> We divided the input by 10 for every iteration
Space Complexity: O(1)
 */
public class IsNumberPalindromic {

    public static void main(String[] args) {
        assertTrue(isPalindromeNumber(123454321));
    }

    private static boolean isPalindromeNumber(int x) {
        if(x < 0) {
            return false;
        }

        boolean hasLeadingZero = false;

        int y = 0;
        while(y < x) {
            y *= 10;
            y += x % 10;
            if (y == 0) {
                hasLeadingZero = true;
                break;
            }
            x /= 10;
        }

        if(y > x) {
            y /= 10;
        }

        return !hasLeadingZero && y == x;
    }
}
