package epi.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

/*
Write a program that takes an integer argument and returns all the primes between 1 and that integer.
Time Complexity: O(n/2 + n/3 + n/5+ n/7 + n/11 + ...) => O(sqrt(n) * log(log(n)))
Space Complexity: O(n)
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
        for(int i = 2; i < isPrime.size(); i++) {
            if(isPrime.get(i)) {
                primes.add(i);
            }
        }

        return primes;
    }
}
