package epi.arrays._6._13;

import epi.arrays._6._11.OfflineSampling;

import java.util.ArrayList;
import java.util.List;

/**
 * Question:
 * Design an algorithm that creates uniformly random permutations of {0,1,...,n-1}.
 * You are given a random number generator that returns integers in the set {0,1,...,n-1}
 * with equal probability; use as few calls to it as possible.
 * ---
 * Memo:
 * Fisher-Yates Algorithm (array shuffling)
 * Pseudocode
 * for i in [0, n - 1]
 *  find random j in (i, n - 1]
 *  swap i and j
 * ---
 * Solution:
 * Apply Fisher-Yates algorithm for array shuffling, keeping in mind that we will shuffle the entire array.
 * ---
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class RandomPermutation {

    public static void main(String[] args) {
        computeRandomPermutation(5);
    }

    public static List<Integer> computeRandomPermutation(int n) {
        // Initialize first permutation in dictionary order
        List<Integer> randomPermutation = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            randomPermutation.add(i);
        }

        // Apply Fisher-Yates algorithm
        OfflineSampling.randomSampling(n, randomPermutation);
        return randomPermutation;
    }
}
