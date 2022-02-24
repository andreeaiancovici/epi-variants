package epi.arrays._6._8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Question:
 * Write a program that takes an integer argument and returns all the primes between 1 and that integer.
 * ---
 * Memo:
 * Sieve of Eratosthenes
 * ---
 * Solution:
 * The solution implies using the algorithm called "Sieve of Eratosthenes".
 * Iterate from 2 to n and check if position (let's called it index) is marked as prime number.
 * If not, proceed with iterating through all multiples of index, until n, and marked them as non prime numbers.
 * Optimisations:
 * - for the outer loop, we can iterate until sqrt(n);
 * - for the inner loop, we can start iterating from position = index * index, since previous multiples were already covered.
 * (when arriving at 3, we notice that 2 * 3 is already processed, so we can skip to 3 * 3)
 * Here is a concrete example, having n = 30:
 * 6 * 1 = 6 = 1 * 6
 * 6 * 2 = 12 = 2 * 6
 * 6 * 3 = 18 = 3 * 6
 * 6 * 4 = 24 = 2 * 12
 * 6 * 5 = 30 = 5 * 6
 * 6 * 6 = 36 > 30
 * Notice in the above example, sqrt(n) would be > 5.
 * This means that any multiple higher than 5 would be higher than n.
 * Another aspect to take in consideration is that all multiples of 6 (1, 2, 3, 5)
 * were already processed in previous iterations.
 * ---
 * Time Complexity: O(n/2 + n/3 + n/5+ n/7 + n/11 + ...) => O(n * log(log(n)))
 * Space Complexity: O(n)
 */
//TODO: Analyze time complexity
public class PrimeSieve {

    public static void main(String[] args) {
        assertEquals(Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67), countPrimes(70));
    }

    public static List<Integer> countPrimes(int n) {
        List<Boolean> isPrime = new ArrayList<>(Collections.nCopies(n + 1, true));

        // Until sqrt(n), all multiples of prime numbers are covered
        for (int i = 2; i <= (int) Math.sqrt(n); i++) {
            if (isPrime.get(i)) {
                // All previous multiples of i would already have been covered by previous numbers
                for (int j = i * i; j <= n; j += i) {
                    isPrime.set(j, false);
                }
            }
        }

        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i < isPrime.size(); i++) {
            if (isPrime.get(i)) {
                primes.add(i);
            }
        }

        return primes;
    }
}
