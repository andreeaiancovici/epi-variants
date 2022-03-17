package epi.arrays.multidimensional._6._18;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Question:
 * Write a function that takes as input an n X n 2D array,
 * and rotates the array by 90 degrees clockwise.
 * ---
 * Solution:
 * View matrix as nested layers. The number of layers should be size of matrix / 2.
 * For each layer, perform rotation of elements.
 * E.g.
 *     ┌           ┐
 *     │ 1   2   3 │
 *     │           │
 * A = │ 8   9   4 │
 *     │           │
 *     │ 7   6   5 │
 *     └           ┘
 * Matrix A has the first layer formed by elements: 1, 2, 3, 4, 5, 6, 7, 8
 * The first performed rotation is: 1 -> 3 -> 5 -> 7 -> 1.
 * In a similar fashion we rotate the next elements.
 * ---
 * Time Complexity: O(n^2)
 * Space Complexity: O(1)
 */
public class MatrixRotation {

    public static void main(String[] args) {
        assertEquals(Arrays.asList(
                Arrays.asList(7, 4, 1),
                Arrays.asList(8, 5, 2),
                Arrays.asList(9, 6, 3)
        ), rotateMatrix(Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5, 6),
                Arrays.asList(7, 8, 9)
        )));

        assertEquals(Arrays.asList(
                Arrays.asList(21, 16, 11, 6, 1),
                Arrays.asList(22, 17, 12, 7, 2),
                Arrays.asList(23, 18, 13, 8, 3),
                Arrays.asList(24, 19, 14, 9, 4),
                Arrays.asList(25, 20, 15, 10, 5)
        ), rotateMatrix(Arrays.asList(
                Arrays.asList(1, 2, 3, 4, 5),
                Arrays.asList(6, 7, 8, 9, 10),
                Arrays.asList(11, 12, 13, 14, 15),
                Arrays.asList(16, 17, 18, 19, 20),
                Arrays.asList(21, 22, 23, 24, 25)
        )));
    }

    private static List<List<Integer>> rotateMatrix(List<List<Integer>> squareMatrix) {
        int size = squareMatrix.size();
        int layers = size / 2;
        for (int i = 0; i < layers; i++) {
            // For each layer, rotate each element
            rotateMatrix(squareMatrix, i, size - 1 - i);
        }
        return squareMatrix;
    }

    private static void rotateMatrix(List<List<Integer>> squareMatrix, int start, int end) {
        for (int i = 0; i < end - start; i++) {
            // Compute positions on each side of the square matrix
            int temp = squareMatrix.get(end - i).get(start);
            squareMatrix.get(end - i).set(start, squareMatrix.get(end).get(end - i));
            squareMatrix.get(end).set(end - i, squareMatrix.get(start + i).get(end));
            squareMatrix.get(start + i).set(end, squareMatrix.get(start).get(start + i));
            squareMatrix.get(start).set(start + i, temp);
        }
    }
}
