package epi.arrays.multidimensional._6._19.variant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Question:
 * Compute the n-th row of Pascal's triangle using O(n) space.
 * ---
 * Solution:
 * We can compute the n-th row by keeping an array of current computed row.
 * ---
 * Time Complexity: O(n^2)
 * Space Complexity: O(n)
 */
public class PascalTriangleNthRowUsingNSpace {
    public static void main(String[] args) {
        assertEquals(Collections.singletonList(1), getNthRow(1));
        assertEquals(Arrays.asList(1, 1), getNthRow(2));
        assertEquals(Arrays.asList(1, 2, 1), getNthRow(3));
        assertEquals(Arrays.asList(1, 3, 3, 1), getNthRow(4));
        assertEquals(Arrays.asList(1, 4, 6, 4, 1), getNthRow(5));
        assertEquals(Arrays.asList(1, 5, 10, 10, 5, 1), getNthRow(6));
    }

    private static List<Integer> getNthRow(int n) {
        List<Integer> row = new ArrayList<>(Collections.nCopies(n + 1, 0));

        row.set(0, 1);

        for (int i = 1; i < n; i++) {
            row.set(i, 1);
            // Make sure we start from the end, other we will use the already previous computed value
            for (int j = i - 1; j > 0; j--) {
                row.set(j, row.get(j) + row.get(j - 1));
            }
        }

        for (int i = row.size() - 1; i >= 0 && row.get(i) == 0; i--) {
            row.remove(i);
        }

        return row;
    }
}
