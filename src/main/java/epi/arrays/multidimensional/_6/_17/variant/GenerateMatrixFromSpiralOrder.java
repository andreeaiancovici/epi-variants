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
 * Think of a matrix as a layer construction:
 * - 1, 2, 3, 4, 5, 6, 7, 8 -> forms the first layer
 * - 9 - forms the second layer
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

        // Iterate layers, keep counters for start / end of rows and columns
        // Keep a counter for iterating the input array
        int k = 0, layer = 0;
        while (k < spiralOrder.size()) {
            for (int j = layer; j <= size - 1 - layer; j++, k++) {
                matrix.get(layer).set(j, spiralOrder.get(k));
            }

            for (int i = layer + 1; i <= size - 1 - layer; i++, k++) {
                matrix.get(i).set(size - 1 - layer, spiralOrder.get(k));
            }

            for (int j = size - 2 - layer; j >= layer; j--, k++) {
                matrix.get(size - 1 - layer).set(j, spiralOrder.get(k));
            }

            for (int j = size - 2 - layer; j > layer; j--, k++) {
                matrix.get(j).set(layer, spiralOrder.get(k));
            }

            layer++;
        }

        return matrix;
    }
}