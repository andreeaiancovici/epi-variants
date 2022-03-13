package epi.arrays.multidimensional._6._17.variant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Question:
 * Compute the spiral order for an m X n 2D array A.
 * ---
 * Solution:
 * Compute size of rows and columns.
 * Iterate over each layer from the matrix, starting from out layers to inner ones.
 * ---
 * Time Complexity: O(m X n)
 * Space Complexity: O(1)
 */
public class SpiralOrderingForMxNMatrix {

    public static void main(String[] args) {
        assertEquals(Collections.singletonList(1), matrixInSpiralOrder(Collections.singletonList(
                Collections.singletonList(1)
        )));

        assertEquals(Arrays.asList(1, 3, 0, 1), matrixInSpiralOrder(Collections.singletonList(
                Arrays.asList(1, 3, 0, 1)
        )));

        assertEquals(Arrays.asList(1, 3, 0, 1), matrixInSpiralOrder(Arrays.asList(
                Collections.singletonList(1),
                Collections.singletonList(3),
                Collections.singletonList(0),
                Collections.singletonList(1)
        )));

        assertEquals(Arrays.asList(1, 3, 0, 1, 3, 1, 4, 7), matrixInSpiralOrder(Arrays.asList(
                Arrays.asList(1, 3, 0, 1),
                Arrays.asList(7, 4, 1, 3)
        )));

        assertEquals(Arrays.asList(1, 3, 0, 1, 3, 1, 4, 7), matrixInSpiralOrder(Arrays.asList(
                Arrays.asList(1, 3),
                Arrays.asList(7, 0),
                Arrays.asList(4, 1),
                Arrays.asList(1, 3)
        )));

        assertEquals(Arrays.asList(1, 3, 0, 1, 3, 2, 0, 3, 6, 7, 4, 1), matrixInSpiralOrder(Arrays.asList(
                Arrays.asList(1, 3, 0, 1),
                Arrays.asList(7, 4, 1, 3),
                Arrays.asList(6, 3, 0, 2)
        )));

        assertEquals(Arrays.asList(1, 3, 0, 1, 3, 2, 0, 3, 6, 7, 4, 1), matrixInSpiralOrder(Arrays.asList(
                Arrays.asList(1, 3, 0),
                Arrays.asList(7, 4, 1),
                Arrays.asList(6, 1, 3),
                Arrays.asList(3, 0, 2)
        )));

        assertEquals(Arrays.asList(1, 3, 0, 1, 3, 1, 6, 7, 4), matrixInSpiralOrder(Arrays.asList(
                Arrays.asList(1, 3, 0),
                Arrays.asList(7, 4, 1),
                Arrays.asList(6, 1, 3)
        )));

        assertEquals(Arrays.asList(1, 3, 0, 1, 3, 2, 1, 3, 5, 8, 6, 7, 4, 1, 0, 3), matrixInSpiralOrder(Arrays.asList(
                Arrays.asList(1, 3, 0, 1),
                Arrays.asList(7, 4, 1, 3),
                Arrays.asList(6, 3, 0, 2),
                Arrays.asList(8, 5, 3, 1)
        )));
    }

    private static List<Integer> matrixInSpiralOrder(List<List<Integer>> squareMatrix) {
        int m = squareMatrix.size();
        int n = squareMatrix.get(0).size();

        List<Integer> result = new ArrayList<>();

        for (int i = 0, j = 0; i < m && j < n; i++, j++) {
            // Iterate over each layer and perform spiral ordering
            int noElements = getNoElements(m - (2 * i), n - (2 * j));
            matrixInSpiralOrderHelper(squareMatrix, i, m - 1 - i, j, n - 1 - j, result, noElements);
        }

        return result;
    }

    private static int getNoElements(int m, int n) {
        if (m == 1 && n == 1) {
            return 1;
        }

        if (m == 1) {
            return n;
        }

        if (n == 1) {
            return m;
        }

        return 2 * m + 2 * (n - 2);
    }

    private static void matrixInSpiralOrderHelper(List<List<Integer>> squareMatrix, int startRow, int endRow,
                                                  int startColumn, int endColumn, List<Integer> result, int noElements) {
        // We use a counter for number of elements contained in the current layer
        int k = 0;
        for (int i = startColumn; i <= endColumn && k < noElements; i++, k++) {
            result.add(squareMatrix.get(startRow).get(i));
        }

        for (int i = startRow + 1; i <= endRow && k < noElements; i++, k++) {
            result.add(squareMatrix.get(i).get(endColumn));
        }

        for (int i = endColumn - 1; i >= startColumn && k < noElements; i--, k++) {
            result.add(squareMatrix.get(endRow).get(i));
        }
        for (int i = endRow - 1; i > startRow && k < noElements; i--, k++) {
            result.add(squareMatrix.get(i).get(startColumn));
        }
    }
}