package epi.arrays;

import java.util.*;

/*
Design an algorithm that creates uniformly random permutations of {0,1,...,n-1}.
You are given a random number generator that returns integers in the set {0,1,...,n-1}
with equal probability; use as few calls to it as possible.
Time Complexity: O(n)
Space Complexity: O(1)
 */
public class RandomPermutation {

    public static void main(String[] args) {
        computeRandomPermutation(5);
    }

    public static List<Integer> computeRandomPermutation(int n) {
        List<Integer> randomPermutation = new ArrayList<>(n);
        for(int i = 0; i < n; i++) {
            randomPermutation.add(i);
        }
        OfflineSampling.randomSampling(n, randomPermutation);
        return randomPermutation;
    }
}
