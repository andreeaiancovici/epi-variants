package epi.arrays.multidimensional._6._17.variant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Question:
 * Given a dimension d, write a program to generate a d X d 2D array,
 * which in spiral order is (1,2,3,d^2). For example, if d = 3, the result should be:
 *     ┌           ┐
 *     │ 1   2   3 │
 *     │           │
 * A = │ 8   9   4 │
 *     │           │
 *     │ 7   6   5 │
 *     └           ┘
 * ---
 * Solution:
 * Compute size and number of layers in result matrix.
 * Iterate over each layer, keeping indexes for start / end of rows and columns.
 * In the same time, keep a counter for elements in the input array.
 * ---
 * Time Complexity: O(d^2)
 * Space Complexity: O(1), if we don't count the size of the resulting matrix
 */
public class GenerateMatrixFromSpiralOrder {

    public static void main(String[] args) {
        assertEquals(Collections.emptyList(), generateMatrix(Collections.emptyList()));
        assertEquals(Collections.singletonList(Collections.singletonList(1)), generateMatrix(Collections.singletonList(1)));
        assertEquals(Arrays.asList(
                Arrays.asList(1, 2),
                Arrays.asList(4, 3)
        ), generateMatrix(Arrays.asList(1, 2, 3, 4)));
        assertEquals(Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(8, 9, 4),
                Arrays.asList(7, 6, 5)
        ), generateMatrix(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9)));
        assertEquals(Arrays.asList(
                Arrays.asList(1, 2, 3, 4),
                Arrays.asList(12, 13, 14, 5),
                Arrays.asList(11, 16, 15, 6),
                Arrays.asList(10, 9, 8, 7)
        ), generateMatrix(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16)));
    }

    private static List<List<Integer>> generateMatrix(List<Integer> spiralOrder) {
        if (spiralOrder.isEmpty()) {
            return Collections.emptyList();
        }

        int size = (int) Math.sqrt(spiralOrder.get(spiralOrder.size() - 1));

        // Initialize spiral matrix result
        List<List<Integer>> matrix = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            matrix.add(new ArrayList<>(Collections.nCopies(size, 0)));
        }

        int startRow = 0, endRow = size - 1, startColumn = 0, endColumn = size - 1;
        int k = 0;
        // Notice that number of layers is dependent on size
        // - even => layers = size / 2
        // - odd => layers = size / 2 + 1 (or simply size % 2, which is 0 or 1);
        int layers = size / 2 + size % 2;

        // Iterate layers, keep counters for start / end of rows and columns
        // Keep a counter for iterating the input array
        for (int p = 0; p < layers; p++, startRow++, endRow--, startColumn++, endColumn--) {
            for (int j = startColumn; j <= endColumn; j++, k++) {
                matrix.get(startRow).set(j, spiralOrder.get(k));
            }

            for (int i = startRow + 1; i <= endRow; i++, k++) {
                matrix.get(i).set(endColumn, spiralOrder.get(k));
            }

            for (int j = endColumn - 1; j >= startColumn; j--, k++) {
                matrix.get(endRow).set(j, spiralOrder.get(k));
            }

            for (int j = endRow - 1; j > startRow; j--, k++) {
                matrix.get(j).set(startColumn, spiralOrder.get(k));
            }
        }

        return matrix;
    }
}