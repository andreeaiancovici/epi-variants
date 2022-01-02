package epi.arrays;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

/*
Write a program which takes an array of n integers, where A[i] denotes the maximum
you can advance from index i, and returns whether it is possible to advance to the
last index starting from the beginning of the array.
Greedy solution
Time Complexity: O(n)
Space Complexity: O(1)
 */
public class AdvanceByOffsets {

    private static int[] memo;

    public static void main(String[] args) {
        List<Integer> maxAdvanceSteps = Arrays.asList(2, 3, 1, 1, 4);

        //Required for DP solutions
        memo = new int[maxAdvanceSteps.size()];
        memo[memo.length - 1] = 1;

        assertTrue(canReachEnd(maxAdvanceSteps));
        assertTrue(canReachEndBT(0, maxAdvanceSteps));
        assertTrue(canReachEndDP1(0, maxAdvanceSteps));
        assertTrue(canReachEndDP2(maxAdvanceSteps));
    }

    //Greedy solution
    private static boolean canReachEnd(List<Integer> maxAdvanceSteps) {
        int maxStep = 0;
        for (int i = 0; i < maxAdvanceSteps.size(); i++) {
            if (i <= maxStep) {
                maxStep = Math.max(maxStep, i + maxAdvanceSteps.get(i));
            }
        }
        return maxStep >= maxAdvanceSteps.size() - 1;
    }

    //Backtracking solution
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

    //Dynamic Programming Top-Down solution
    //Using memo array for memoization
    private static boolean canReachEndDP1(int index, List<Integer> maxAdvanceSteps) {
        if (memo[index] != 0) {
            return memo[index] == 1;
        }

        int maxJump = Math.min(index + maxAdvanceSteps.get(index), maxAdvanceSteps.size() - 1);

        for (int i = index + 1; i <= maxJump; i++) {
            if (canReachEndDP1(i, maxAdvanceSteps)) {
                memo[index] = 1;
                return true;
            }
        }

        memo[index] = -1;
        return false;
    }

    //Dynamic Programming Bottom-Up solution
    //Eliminate recursion by trying to reverse the order of the steps from top-down solution
    //E.g. iterate from right to left
    private static boolean canReachEndDP2(List<Integer> maxAdvanceSteps) {
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
