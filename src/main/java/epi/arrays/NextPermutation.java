package epi.arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

/*
Write a program that takes as input a permutation, and returns the next permutation
under dictionary ordering. If the permutation is the last permutation, return the
empty array.
Time Complexity: O(n)
Space Complexity: O(1)
 */
public class NextPermutation {

    public static void main(String[] args) {
        assertEquals(Arrays.asList(0,3,1,2), nextPermutation(Arrays.asList(0,2,3,1)));
        assertEquals(Arrays.asList(1,0,2,3), nextPermutation(Arrays.asList(0,3,2,1)));
        assertEquals(Collections.emptyList(), nextPermutation(Arrays.asList(3,2,1,0)));
    }

    private static List<Integer> nextPermutation(List<Integer> perm) {
        int n = perm.size();

        if(n == 1) {
            return Collections.emptyList();
        }

        // If last 2 digits are in increasing order, reverse
        if(perm.get(n - 2) < perm.get(n - 1)) {
            Collections.swap(perm, n - 1, n - 2);
        } else {
            // Starting with the end, find the first digit which is greater than its left neighbour
            int index = n - 1;
            while(index > 0 && perm.get(index) <= perm.get(index - 1)) {
                index--;
            }

            // If we arrived to the start, the perm is maximum
            int leftIndex = index - 1;
            if(leftIndex < 0) {
                return Collections.emptyList();
            }

            // Otherwise, starting with the end, find the first digit which is higher than the left neighbour
            int rightIndex = n - 1;
            while(perm.get(rightIndex) <= perm.get(leftIndex)) {
                rightIndex--;
            }

            Collections.swap(perm, leftIndex, rightIndex);

            // Swap the right side of the left neighbour
            int mid = (n - 1 - index) / 2;
            for(int j = 0; j <= mid; j++) {
                Collections.swap(perm, j + index, n - 1 - j);
            }
        }
        return perm;
    }
}
