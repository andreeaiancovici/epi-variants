package epi.arrays.multidimensional._6._17.variant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Question:
 * Write a program to enumerate the first n pairs of integers (a,b) in spiral order,
 * starting from (0, 0) followed by (1, 0). For example, if n = 10,
 * your output should be (0, 0), (1, 0), (1, -1), (0, -1), (-1, -1), (-1, 0),
 * (-1, 1), (0, 1), (1, 1), (2, 1).
 * ---
 * Solution:
 * In order to have a better understanding how to approach the solution,
 * we should start by visualizing the generated pairs as a matrix:
 * (-1, -1)  (-1, 0)  (-1, 1)
 * ( 0, -1)  ( 0, 0)  ( 0, 1)
 * ( 1, -1)  ( 1, 0)  ( 1, 1)
 *                    ( 2, 1)
 * Notice how the numbers are actually index positions in a matrix.
 * Center element should have coordinates (0, 0).
 * While counting the numbers up to n, we start iterating columns and rows in a spiral mode,
 * and add each coordinate pair to the result array.
 * The spiral goes as follows: column left -> row up -> column right -> row down.
 * ---
 * Time Complexity: O(n)
 * Space Complexity: O(1), if we don't count the size of the resulting matrix
 */
public class EnumeratePairsInSpiralOrder {

    public static void main(String[] args) {
        assertEquals(Arrays.asList(
                Arrays.asList(0, 0),
                Arrays.asList(1, 0),
                Arrays.asList(1, -1),
                Arrays.asList(0, -1),
                Arrays.asList(-1, -1),
                Arrays.asList(-1, 0),
                Arrays.asList(-1, 1),
                Arrays.asList(0, 1),
                Arrays.asList(1, 1),
                Arrays.asList(2, 1),
                Arrays.asList(2, 0),
                Arrays.asList(2, -1),
                Arrays.asList(2, -2),
                Arrays.asList(1, -2),
                Arrays.asList(0, -2),
                Arrays.asList(-1, -2),
                Arrays.asList(-2, -2),
                Arrays.asList(-2, -1),
                Arrays.asList(-2, 0),
                Arrays.asList(-2, 1),
                Arrays.asList(-2, 2),
                Arrays.asList(-1, 2),
                Arrays.asList(0, 2),
                Arrays.asList(1, 2),
                Arrays.asList(2, 2)
        ), enumeratePairs(25));
    }

    private static List<List<Integer>> enumeratePairs(int n) {
        List<List<Integer>> pairs = new ArrayList<>();

        if (n == 0) {
            return pairs;
        }

        // Add the center element
        pairs.add(Arrays.asList(0, 0));

        int startRow = -1, endRow = 1, startColumn = -1, endColumn = 1;
        int startingRowPoint = 1, startingColumnPoint = 0;

        int k = 0;
        // Iterate until we have n numbers in the list
        while (k < n - 1) {
            // If we finished a spiral layer in the matrix, reset starting and ending rows and columns
            int row = startingRowPoint;
            int column = startingColumnPoint;
            while (row != column) {
                for (; column > startColumn && k < n - 1; column--, k++) {
                    pairs.add(Arrays.asList(row, column));
                }

                for (row = endRow; row > startRow && k < n - 1; row--, k++) {
                    pairs.add(Arrays.asList(row, column));
                }

                for (column = startColumn; column < endColumn && k < n - 1; column++, k++) {
                    pairs.add(Arrays.asList(row, column));
                }

                for (row = startRow; row <= endRow && k < n - 1; row++, k++) {
                    pairs.add(Arrays.asList(row, column));
                }

                startRow--;
                endRow++;
                startColumn--;
                endColumn++;

                startingRowPoint = row + 1;
                startingColumnPoint = column;
            }
        }

        return pairs;
    }
}
