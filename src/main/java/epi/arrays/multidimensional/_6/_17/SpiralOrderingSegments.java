package epi.arrays.multidimensional._6._17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Question:
 * Write a program which takes an nxn 2D array and returns the spiral ordering of the array.
 * ---
 * Solution:
 * Iterate over each layer from a matrix, and perform rotation, starting from outer layers to inner ones.
 * Implementation should be iterative. We will start with a brut-force check of the first outer layer.
 * Second step is to recognize that the check in child layers is similar,
 * so we start refactoring a generic matrix spiral ordering method -> matrixInSpiralOrderHelper.
 * ---
 * Time Complexity: O(n^2)
 * Space Complexity: O(1)
 */
public class SpiralOrderingSegments {

    public static void main(String[] args) {
        assertEquals(Arrays.asList(1, 2, 3, 6, 9, 8, 7, 4, 5), matrixInSpiralOrder(Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5, 6),
                Arrays.asList(7, 8, 9)
        )));

        assertEquals(Arrays.asList(1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10), matrixInSpiralOrder(Arrays.asList(
                Arrays.asList(1, 2, 3, 4),
                Arrays.asList(5, 6, 7, 8),
                Arrays.asList(9, 10, 11, 12),
                Arrays.asList(13, 14, 15, 16)
        )));
    }

    private static List<Integer> matrixInSpiralOrder(List<List<Integer>> squareMatrix) {
        int size = squareMatrix.size();

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            // Iterate over each layer and perform spiral ordering
            matrixInSpiralOrderHelper(squareMatrix, i, size - 1 - i, i, size - 1 - i, result);
        }

        return result;
    }

    private static void matrixInSpiralOrderHelper(List<List<Integer>> squareMatrix, int startRow, int endRow,
                                                  int startColumn, int endColumn, List<Integer> result) {
        for (int i = startColumn; i <= endColumn; i++) {
            result.add(squareMatrix.get(startRow).get(i));
        }

        for (int i = startRow + 1; i <= endRow; i++) {
            result.add(squareMatrix.get(i).get(endColumn));
        }

        for (int i = endColumn - 1; i >= startColumn; i--) {
            result.add(squareMatrix.get(endRow).get(i));
        }

        for (int i = endRow - 1; i > startRow; i--) {
            result.add(squareMatrix.get(i).get(startColumn));
        }
    }
}
