package epi.arrays._6._5;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Question:
 * Write a program which takes as input a sorted array and updates it so that all duplicates
 * have been removed and the remaining elements have been shifted left to fill the
 * emptied indices. Return the number of valid elements.
 * ---
 * Solution:
 * The array is sorted, so we need to figure out when a number is changing.
 * We keep an index (indexToReplace) for knowing where to do a replacement, so we can ignore the duplicates.
 * While iterating the array, if consecutive numbers are the same, we don't increment the replacement index.
 * Otherwise, if an element is different than its previous, we do the replacement at indexToReplace.
 * ---
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class SortedArrayRemoveDups {

    public static void main(String[] args) {
        assertEquals(6, deleteDuplicates(Arrays.asList(2, 3, 5, 5, 7, 11, 11, 11, 13)));
    }

    private static int deleteDuplicates(List<Integer> A) {
        if (A.isEmpty()) {
            return 0;
        }

        int indexToReplace = 1;
        for (int i = 1; i < A.size(); i++) {
            // If element is not equal previous element, we should proceed with replacement
            if (!A.get(i).equals(A.get(i - 1))) {
                A.set(indexToReplace++, A.get(i));
            }
        }

        return indexToReplace;
    }
}
