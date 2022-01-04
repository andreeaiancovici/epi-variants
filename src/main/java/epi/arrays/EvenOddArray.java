package epi.arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

/*
Given an integer array,
move all the even integers at the beginning of the array followed by all the odd integers.
Time Complexity: O(n)
Space Complexity: O(1)
 */
public class EvenOddArray {

    public static void main(String[] args) {
        List<Integer> A = Arrays.asList(3, 1, 2, 4);
        evenOdd(A);
        assertEquals(Arrays.asList(4, 2, 1, 3), A);
    }

    private static void evenOdd(List<Integer> A) {
        int i = 0, j = A.size() - 1;
        while (i < j) {
            if (A.get(i) % 2 == 0) {
                i++;
            } else {
                Collections.swap(A, i, j--);
            }
        }
    }
}
