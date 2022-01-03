package epi.arrays;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/*
Write a program which takes as input a sorted array and updates it so that all duplicates
have been removed and the remaining elements have been shifted left to fill the
emptied indices. Return the number of valid elements.
Time Complexity: O(n)
Space Complexity: O(1)
 */
public class SortedArrayRemoveDups {

    public static void main(String[] args) {
        assertEquals(6, deleteDuplicates(Arrays.asList(2,3,5,5,7,11,11,11,13)));
    }

    private static int deleteDuplicates(List<Integer> A) {
        if(A.isEmpty()) {
            return 0;
        }

        int indexToReplace = 1;
        for(int i = 1; i < A.size(); i++) {
            if(!A.get(i).equals(A.get(i - 1))) {
                A.set(indexToReplace++, A.get(i));
            }
        }

        return indexToReplace;
    }
}
