package epi.arrays.multidimensional._6._18;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/*
Write a function that takes as input an n X n 2D array, and rotates the array by
90 degrees clockwise.
Time Complexity: O(n^2)
Space Complexity: O(1)
 */
public class MatrixRotation {

    public static void main(String[] args) {
        List<List<Integer>> squareMatrix = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5, 6),
                Arrays.asList(7, 8, 9)
        );
        rotateMatrix(squareMatrix);
        assertEquals(Arrays.asList(
                Arrays.asList(7, 4, 1),
                Arrays.asList(8, 5, 2),
                Arrays.asList(9, 6, 3)
        ), squareMatrix);
    }

    private static void rotateMatrix(List<List<Integer>> squareMatrix) {
        int size = squareMatrix.size();
        for (int i = 0; i < size / 2; i++) {
            rotateMatrix(squareMatrix, i, size - 1 - i);
        }
    }

    private static void rotateMatrix(List<List<Integer>> squareMatrix, int start, int end) {
        for (int i = 0; i < end - start; i++) {
            int temp = squareMatrix.get(end - i).get(start);
            squareMatrix.get(end - i).set(start, squareMatrix.get(end).get(end - i));
            squareMatrix.get(end).set(end - i, squareMatrix.get(start + i).get(end));
            squareMatrix.get(start + i).set(end, squareMatrix.get(start).get(start + i));
            squareMatrix.get(start).set(start + i, temp);
        }
    }
}
