package epi.arrays._6._3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Question:
 * Write a program that takes two arrays representing integers, and returns an integer representing their product.
 * ---
 * Solution:
 * The idea is to follow the primitive algorithm for multiplication.
 * E.g.
 *  12345*
 *     13
 * ------
 *  37035, // list of multiplication carries: 1, 1, 1
 * 12345
 * ------
 * 160485 // list of addition carries: 1
 *
 * We multiply each digit from the second number with each digit from the first number.
 * Result is computed in-place, performing both multiplication and addition with what we have so far.
 * We keep 2 carries, one for multiplication and one for addition.
 * ---
 * Time Complexity: O(n * m)
 * Space Complexity: O(1)
 */
public class IntAsArrayMultiply {

    public static void main(String[] args) {
        assertEquals(Arrays.asList(-1, 7, 2, 5, 8, 7, 5, 8, 4, 7, 8, 4), multiply(Arrays.asList(1, 3, 1, 4, 1, 2), Arrays.asList(-1, 3, 1, 3, 3, 3, 2)));
    }

    private static List<Integer> multiply(List<Integer> num1, List<Integer> num2) {
        // The multiplication result will have a size of maximum n + m
        List<Integer> result = new ArrayList<>(Collections.nCopies(num1.size() + num2.size(), 0));

        // Get sign of multiplication result and map both numbers to absolute values
        int signMultiplier = getSignMultiplierAndMapToAbsolute(num1, num2);

        int multiplyCarry = 0, sumCarry = 0, multiplyTemp, sumTemp, carry, k;
        // Iterate through the second number
        for (int i = num2.size() - 1; i >= 0; i--) {
            // k keeps track of position in final result when addition is done in-place after each multiplication step
            // k will decrease at each step its starting position
            k = result.size() - 1 - (num2.size() - 1 - i);
            // Iterate through the first number
            for (int j = num1.size() - 1; j >= 0; j--, k--) {
                // keeps product between 2 digits
                multiplyTemp = num2.get(i) * num1.get(j) + multiplyCarry;
                multiplyCarry = multiplyTemp / 10;

                // each digit extraction sums the previous value at that k position
                sumTemp = result.get(k) + (multiplyTemp % 10) + sumCarry;
                sumCarry = sumTemp / 10;

                // set the final digit value at k position in result
                result.set(k, sumTemp % 10);
            }

            // check if we have some remaining carry and add it to result
            carry = multiplyCarry + sumCarry;
            multiplyCarry = 0;
            sumCarry = 0;

            if (carry > 0) {
                result.set(k, carry % 10);
                if (carry > 9) {
                    result.set(k - 1, carry % 10);
                }
            }
        }

        // remove leading zeroes
        int i = 0;
        while (i < result.size() - 1 && result.get(i) == 0) {
            i++;
        }

        result = result.subList(i, result.size());

        // add sign
        result.set(0, result.get(0) * signMultiplier);

        return result;
    }

    private static int getSignMultiplierAndMapToAbsolute(List<Integer> num1, List<Integer> num2) {
        int signMultiplier = 1;
        if (num1.get(0) < 0) {
            num1.set(0, num1.get(0) * -1);
            signMultiplier *= -1;
        }
        if (num2.get(0) < 0) {
            num2.set(0, num2.get(0) * -1);
            signMultiplier *= -1;
        }
        return signMultiplier;
    }
}
