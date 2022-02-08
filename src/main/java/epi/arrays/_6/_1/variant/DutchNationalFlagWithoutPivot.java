package epi.arrays._6._1.variant;

import epi.arrays._6._1.Color;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static epi.arrays._6._1.Color.*;
import static org.junit.Assert.assertEquals;

/**
 * Question:
 * Assuming that keys take one of three values, reorder the array so that all objects with the same key appear together.
 * The order of the sub-arrays is not important. Use 0(1) additional space and 0(n) time.
 * ---
 * Memo:
 * Divide into sub-arrays using multiple pointers. Pointers can mark the beginning / end of an interval.
 * E.g. red - end of interval, white - end of interval, blue - beginning of interval
 * ---
 * Solution:
 *  Use 3 counters in order to divide 4 sub-arrays:
 *  - [0, red]
 *  - (red, white]
 *  - (white, blue]
 *  - (blue, end)
 *  white index will be used to iterate through array.
 *  1. When current element is red, swap with red and increase both red and white indexes
 *  2. When current element is white, increase white index
 *  3. When current element is blue, swap with blue and decrease blue index
 *     Note: Don't increase white index because swapped element needs to be processed as well
 *
 * Note: During explanation and code comments, we refer to red = 0, white = 1 and blue = 2 as integer ordinals
 * ---
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class DutchNationalFlagWithoutPivot {

    public static void main(String[] args) {
        List<Color> A = Arrays.asList(RED, BLUE, WHITE, RED, BLUE, BLUE, RED, BLUE, WHITE, WHITE);
        sortColors(A);
        assertEquals(Arrays.asList(RED, RED, RED, WHITE, WHITE, WHITE, BLUE, BLUE, BLUE, BLUE), A);
    }

    private static void sortColors(List<Color> A) {
        int red = 0, white = 0, blue = A.size() - 1;
        // When white meets blue, it means that we have processed all existing items
        while (white <= blue) {
            int ordinal = A.get(white).ordinal();

            // Increase both red and white indexes
            // white will most likely have a white value after swap operation
            // due to the fact that we already processed left side elements
            // which can contain either red or white items
            if (ordinal == 0) {
                Collections.swap(A, red++, white++);
            }

            // If element is equal to white, we just increase white index
            if (ordinal == 1) {
                white++;
            }

            // Decrease blue because we already covered that index
            // Don't decrease white index, since we didn't processed the newly swapped item
            if (ordinal == 2) {
                Collections.swap(A, white, blue--);
            }
        }
    }
}
