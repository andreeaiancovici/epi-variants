package epi.arrays;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/*
You are given a large integer represented as an integer array digits,
where each digits[i] is the ith digit of the integer. The digits are ordered
from most significant to least significant in left-to-right order. The large
integer does not contain any leading 0's.
Time Complexity: O(n)
Space Complexity: O(1)
 */
public class IntAsArrayIncrement {

    public static void main(String[] args) {
        int[] digits = new int[]{4,3,2,1};
        assertArrayEquals(new int[]{4,3,2,2}, plusOne(digits));
    }

    private static int[] plusOne(int[] digits) {
        int carry = 1, temp;

        for(int i = digits.length - 1; i >= 0; i--) {
            temp = digits[i] + carry;
            if(temp > 9) {
                temp %= 10;
            } else {
                carry = 0;
            }
            digits[i] = temp;
        }

        if(carry == 1) {
            int[] digitsWithCarry = new int[digits.length + 1];

            digitsWithCarry[0] = 1;
            System.arraycopy(digits, 0, digitsWithCarry, 1, digits.length);

            return digitsWithCarry;
        } else return digits;
    }
}
