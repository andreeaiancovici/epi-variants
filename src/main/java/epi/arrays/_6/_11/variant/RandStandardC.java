package epi.arrays._6._11.variant;

/**
 * Question:
 * The rand() function in the standard C library returns a uniformly random number in [0, RAND_MAX — 1].
 * Does rand() mod n generate a number uniformly distributed in [0, n - 1]?
 * ---
 * Solution:
 * No, it won't generate an uniformly distributed number.
 * If n is not a divisor of RAND_MAX, we will always have some values with a higher probability of occurrence.
 * We should take in consideration only values from [0, k * n] such that k * n <= RAND_MAX <= (k + 1) * n.
 * For uniform distribution we can consider k = (RAND_MAX / n) * n.
 */
public class RandStandardC { }
