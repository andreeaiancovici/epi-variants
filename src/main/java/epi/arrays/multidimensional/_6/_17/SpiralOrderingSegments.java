package epi.arrays.multidimensional._6._17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/*
Write a program which takes an nxn 2D array and returns the spiral ordering of the array.
Time Complexity: O(n^2)
Space Complexity: O(1)
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
            matrixInSpiralOrderHelper(squareMatrix, i, size - 1 - i, i, size - 1 - i, result);
        }

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
