package epi.arrays._6._12;

import java.util.*;

/**
 * Question:
 * Design a program that takes as input a size k, and reads packets, continuously
 * maintaining a uniform random subset of size k of the read packets.
 * ---
 * Memo:
 * Reservoir Sampling
 * Create an array [0, k-1] and copy first k items of the stream in it.
 * Iterate from (k + 1)th item to nth item and generate a random number j, from 0 to i,
 * where i is the index of the current item in the stream.
 * If the generated number is in range [0, k-1], replace array[j] with stream[i].
 * ---
 * Solution:
 * Apply Reservoir Sampling algorithm.
 * ---
 * Time Complexity: O(total numbers in stream)
 * Space Complexity: O(k)
 */
public class OnlineSampling {

    public static void main(String[] args) {
        onlineRandomSample(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9).iterator(), 5);
    }

    private static List<Integer> onlineRandomSample(Iterator<Integer> stream, int k) {
        List<Integer> result = new ArrayList<>(k);

        // Add the first k elements from the stream in the array
        for (int i = 0; stream.hasNext() && i < k; i++) {
            result.add(stream.next());
        }

        // Have read the first k elements
        int numSeenSoFar = k;
        Random random = new Random();
        while (stream.hasNext()) {
            Integer number = stream.next();
            numSeenSoFar++;
            // Generate a random number x in [0, numSeenSoFar], and if this number is in
            // [0, k - 1], we replace that element from the sample with x
            int index = random.nextInt(numSeenSoFar);
            if (index < k) {
                result.set(index, number);
            }
        }
        return result;
    }
}
