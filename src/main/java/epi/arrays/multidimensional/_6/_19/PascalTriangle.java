package epi.arrays.multidimensional._6._19;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Question:
 * Write a program which takes as input a non-negative integer n and returns the first n
 * rows of Pascal's triangle.
 * ---
 * Solution:
 * Until we reach row n, for each element in row i, compute:
 * pascalTriangle.get(i - 1).get(j - 1) + pascalTriangle.get(i - 1).get(j),
 * where j is the current column.
 * ---
 * Time Complexity: O(n^2)
 * Space Complexity: O(1)
 */
public class PascalTriangle {

    public static void main(String[] args) {
        assertEquals(Arrays.asList(
                Collections.singletonList(1),
                Arrays.asList(1, 1),
                Arrays.asList(1, 2, 1),
                Arrays.asList(1, 3, 3, 1),
                Arrays.asList(1, 4, 6, 4, 1)
        ), generatePascalTriangle(5));
    }

    private static List<List<Integer>> generatePascalTriangle(int numRows) {
        if (numRows == 0) {
            return Collections.emptyList();
        }

        List<List<Integer>> pascalTriangle = new ArrayList<>();

        pascalTriangle.add(Collections.singletonList(1));

        // Corner cases when we have 1 or 2 rows
        if (numRows == 1) {
            return pascalTriangle;
        }

        pascalTriangle.add(Arrays.asList(1, 1));

        if (numRows == 2) {
            return pascalTriangle;
        }

        // Starting from the third row, we apply the same algorithm
        for (int i = 2; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            row.add(1);
            for (int j = 1; j < i; j++) {
                row.add(pascalTriangle.get(i - 1).get(j - 1) + pascalTriangle.get(i - 1).get(j));
            }
            row.add(1);
            pascalTriangle.add(row);
        }

        return pascalTriangle;
    }
}
