package epi.arrays._6._15.variant;


/**
 * Question:
 * Given a random number generator that produces values in [0,1] uniformly,
 * how would you generate a value X from T according to a continuous probability distribution,
 * such as the exponential distribution?
 * ---
 * Solution:
 * The probability density function of an exponential distribution is:
 * f(x;lambda) = lambda * e^(-lambda * x), where x >= 0
 * Therefore we can map a number in interval [0,1] to a number in interval [0, +infinite),
 * by converting x to 1/x (exception when x = 0).
 */
public class NonuniformRandomNumberExpDist {}
