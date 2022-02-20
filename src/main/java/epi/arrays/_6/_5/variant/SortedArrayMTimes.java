package epi.arrays._6._5.variant;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Question:
 * Write a program which takes as input a sorted array A of integers and a positive integer m
 * and updates A so that if x appears m times in A it appears exactly min(2,m) times in A.
 * The update to A should be performed in one pass, and no additional storage may be allocated.
 * ---
 * Solution:
 * First, we need to determine minimum value of occurrences = min(2, m).
 * The array is sorted, so we need to figure out when a number is changing and count its occurrences.
 * We keep an index (indexToReplace) for knowing where to do a replacement, so we can ignore the duplicates
 * after required occurrences.
 * While iterating the array, if consecutive numbers are the same, we don't increment the replacement index after
 * the required no. of occurrences is met.
 * Otherwise, if an element is different than its previous or required no. of occurrences not met,
 * we do the replacement at indexToReplace and increment it.
 * ---
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class SortedArrayMTimes {

    public static void main(String[] args) {
        assertEquals(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 10, 0, 0, 0, 0, 0),
                deleteUntilMin2M(Arrays.asList(1, 2, 2, 3, 4, 5, 5, 6, 7, 7, 7, 7, 8, 10), 1));
        assertEquals(Arrays.asList(1, 2, 2, 3, 4, 5, 5, 6, 7, 7, 8, 10, 0, 0),
                deleteUntilMin2M(Arrays.asList(1, 2, 2, 3, 4, 5, 5, 6, 7, 7, 7, 7, 8, 10), 2));
        assertEquals(Arrays.asList(1, 2, 2, 3, 4, 5, 5, 6, 7, 7, 8, 10, 0, 0),
                deleteUntilMin2M(Arrays.asList(1, 2, 2, 3, 4, 5, 5, 6, 7, 7, 7, 7, 8, 10), 4));
    }

    private static List<Integer> deleteUntilMin2M(List<Integer> A, int m) {
        int indexToReplace = 1;
        int count = 1;
        // Determine minimum value of required occurrences
        int occurrence = Math.min(2, m);

        for (int i = 1; i < A.size(); i++) {
            if(A.get(i).equals(A.get(i - 1))) {
                // If we not met yet the required no. of occurrences, continue to do replacements
                // and increment the replacement index
                if (count < occurrence) {
                    A.set(indexToReplace++, A.get(i));
                }
                count++;
            } else {
                // If element is not equal previous element, we should proceed with replacement
                A.set(indexToReplace++, A.get(i));
                // Also, reset the counter to 1 as we encountered a new number
                count = 1;
            }
        }

        // Fill with zeroes the remaining values
        for (int j = indexToReplace; j < A.size(); j++) {
            A.set(j, 0);
        }

        return A;
    }
}