package epi.arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Question:
 * Given an integer array, move all the even integers at the beginning of the array followed by all the odd integers.
 * ---
 * Memo
 * For in-place reordering, we can use a number of indexes to keep track of processed elements in array.
 * ---
 * Solution:
 * Start simultaneously from the begging and end of array.
 * If we find an even number, increase start index; otherwise, swap with end index and decrease end index.
 * ---
 * Time Complexity: O(n)
 * Space Complexity: O(1)
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
            // If current start index matches an even number, go one step ahead
            // We leave the even number in the beginning
            if (A.get(i) % 2 == 0) {
                i++;
            } else {
                // If we found an odd number in the beginning, swap it with end index
                // Decrease end index in order to prepare for next swap (otherwise we would re-swap the odd number again)
                // We don't increase start index, because the freshly swapped number may be odd as well
                Collections.swap(A, i, j--);
            }
        }
    }
}
