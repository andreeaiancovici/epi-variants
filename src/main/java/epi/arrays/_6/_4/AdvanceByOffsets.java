package epi.arrays._6._4;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Question:
 * Write a program which takes an array of n integers, where A[i] denotes the maximum
 * you can advance from index i, and returns whether it is possible to advance to the
 * last index starting from the beginning of the array.
 * ---
 * Solution:
 * Greedy solution
 * The idea if this approach is to iterate through all position and re-compute
 * maximum jump from the current position, if the current position is within
 * the boundaries of the current maximum jump.
 * ---
 * Time Complexity: O(n) - for Greedy solution
 * Space Complexity: O(1)
 */
public class AdvanceByOffsets {

    private static int[] memo;

    public static void main(String[] args) {
        List<Integer> maxAdvanceSteps = Arrays.asList(2, 3, 1, 1, 4);

        // Required for DP solutions
        memo = new int[maxAdvanceSteps.size()];
        memo[memo.length - 1] = 1;

        assertTrue(canReachEnd(maxAdvanceSteps));
        assertTrue(canReachEndBT(0, maxAdvanceSteps));
        assertTrue(canReachEndDPTopDown(0, maxAdvanceSteps));
        assertTrue(canReachEndDPBottomUp(maxAdvanceSteps));
    }

    // Greedy solution
    private static boolean canReachEnd(List<Integer> maxAdvanceSteps) {
        int maxStep = 0;
        for (int i = 0; i < maxAdvanceSteps.size(); i++) {
            // Check if current element is within the max jump so far
            if (i <= maxStep) {
                // Re-compute max jump with max jump from current element
                maxStep = Math.max(maxStep, i + maxAdvanceSteps.get(i));
            }
        }
        // If the final max jump is greater or equal to last position in the array
        // it means that we have reached the end
        return maxStep >= maxAdvanceSteps.size() - 1;
    }

    // Backtracking solution
    private static boolean canReachEndBT(int index, List<Integer> maxAdvanceSteps) {
        if (index == maxAdvanceSteps.size() - 1) {
            return true;
        }

        int maxJump = Math.min(index + maxAdvanceSteps.get(index), maxAdvanceSteps.size() - 1);

        for (int i = index + 1; i <= maxJump; i++) {
            if (canReachEndBT(i, maxAdvanceSteps)) {
                return true;
            }
        }

        return false;
    }

    // Dynamic Programming Top-Down solution
    // Using memo array for memoization
    private static boolean canReachEndDPTopDown(int index, List<Integer> maxAdvanceSteps) {
        if (memo[index] != 0) {
            return memo[index] == 1;
        }

        int maxJump = Math.min(index + maxAdvanceSteps.get(index), maxAdvanceSteps.size() - 1);

        for (int i = index + 1; i <= maxJump; i++) {
            if (canReachEndDPTopDown(i, maxAdvanceSteps)) {
                memo[index] = 1;
                return true;
            }
        }

        memo[index] = -1;
        return false;
    }

    // Dynamic Programming Bottom-Up solution
    // Eliminate recursion by trying to reverse the order of the steps from top-down solution
    // E.g. iterate from right to left
    private static boolean canReachEndDPBottomUp(List<Integer> maxAdvanceSteps) {
        memo = new int[maxAdvanceSteps.size()];
        memo[memo.length - 1] = 1;

        for (int i = maxAdvanceSteps.size() - 2; i >= 0; i--) {
            int maxJump = Math.min(i + maxAdvanceSteps.get(i), maxAdvanceSteps.size() - 1);
            for (int j = i + 1; j <= maxJump; j++) {
                if (memo[j] == 1) {
                    memo[i] = 1;
                    break;
                }
            }
        }

        return memo[0] == 1;
    }
}
