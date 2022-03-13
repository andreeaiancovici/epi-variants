package epi.arrays.multidimensional._6._17.variant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Question:
 * Given a sequence of integers P, compute a 2D array A whose spiral order is P.
 * (Assume the size of P is n^2 for some integer n.)
 * ---
 * Solution:
 * Think of a matrix as a layer construction.
 * Iterate over each layer, keeping indexes for start / end of rows and columns.
 * In the same time, keep a counter for elements in the input array.
 * ---
 * Time Complexity: O(n^2)
 * Space Complexity: O(1), if we don't count the size of the resulting matrix
 */
public class GenerateMatrixFromPSequence {

    public static void main(String[] args) {
        assertEquals(Arrays.asList(
                Arrays.asList(1, 3, 0),
                Arrays.asList(3, 0, 1),
                Arrays.asList(0, 2, 3)
        ), generateMatrix(Arrays.asList(1, 3, 0, 1, 3, 2, 0, 3, 0)));
    }

    private static List<List<Integer>> generateMatrix(List<Integer> spiralOrder) {
        if (spiralOrder.isEmpty()) {
            return Collections.emptyList();
        }

        int size = (int) Math.sqrt(spiralOrder.size());

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
