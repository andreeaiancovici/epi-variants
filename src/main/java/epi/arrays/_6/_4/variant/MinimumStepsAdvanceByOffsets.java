package epi.arrays._6._4.variant;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Question:
 * Write a program to compute the minimum number of steps needed to advance to the last location.
 * ---
 * Solution:
 * Greedy solution
 * The approach here is to compute a current interval [i, current jump].
 * While iterating this interval, we compute the maximum jump from each element.
 * When finally reaching the end of the interval, we should assign a new current jump
 * with the farthest jump value so far.
 * ---
 * Time Complexity: O(n) - for Greedy solution
 * Space Complexity: O(1)
 */
public class MinimumStepsAdvanceByOffsets {

    public static void main(String[] args) {
        List<Integer> maxAdvanceSteps = Arrays.asList(2, 3, 1, 1, 4);

        assertEquals(2, getMinimumNumberOfSteps(maxAdvanceSteps));
    }

    // Greedy solution
    private static int getMinimumNumberOfSteps(List<Integer> maxAdvanceSteps) {
        int jumps = 0, currentJump = 0, farthestJump = 0;

        for(int i = 0; i < maxAdvanceSteps.size() - 1; i++) {
            // Compute the farthest jump int current interval [i, current jump]
            farthestJump = Math.max(farthestJump, maxAdvanceSteps.get(i) + i);
            // Check if we reached end of the current interval [i, current jump]
            if(i == currentJump) {
                // assign new current jump
                currentJump = farthestJump;
                // we did a jump
                jumps++;
            }
        }

        return jumps;
    }
}
