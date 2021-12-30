package epi.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

/*
Write a program that takes two arrays representing integers,
and returns an integer representing their product.
Time Complexity: O(nm)
Space Complexity: O(1)
 */
public class IntAsArrayMultiply {

    public static void main(String[] args) {
        assertEquals(Arrays.asList(-1, 7, 2, 5, 8, 7, 5, 8, 4, 7, 8, 4), multiply(Arrays.asList(1, 3, 1, 4, 1, 2), Arrays.asList(-1, 3, 1, 3, 3, 3, 2)));
    }

    private static List<Integer> multiply(List<Integer> num1, List<Integer> num2) {
        List<Integer> result = new ArrayList<>(Collections.nCopies(num1.size() + num2.size(), 0));

        int signMultiplier = getSignMultiplierAndApplyMod(num1, num2);

        int multiplyCarry = 0, sumCarry = 0, multiplyTemp, sumTemp, carry, k;
        for (int i = num2.size() - 1; i >= 0; i--) {
            k = result.size() - 1 - (num2.size() - 1 - i);
            for (int j = num1.size() - 1; j >= 0; j--, k--) {
                multiplyTemp = num2.get(i) * num1.get(j) + multiplyCarry;
                multiplyCarry = multiplyTemp / 10;

                sumTemp = result.get(k) + (multiplyTemp % 10) + sumCarry;
                sumCarry = sumTemp / 10;

                result.set(k, sumTemp % 10);
            }

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

        int i = 0;
        while (i < result.size() - 1 && result.get(i) == 0) {
            i++;
        }

        result = result.subList(i, result.size());

        result.set(0, result.get(0) * signMultiplier);

        return result;
    }

    private static int getSignMultiplierAndApplyMod(List<Integer> num1, List<Integer> num2) {
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
