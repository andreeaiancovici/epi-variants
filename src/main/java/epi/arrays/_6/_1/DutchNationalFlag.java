package epi.arrays._6._1;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static epi.arrays._6._1.Color.*;
import static org.junit.Assert.assertEquals;

/**
 * Question:
 * Write a program that takes an array A and an index i into A, and rearranges the
 * elements such that all elements less than A[i] (the "pivot") appear first, followed by
 * elements equal to the pivot, followed by elements greater than the pivot.
 * ---
 * Memo:
 * Divide into sub-arrays using multiple pointers. Pointers can mark the beginning / end of an interval.
 * E.g. lessThanPivot - end of interval, equalToPivot - end of interval, greaterThanPivot - beginning of interval
 * ---
 * Solution:
 *  Use 3 counters in order to divide 4 sub-arrays:
 *  - [0, lessThanPivot]
 *  - (lessThanPivot, equalToPivot]
 *  - (equalToPivot, greaterThanPivot]
 *  - (greaterThanPivot, end)
 *  equalToPivot index will be used to iterate through array.
 *  1. When current element is greater than pivot, swap with greaterThanPivot and decrease greaterThanPivot index
 *     Note: Don't increase equalToPivot index because swapped element needs to be processed as well
 *  2. When current element is equal to pivot, increase equalToPivot index
 *  3. When current element is less than pivot, swap with lessThanPivot and increase both lessThanPivot and equalToPivot indexes
 * ---
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class DutchNationalFlag {

    public static void main(String[] args) {
        List<Color> A = Arrays.asList(BLUE, RED, BLUE, WHITE, WHITE, RED, WHITE, RED);
        sortColors(1, A);
        assertEquals(Arrays.asList(RED, RED, RED, WHITE, WHITE, WHITE, BLUE, BLUE), A);
    }

    private static void sortColors(int pivotIndex , List<Color> A) {
        Color pivotColor = A.get(pivotIndex);
        int lessPivot = 0, equalPivot = 0, greaterPivot = A.size();
        // When equalPivot meets greaterPivot, it means that we have processed all existing items
        while (equalPivot < greaterPivot) {
            // Decrease greaterPivot because we already covered that index
            // Don't decrease equalPivot index, since we didn't processed the newly swapped item
            if (pivotColor.ordinal() < A.get(equalPivot).ordinal()) {
                Collections.swap(A, equalPivot, --greaterPivot);
            }
            // Increase both equalPivot and lessPivot indexes
            // equalPivot will most likely have a pivot value after swap operation
            // due to the fact that we already processed left side elements
            // which can contain either lower or equal items
            if (pivotColor.ordinal() > A.get(equalPivot).ordinal()) {
                Collections.swap(A, lessPivot++, equalPivot++);
            }
            // If element is equal to pivot, we just increase equalPivot index
            if (pivotColor.ordinal() == A.get(equalPivot).ordinal()) {
                equalPivot++;
            }
        }
    }
}
