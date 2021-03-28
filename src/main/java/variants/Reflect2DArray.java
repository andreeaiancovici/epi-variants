package variants;

import java.util.Arrays;

//Page 92 Variant
//Time complexity O(n^2)
//Space complexity O(1)
public class Reflect2DArray {
    public static void main(String[] args) {
        int[][] matrix1 = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int n = matrix1.length;
        for(int i = 0; i < n / 2; i++) {
            for(int j = 0; j < n; j++) {
                int temp = matrix1[i][j];
                matrix1[i][j] = matrix1[n - 1 - i][j];
                matrix1[n - 1 - i][j] = temp;
            }
        }
        System.out.println("Horizontal reflection: " + Arrays.deepToString(matrix1));

        int[][] matrix2 = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        n = matrix2.length;
        for(int j = 0; j < n / 2; j++) {
            for(int i = 0; i < n; i++) {
                int temp = matrix2[i][j];
                matrix2[i][j] = matrix2[i][n - 1 - j];
                matrix2[i][n - 1 - j] = temp;
            }
        }
        System.out.println("Vertical reflection: " + Arrays.deepToString(matrix2));

        int[][] matrix3 = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        n = matrix3.length;
        for(int i = 0; i < n - 1; i++) {
            for(int j = i + 1; j < n; j++) {
                int temp = matrix3[i][j];
                matrix3[i][j] = matrix3[j][i];
                matrix3[j][i] = temp;
            }
        }
        System.out.println("Diagonal from top-left to bottom-right reflection: " + Arrays.deepToString(matrix3));

        int[][] matrix4 = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        n = matrix4.length;
        for(int i = 0; i < n - 1; i++) {
            for(int j = 0; j < n - i - 1; j++) {
                int temp = matrix4[i][j];
                matrix4[i][j] = matrix4[n - 1 - j][n - 1 - i];
                matrix4[n - 1 - j][n - 1 - i] = temp;
            }
        }
        System.out.println("Diagonal from top-right to bottom-left reflection: " + Arrays.deepToString(matrix4));
    }
}
