package epi.arrays.multidimensional._6._17.variant;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Question:
 * Compute the k-th element in spiral order for an m X n 2D array A in O(1) time.
 * ---
 * Solution:
 * Compute corresponding indexes for starting and ending rows and columns in the layer where the k-th element is found.
 * Retrieve the k-th element by iterating the found layer.
 * ---
 * Time Complexity: O(1)
 * Space Complexity: O(1)
 */
public class KThElementSpiralOrderingForMxNMatrix {

    public static void main(String[] args) {
        assertEquals(1, kTkElementInSpiralOrder(Collections.singletonList(
                Collections.singletonList(1)
        ), 1));

        assertEquals(3, kTkElementInSpiralOrder(Collections.singletonList(
                Arrays.asList(1, 3, 0, 1)
        ), 2));

        assertEquals(4, kTkElementInSpiralOrder(Arrays.asList(
                Arrays.asList(1, 3, 0, 1),
                Arrays.asList(7, 4, 1, 3)
        ), 7));

        assertEquals(0, kTkElementInSpiralOrder(Arrays.asList(
                Collections.singletonList(1),
                Collections.singletonList(3),
                Collections.singletonList(0),
                Collections.singletonList(1)
        ), 3));

        assertEquals(1, kTkElementInSpiralOrder(Arrays.asList(
                Arrays.asList(1, 3),
                Arrays.asList(7, 0),
                Arrays.asList(4, 1),
                Arrays.asList(1, 3)
        ), 6));

        assertEquals(3, kTkElementInSpiralOrder(Arrays.asList(
                Arrays.asList(1, 3, 0, 1),
                Arrays.asList(7, 4, 1, 3),
                Arrays.asList(6, 3, 0, 2)
        ), 5));

        assertEquals(4, kTkElementInSpiralOrder(Arrays.asList(
                Arrays.asList(1, 3, 0),
                Arrays.asList(7, 4, 1),
                Arrays.asList(6, 1, 3),
                Arrays.asList(3, 0, 2)
        ), 11));

        assertEquals(4, kTkElementInSpiralOrder(Arrays.asList(
                Arrays.asList(1, 3, 0),
                Arrays.asList(7, 4, 1),
                Arrays.asList(6, 1, 3)
        ), 9));

        assertEquals(8, kTkElementInSpiralOrder(Arrays.asList(
                Arrays.asList(1, 3, 0, 1),
                Arrays.asList(7, 4, 1, 3),
                Arrays.asList(6, 3, 0, 2),
                Arrays.asList(8, 5, 3, 1)
        ), 10));

        assertEquals(2, kTkElementInSpiralOrder(Arrays.asList(
                Arrays.asList(1, 3, 0, 1, 2, 3),
                Arrays.asList(7, 4, 1, 3, 2, 3),
                Arrays.asList(6, 3, 0, 2, 2, 3),
                Arrays.asList(8, 5, 9, 1, 2, 3),
                Arrays.asList(8, 5, 3, 1, 2, 3),
                Arrays.asList(8, 5, 3, 1, 2, 3)
        ), 24));

        assertEquals(3, kTkElementInSpiralOrder(Arrays.asList(
                Arrays.asList(1, 3, 0, 1, 2, 3),
                Arrays.asList(7, 4, 1, 3, 2, 3),
                Arrays.asList(6, 3, 0, 2, 2, 3),
                Arrays.asList(8, 5, 9, 1, 2, 3),
                Arrays.asList(8, 5, 3, 1, 2, 3),
                Arrays.asList(8, 5, 3, 1, 2, 3)
        ), 32));
    }

    private static int kTkElementInSpiralOrder(List<List<Integer>> squareMatrix, int k) {
        int m = squareMatrix.size();
        int n = squareMatrix.get(0).size();

        int sumElementsInLayer = getNoElements(m, n);
        int layer = 0;
        int innerLayerK = k;

        // Find the layer containing the k-th element
        while (k > sumElementsInLayer) {
            m -= 2;
            n -= 2;
            innerLayerK = k - sumElementsInLayer;
            sumElementsInLayer += getNoElements(m, n);
            layer++;
        }

        // Iterate through found layer and find the k-th element
        return findKThElement(layer, layer + m - 1, layer, layer + n - 1, squareMatrix, innerLayerK);
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

    private static int findKThElement(int startRow, int endRow,
                                      int startColumn, int endColumn,
                                      List<List<Integer>> squareMatrix, int k) {
        int count = 0;
        for (int j = startColumn; j <= endColumn; j++, count++) {
            if (count == k - 1) {
                return squareMatrix.get(startRow).get(j);
            }
        }

        for (int i = startRow + 1; i <= endRow; i++, count++) {
            if (count == k - 1) {
                return squareMatrix.get(i).get(endColumn);
            }
        }

        for (int j = endColumn - 1; j >= startColumn; j--, count++) {
            if (count == k - 1) {
                return squareMatrix.get(endRow).get(j);
            }
        }

        for (int i = endRow - 1; i > startRow; i--, count++) {
            if (count == k - 1) {
                return squareMatrix.get(i).get(startColumn);
            }
        }

        return -1;
    }
}
