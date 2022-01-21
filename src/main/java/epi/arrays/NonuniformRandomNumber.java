package epi.arrays;

import java.util.*;

/*
You are given n numbers as well as probabilities [p0,p1,...pn-1] which sum up to
1. Given a random number generator that produces values in [0,1] uniformly, how
would you generate one of the n numbers according to the specified probabilities?
Time Complexity: O(n)
Space Complexity: O(1)
 */
public class NonuniformRandomNumber {

    public static void main(String[] args) {
        nonuniformRandomNumberGeneration(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22), Arrays.asList(0.30467113247563304, 0.5788668976381448, 0.10831991606460778, 0.0038726480423313804, 0.002761971229793556, 0.0007723317467801776, 0.00029056261851554945, 0.00032866379168359095, 7.343040595782476e-05, 7.688503298986141e-06, 2.9863931477716213e-05, 2.333828937751215e-06, 2.0637828639435128e-06, 1.7430479764387374e-07, 2.0434099593076387e-07, 1.0436441997574756e-07, 7.159135134005881e-09, 3.030895692651246e-09, 1.955521875172751e-09, 5.755472555491992e-10, 1.293369559130077e-11, 1.0569508312783955e-10, 9.003160695238913e-11));
    }

    public static int nonuniformRandomNumberGeneration(List<Integer> values,
                                     List<Double> probabilities) {
        List<Double> intervals = new ArrayList<>();
        for (int i = 0; i < probabilities.size(); i++) {
            if (i == 0) {
                intervals.add(probabilities.get(i));
            } else {
                intervals.add(intervals.get(i - 1) + probabilities.get(i));
            }
        }

        Random random = new Random();
        double probability = random.nextDouble();

        int index = Collections.binarySearch(intervals, probability);
        if(index < 0) {
            // When a key is not present in the array, Collections.binarySearch()
            // returns the negative of 1 plus the smallest index whose entry
            // is greater than the key.
            return values.get(Math.abs(index) - 1);
        } else {
            return values.get(index);
        }
    }
}
