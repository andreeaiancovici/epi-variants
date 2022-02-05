package epi.primitive._5._10;

import java.util.Random;

/**
 * Question:
 * How would you implement a random number generator that generates a random
 * integer i between a and b, inclusive, given a random number generator that produces
 * zero or one with equal probability? All values in [a,b] should be equally likely.
 * ---
 * Memo:
 * When iterating through the number of bits in x, the complexity should consider that x is actually 2^k.
 * Therefore, iterating through each bit from x takes log(x).
 * x = 2^k
 * log(x) = log2^k = k
 * ---
 * Solution:
 * We need to random generate each bit of our target number, between a and b.
 * Because generating all bits until b is reached takes too much time,
 * we can normalize the boundaries from [a,b] to (0,b - a + 1].
 * Next step is to generate all bits in our newly defined interval until we match a bounded number.
 * Complexity explained:
 * b - a + 1 = 2^k
 * log(b - a + 1) = log2^k = k
 * We iterate through the number of bits in b - a + 1 which is k.
 * ---
 * Time Complexity: O(log(b - a + 1)) -> b - a + 1 represents the normalized upper bound and it is a power of 2
 * Space Complexity: O(1)
 */
public class UniformRandomNumber {

    public static void main(String[] args) {
        System.out.println(uniformRandom(100,200));
    }

    private static int uniformRandom(int lowerBound, int upperBound) {
        // Normalize upper bound between [0,x], where x is the normalized upper bound
        // E.g  a = 3, b = 12 => between 3 and 12 inclusive there are 10 numbers
        // 12 - 3 + 1 = 10
        int normalizedBound = upperBound - lowerBound + 1;
        int randomNumber;

        do {
            randomNumber = 0;
            // For each bit position, generate a random number 0 or 1
            for (int i = 0; (1 << i) <= normalizedBound; i++) {
                randomNumber |= (zeroOneRandom() << i);
            }
            // Repeat steps until result is between 1 and normalized bound
        } while (randomNumber < 1 || randomNumber > normalizedBound);

        // Denormalize result
        return randomNumber + lowerBound;
    }

    // Random number generator that produces zero or one
    private static int zeroOneRandom() {
        Random gen = new Random();
        return gen.nextInt(2);
    }
}