package epi.arrays._6._1.variant;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Question:
 * Given an array A of n objects with keys that take one of four values,
 * reorder the array so that all objects that have the same key appear together.
 * Use O(1) additional space and O(n) time.
 * ---
 * Memo:
 * Divide into sub-arrays using multiple pointers. Pointers can mark the beginning / end of an interval.
 * E.g. red - end of interval, blue - end of interval, yellow - beginning of interval, green - beginning of interval
 * ---
 * Solution:
 * This problem follows a similar idea such as the one in DutchNationalFlagWithoutPivot.
 *  Use 4 counters in order to divide 5 sub-arrays:
 *  - [0, red]
 *  - (red, blue]
 *  - (blue, yellow]
 *  - (yellow, green]
 *  - (green, end)
 *  blue index will be used to iterate through array.
 *  1. When current element is red, swap with red and increase both red and blue indexes
 *  2. When current element is blue, increase blue index
 *  3. When current element is yellow, swap with yellow and decrease yellow index
 *     Note: Don't increase blue index because swapped element needs to be processed as well
 *  4. When current element is green, swap with green and decrease green index;
 *     if green takes a yellow position after decrease, decrease yellow index also
 *     Note: Don't increase blue index because swapped element needs to be processed as well
 *
 * Note: During explanation and code comments, we refer to red = 1, blue = 2 and yellow = 3 and green = 4 as integer ordinals
 * ---
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class MauritiusNationalFlag {

    public static void main(String[] args) {
        assertEquals(Arrays.asList(1, 2, 3, 4), sortColors(Arrays.asList(3, 2, 1, 4)));
        assertEquals(Arrays.asList(1, 2, 3, 4), sortColors(Arrays.asList(3, 2, 4, 1)));
        assertEquals(Arrays.asList(1, 2, 3, 4, 4), sortColors(Arrays.asList(1, 2, 3, 4, 4)));
        assertEquals(Arrays.asList(1, 1, 2, 3, 4, 4), sortColors(Arrays.asList(2, 1, 3, 1, 4, 4)));
        assertEquals(Arrays.asList(1, 1, 2, 3, 3, 3, 4, 4), sortColors(Arrays.asList(1, 2, 3, 4, 4, 3, 3, 1)));
        assertEquals(Arrays.asList(1, 1, 1, 2, 2, 3, 3, 4), sortColors(Arrays.asList(1, 2, 3, 2, 4, 1, 1, 3)));
        assertEquals(Arrays.asList(1, 1, 1, 2, 2, 3, 3, 4), sortColors(Arrays.asList(4, 1, 2, 3, 2, 1, 1, 3)));
        assertEquals(Arrays.asList(1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4), sortColors(Arrays.asList(1, 2, 3, 4, 2, 3, 3, 3, 3, 3, 3, 2, 1, 4, 3, 2, 2, 2, 1, 1, 3, 1, 3)));
        assertEquals(Arrays.asList(1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4), sortColors(Arrays.asList(1, 1, 3, 3, 4, 3, 4, 2, 2, 2, 2, 2, 2, 1, 3, 4, 3, 1, 4, 4, 3, 4, 2, 1, 2, 2)));
        assertEquals(Arrays.asList(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4), sortColors(Arrays.asList(3, 2, 1, 3, 4, 2, 2, 1, 2, 3, 4, 3, 2, 1, 3, 4, 3, 3, 2, 2, 2, 4, 4, 4, 3, 3, 2, 4, 3, 1, 2, 3, 2, 1, 3, 2, 1, 1, 2, 3, 2, 3, 2, 1, 2, 3, 2, 1, 2, 3, 2, 2, 2, 2, 2, 3, 3, 3, 1, 2, 2, 1, 1, 2, 3)));
    }

    private static List<Integer> sortColors(List<Integer> A) {
        int red = 0, blue = 0, yellow = A.size() - 1, green = A.size() - 1;
        // When blue meets yellow, it means that we have processed all existing items
        while (blue <= yellow) {
            int ordinal = A.get(blue);

            // Increase both red and blue indexes
            // blue will most likely have a blue value after swap operation
            // due to the fact that we already processed left side elements
            // which can contain either red or blue items
            if (ordinal == 1) { // red
                Collections.swap(A, red++, blue++);
            }

            // If element is equal to blue, we just increase blue index
            if (ordinal == 2) { // blue
                blue++;
            }

            // Decrease yellow because we already covered that index
            // Don't increase blue index, since we didn't processed the newly swapped item
            if (ordinal == 3) { // yellow
                Collections.swap(A, blue, yellow--);
            }

            // Decrease green because we already covered that index
            // Don't increase blue index, since we didn't processed the newly swapped item
            if (ordinal == 4) { // green
                Collections.swap(A, blue, green--);
                // In case the newly decreased green index may take a current yellow index,
                // decrease the yellow index as well
                if (green == yellow - 1) {
                    yellow--;
                }
            }
        }

        return A;
    }
}
