package epi.arrays._6._5.variant;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Question:
 * Implement a function which takes as input an array and a key and updates the array
 * so that all occurrences of the input key have been removed and the remaining elements
 * have been shifted left to fill the emptied indices. Return the number of remaining elements.
 * There are no requirements as to the values stored beyond the last valid element.
 * ---
 * Solution:
 * We keep an index (indexToReplace) for knowing where to do a replacement, so we can ignore the key.
 * While iterating the array, if we encounter the key, we don't increment the replacement index.
 * Otherwise, if an element is different than the key,we do the replacement at indexToReplace and increment it.
 * ---
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class ArrayRemoveKey {

    public static void main(String[] args) {
        assertEquals(11, deleteKey(Arrays.asList(5, 1, 7, 7, 2, 4, 6, 9, 10, 5, 2, 3, 7, 8), 7));
        assertEquals(12, deleteKey(Arrays.asList(5, 1, 7, 7, 2, 4, 6, 9, 10, 5, 2, 3, 7, 8), 5));
        assertEquals(13, deleteKey(Arrays.asList(5, 1, 7, 7, 2, 4, 6, 9, 10, 5, 2, 3, 7, 8), 10));
    }

    private static int deleteKey(List<Integer> A, int key) {
        int indexToReplace = 0;

        for (int i = 0; i < A.size(); i++) {
            // If element is not equal to key, we should proceed with replacement
            if (!A.get(i).equals(key)) {
                A.set(indexToReplace++, A.get(i));
            }
        }

        return indexToReplace;
    }
}
