package epi.arrays.multidimensional._6._18.variant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Question:
 * Implement an algorithm to reflect A, assumed to be an n X n 2D array,
 * about the horizontal axis of symmetry. Repeat the same for reflections about
 * the vertical axis, the diagonal from top-left to bottom-right, and the diagonal
 * from top-right to bottom-left.
 * ---
 * Solution:
 * Iterate matrix by rows / columns until we reach the middle axis, performing necessary swaps.
 * ---
 * Time Complexity: O(n^2)
 * Space Complexity: O(1)
 */
public class MatrixReflection {

    public static void main(String[] args) {
        List<List<Integer>> matrix3x3 = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5, 6),
                Arrays.asList(7, 8, 9));

        assertEquals(Arrays.asList(
                Arrays.asList(7, 8, 9),
                Arrays.asList(4, 5, 6),
                Arrays.asList(1, 2, 3)
        ), horizontalReflection(matrix3x3));

        assertEquals(Arrays.asList(
                Arrays.asList(3, 2, 1),
                Arrays.asList(6, 5, 4),
                Arrays.asList(9, 8, 7)
        ), verticalReflection(matrix3x3));

        assertEquals(Arrays.asList(
                Arrays.asList(9, 6, 3),
                Arrays.asList(8, 5, 2),
                Arrays.asList(7, 4, 1)
        ), diagonalTopLeftBottomRightReflection(matrix3x3));

        assertEquals(Arrays.asList(
                Arrays.asList(1, 4, 7),
                Arrays.asList(2, 5, 8),
                Arrays.asList(3, 6, 9)
        ), diagonalTopRightBottomLeftReflection(matrix3x3));

        List<List<Integer>> matrix4x4 = Arrays.asList(
                Arrays.asList(1, 2, 3, 4),
                Arrays.asList(5, 6, 7, 8),
                Arrays.asList(9, 10, 11, 12),
                Arrays.asList(13, 14, 15, 16));

        assertEquals(Arrays.asList(
                Arrays.asList(13, 14, 15, 16),
                Arrays.asList(9, 10, 11, 12),
                Arrays.asList(5, 6, 7, 8),
                Arrays.asList(1, 2, 3, 4)
        ), horizontalReflection(matrix4x4));

        assertEquals(Arrays.asList(
                Arrays.asList(4, 3, 2, 1),
                Arrays.asList(8, 7, 6, 5),
                Arrays.asList(12, 11, 10, 9),
                Arrays.asList(16, 15, 14, 13)
        ), verticalReflection(matrix4x4));

        assertEquals(Arrays.asList(
                Arrays.asList(16, 12, 8, 4),
                Arrays.asList(15, 11, 7, 3),
                Arrays.asList(14, 10, 6, 2),
                Arrays.asList(13, 9, 5, 1)
        ), diagonalTopLeftBottomRightReflection(matrix4x4));

        assertEquals(Arrays.asList(
                Arrays.asList(1, 5, 9, 13),
                Arrays.asList(2, 6, 10, 14),
                Arrays.asList(3, 7, 11, 15),
                Arrays.asList(4, 8, 12, 16)
        ), diagonalTopRightBottomLeftReflection(matrix4x4));

        List<List<Integer>> matrix5x5 = Arrays.asList(
                Arrays.asList(1, 2, 3, 4, 5),
                Arrays.asList(6, 7, 8, 9, 10),
                Arrays.asList(11, 12, 13, 14, 15),
                Arrays.asList(16, 17, 18, 19, 20),
                Arrays.asList(21, 22, 23, 24, 25));

        assertEquals(Arrays.asList(
                Arrays.asList(21, 22, 23, 24, 25),
                Arrays.asList(16, 17, 18, 19, 20),
                Arrays.asList(11, 12, 13, 14, 15),
                Arrays.asList(6, 7, 8, 9, 10),
                Arrays.asList(1, 2, 3, 4, 5)
        ), horizontalReflection(matrix5x5));

        assertEquals(Arrays.asList(
                Arrays.asList(5, 4, 3, 2, 1),
                Arrays.asList(10, 9, 8, 7, 6),
                Arrays.asList(15, 14, 13, 12, 11),
                Arrays.asList(20, 19, 18, 17, 16),
                Arrays.asList(25, 24, 23, 22, 21)
        ), verticalReflection(matrix5x5));

        assertEquals(Arrays.asList(
                Arrays.asList(25, 20, 15, 10, 5),
                Arrays.asList(24, 19, 14, 9, 4),
                Arrays.asList(23, 18, 13, 8, 3),
                Arrays.asList(22, 17, 12, 7, 2),
                Arrays.asList(21, 16, 11, 6, 1)
        ), diagonalTopLeftBottomRightReflection(matrix5x5));

        assertEquals(Arrays.asList(
                Arrays.asList(1, 6, 11, 16, 21),
                Arrays.asList(2, 7, 12, 17, 22),
                Arrays.asList(3, 8, 13, 18, 23),
                Arrays.asList(4, 9, 14, 19, 24),
                Arrays.asList(5, 10, 15, 20, 25)
        ), diagonalTopRightBottomLeftReflection(matrix5x5));
    }

    private static List<List<Integer>> horizontalReflection(List<List<Integer>> inputSquareMatrix) {
        List<List<Integer>> squareMatrix = copyList(inputSquareMatrix);
        int size = squareMatrix.size();

        for (int i = 0; i < size / 2; i++) {
            for (int j = 0; j < size; j++) {
                int temp = squareMatrix.get(i).get(j);
                squareMatrix.get(i).set(j, squareMatrix.get(size - 1 - i).get(j));
                squareMatrix.get(size - 1 - i).set(j, temp);
            }
        }

        return squareMatrix;
    }

    private static List<List<Integer>> verticalReflection(List<List<Integer>> inputSquareMatrix) {
        List<List<Integer>> squareMatrix = copyList(inputSquareMatrix);
        int size = squareMatrix.size();

        for (int j = 0; j < size / 2; j++) {
            for (int i = 0; i < size; i++) {
                int temp = squareMatrix.get(i).get(j);
                squareMatrix.get(i).set(j, squareMatrix.get(i).get(size - 1 - j));
                squareMatrix.get(i).set(size - 1 - j, temp);
            }
        }

        return squareMatrix;
    }

    private static List<List<Integer>> diagonalTopLeftBottomRightReflection(List<List<Integer>> inputSquareMatrix) {
        List<List<Integer>> squareMatrix = copyList(inputSquareMatrix);
        int size = squareMatrix.size();

        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1 - i; j++) {
                int temp = squareMatrix.get(i).get(j);
                squareMatrix.get(i).set(j, squareMatrix.get(size - 1 - j).get(size - 1 - i));
                squareMatrix.get(size - 1 - j).set(size - 1 - i, temp);
            }
        }

        return squareMatrix;
    }

    private static List<List<Integer>> diagonalTopRightBottomLeftReflection(List<List<Integer>> inputSquareMatrix) {
        List<List<Integer>> squareMatrix = copyList(inputSquareMatrix);
        int size = squareMatrix.size();

        for (int i = 0; i < size - 1; i++) {
            for (int j = size - 1; j > i; j--) {
                int temp = squareMatrix.get(i).get(j);
                squareMatrix.get(i).set(j, squareMatrix.get(j).get(i));
                squareMatrix.get(j).set(i, temp);
            }
        }

        return squareMatrix;
    }

    private static List<List<Integer>> copyList(List<List<Integer>> input) {
        List<List<Integer>> result = new ArrayList<>();
        for (List<Integer> item : input) {
            result.add(new ArrayList<>(item));
        }
        return result;
    }
}
