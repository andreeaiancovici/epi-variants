package epi.primitive;

import java.util.Random;

import static org.junit.Assert.assertTrue;

/*
How would you implement a random number generator that generates a random
integer i between a and b, inclusive, given a random number generator that produces
zero or one with equal probability? All values in [a,b] should be equally likely.
Time Complexity: O(log(normalizedBound + 1) -> normalizedBound + 1 is a power of 2
Space Complexity: O(1)
 */
public class UniformRandomNumber {

    public static void main(String[] args) {
        System.out.println(uniformRandom(100,200));
    }

    private static int uniformRandom(int lowerBound, int upperBound) {
        int normalizedBound = upperBound - lowerBound + 1;
        int randomNumber;

        do {
            randomNumber = 0;
            for (int i = 0; (1 << i) <= normalizedBound; i++) {
                randomNumber |= (zeroOneRandom() << i);
            }
        } while (randomNumber < 1 || randomNumber > normalizedBound);

        return randomNumber + lowerBound - 1;
    }

    private static int zeroOneRandom() {
        Random gen = new Random();
        return gen.nextInt(2);
    }
}
