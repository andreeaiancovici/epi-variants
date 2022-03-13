package epi.arrays.multidimensional._6._17.variant;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Question:
 * Compute the last element in spiral order for an m X n 2D array A in O(1) time.
 * ---
 * Solution:
 * Compute corresponding indexes for starting and ending rows and columns in the layer where the last element is found.
 * Retrieve the last element according to 4 specific cases.
 * ---
 * Time Complexity: O(1)
 * Space Complexity: O(1)
 */
public class LastElementSpiralOrderingForMxNMatrix {

    public static void main(String[] args) {
        assertEquals(1, lastElementInSpiralOrder(Collections.singletonList(
                Collections.singletonList(1)
        )));

        assertEquals(1, lastElementInSpiralOrder(Collections.singletonList(
                Arrays.asList(1, 3, 0, 1)
        )));

        assertEquals(7, lastElementInSpiralOrder(Arrays.asList(
                Arrays.asList(1, 3, 0, 1),
                Arrays.asList(7, 4, 1, 3)
        )));

        assertEquals(1, lastElementInSpiralOrder(Arrays.asList(
                Collections.singletonList(1),
                Collections.singletonList(3),
                Collections.singletonList(0),
                Collections.singletonList(1)
        )));

        assertEquals(7, lastElementInSpiralOrder(Arrays.asList(
                Arrays.asList(1, 3),
                Arrays.asList(7, 0),
                Arrays.asList(4, 1),
                Arrays.asList(1, 3)
        )));

        assertEquals(1, lastElementInSpiralOrder(Arrays.asList(
                Arrays.asList(1, 3, 0, 1),
                Arrays.asList(7, 4, 1, 3),
                Arrays.asList(6, 3, 0, 2)
        )));

        assertEquals(1, lastElementInSpiralOrder(Arrays.asList(
                Arrays.asList(1, 3, 0),
                Arrays.asList(7, 4, 1),
                Arrays.asList(6, 1, 3),
                Arrays.asList(3, 0, 2)
        )));

        assertEquals(4, lastElementInSpiralOrder(Arrays.asList(
                Arrays.asList(1, 3, 0),
                Arrays.asList(7, 4, 1),
                Arrays.asList(6, 1, 3)
        )));

        assertEquals(3, lastElementInSpiralOrder(Arrays.asList(
                Arrays.asList(1, 3, 0, 1),
                Arrays.asList(7, 4, 1, 3),
                Arrays.asList(6, 3, 0, 2),
                Arrays.asList(8, 5, 3, 1)
        )));

        assertEquals(9, lastElementInSpiralOrder(Arrays.asList(
                Arrays.asList(1, 3, 0, 1, 2, 3),
                Arrays.asList(7, 4, 1, 3, 2, 3),
                Arrays.asList(6, 3, 0, 2, 2, 3),
                Arrays.asList(8, 5, 9, 1, 2, 3),
                Arrays.asList(8, 5, 3, 1, 2, 3),
                Arrays.asList(8, 5, 3, 1, 2, 3)
        )));
    }

    private static int lastElementInSpiralOrder(List<List<Integer>> squareMatrix) {
        int m = squareMatrix.size();
        int n = squareMatrix.get(0).size();

        int totalElements = m * n;
        int noElementsInLayer = getNoElements(m, n);

        // Check if we have multiple nesting layers
        if (totalElements == noElementsInLayer) {
            // If not, the last element should be contained in the original matrix
            return findLastElement(0, m - 1, 0, n - 1, squareMatrix);
        } else {
            // Otherwise, subtract the outer layers until we reach the inner one containing the last element
            // Keep in mind that we will subtract the minimum number of layers which is permitted by the 2 matrix dimensions
            // In other words, see what the minimum dimension is and use it as a base of calculating the number of layers to be subtracted
            // E.g. If we have 4 rows and 7 columns, we can only subtract 2 layers due to the fact that the minimum dimension is 4
            int minSize = Math.min(m, n);
            int layers = (minSize - 1) / 2;

            int innerM = m - 2 * layers;
            int innerN = n - 2 * layers;

            // Search the last element in the inner matrix using the same logic as in the first case
            return findLastElement(layers, layers + innerM - 1, layers, layers + innerN - 1, squareMatrix);
        }
    }

    private static int findLastElement(int startRow, int endRow,
                                       int startColumn, int endColumn,
                                       List<List<Integer>> squareMatrix) {
        if (startRow == endRow) {
            if (startColumn == endColumn) {
                return squareMatrix.get(startRow).get(startColumn);
            } else {
                return squareMatrix.get(startRow).get(endColumn);
            }
        } else {
            if (startColumn == endColumn) {
                return squareMatrix.get(endRow).get(startColumn);
            } else {
                return squareMatrix.get(startRow + 1).get(startColumn);
            }
        }
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
}
