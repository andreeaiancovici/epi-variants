package epi.primitive;

import static org.junit.Assert.assertEquals;

/*
Write a program which takes an integer and returns the integer corresponding to the
digits of the input written in reverse order. For example, the reverse of 42 is 24, and
the reverse of -314 is -413.
Time Complexity: O(n) -> n is the number of digits in x
Space Complexity: O(1)
 */
public class ReverseDigits {

    public static void main(String[] args) {
        assertEquals(99598798, reverse(89789599));
    }

    public static long reverse(int x) {
        boolean isNegative = false;

        if(x < 0) {
            isNegative = true;
            x *= -1;
        }

        int reversedX = 0;

        while(x > 0) {
            if(reversedX > Integer.MAX_VALUE / 10) {
                return 0;
            }
            if(reversedX == Integer.MAX_VALUE / 10 && reversedX % 10 > 7) {
                return 0;
            }
            reversedX = (reversedX * 10) + x % 10;
            x /= 10;
        }

        if(isNegative) {
            reversedX *= -1;
        }

        return reversedX;
    }
}
