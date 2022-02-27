package epi.arrays._6._11;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Question:
 * Implement an algorithm that takes as input an array of distinct elements and a size,
 * and returns a subset of the given size of the array elements. All subsets should be
 * equally likely. Return the result in input array itself.
 * ---
 * Memo:
 * ---
 * Solution:
 * ---
 * Time Complexity: O(k)
 * Space Complexity: O(1)
 */
public class OfflineSampling {

    public static void main(String[] args) {
        randomSampling(2, Arrays.asList(1, 2, 3, 4));
    }

    public static void randomSampling(int k, List<Integer> A) {
        Random random = new Random();
        for (int i = 0; i < k; i++) {
            Collections.swap(A, i, i + random.nextInt(A.size() - i));
        }
    }
}
