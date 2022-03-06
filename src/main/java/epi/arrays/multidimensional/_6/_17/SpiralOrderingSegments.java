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
 * In case the matrix has an odd size, we need to add manually the last inner layer, which is in fact a single cell.
 * ---
 * Time Complexity: O(n^2)
 * Space Complexity: O(1)
 */
public class SpiralOrderingSegments {

    public static void main(String[] args) {
        assertEquals(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9), matrixInSpiralOrder(Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5, 6),
                Arrays.asList(7, 8, 9)
        )));
    }

    private static List<Integer> matrixInSpiralOrder(List<List<Integer>> squareMatrix) {
        int size = squareMatrix.size();

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            // Iterate over each layer and perform spiral ordering
            matrixInSpiralOrderHelper(squareMatrix, i, size - 1 - i, i, size - 1 - i, result);
        }

        // If matrix has an odd size, we need to manually add the last inner layer,
        // which is represented by the center cell
        if (size % 2 != 0) {
            int middle = size / 2;
            result.add(squareMatrix.get(middle).get(middle));
        }

        return result;
    }

    private static void matrixInSpiralOrderHelper(List<List<Integer>> squareMatrix, int startRow, int endRow,
                                                  int startColumn, int endColumn, List<Integer> result) {
        for (int i = startColumn; i < endColumn; i++) {
            result.add(squareMatrix.get(startRow).get(i));
        }

        for (int i = startRow; i < endRow; i++) {
            result.add(squareMatrix.get(i).get(endColumn));
        }

        for (int i = endColumn; i > startColumn; i--) {
            result.add(squareMatrix.get(endRow).get(i));
        }

        for (int i = endRow; i > startRow; i--) {
            result.add(squareMatrix.get(i).get(startColumn));
        }
    }
}
