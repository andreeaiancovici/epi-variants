package epi.arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

/*
Given an array A of n elements and a permutation P, apply P to A.
A = [a,b,c,d]
P = [2,0,1,3]
R = [b,c,a,d]
Time Complexity: (n)
Space Complexity: O(1)
 */
public class ApplyPermutation {

    public static void main(String[] args) {
        List<Character> A = Arrays.asList('a', 'b', 'c', 'd');
        applyPermutation(Arrays.asList(2, 0, 1, 3), A);
        assertEquals(Arrays.asList('b', 'c', 'a', 'd'), A);
    }

    public static void applyPermutation(List<Integer> perm, List<Character> A) {
        int nextIndex, tempIndex;
        for (int i = 0; i < perm.size(); i++) {
            nextIndex = i;
            while (perm.get(nextIndex) >= 0) {
                Collections.swap(A, i, nextIndex);
                tempIndex = perm.get(nextIndex);
                perm.set(nextIndex, tempIndex - perm.size());
                nextIndex = tempIndex;
            }
        }
    }
}
