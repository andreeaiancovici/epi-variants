package epi.arrays._6._1.variant;

import static org.junit.Assert.assertArrayEquals;

/**
 * Question:
 * Given an array A of n objects with Boolean-valued keys,
 * reorder the array so that objects that have the key false appear first.
 * Use O(1) additional space and 0(n) time.
 * ---
 * Memo:
 * Divide into sub-arrays using multiple pointers. Pointers can mark the beginning / end of an interval.
 * E.g. fIndex - end of interval, tIndex - beginning of interval
 * ---
 * Solution:
 * This problem follows a similar idea such as the one in DutchNationalFlagWithoutPivot.
 *  Use 2 counters in order to divide 3 sub-arrays:
 *  - [0, fIndex]
 *  - (fIndex, tIndex]
 *  - (tIndex, end)
 *  fIndex index will be used to iterate through array.
 *  1. When current element is false, increase fIndex
 *  2. When current element is true, swap with tIndex and decrease tIndex
 *     Note: Don't increase fIndex because swapped element needs to be processed as well
 * ---
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class BooleanValuedKeysFlag {

    public static void main(String[] args) {
        assertArrayEquals(new boolean[]{false, false, false, false, true, true, true, true, true, true},
                sort(new boolean[]{false, true, true, false, false, true, false, true, true, true}));
    }

    private static boolean[] sort(boolean[] A) {
        int fIndex = 0, tIndex = A.length - 1;
        // When fIndex meets tIndex, it means that we have processed all existing items
        while (fIndex <= tIndex) {
            if(A[fIndex]) {
                // Decrease tIndex because we already covered that index
                // Don't increase fIndex, since we didn't processed the newly swapped item
                swap(A, fIndex, tIndex--);
            } else {
                // If element is false, we just increase fIndex
                fIndex++;
            }
        }
        return A;
    }

    private static void swap(boolean[] A, int i , int j) {
        boolean temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
