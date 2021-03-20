package variants;

import java.util.Arrays;

//Page 90 Variant
//Time complexity O(n^2)
//Space complexity O(1)
public class SpiralMatrixFromIntegers {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 0, 1, 3, 2, 0, 3, 0};
        int n = 3;
        int iStart = 0, jStart = 0, iEnd = n - 1, jEnd = n - 1;
        int[][] matrix = new int[n][n];
        int k = 0;
        while(k < n * n) {
            for(int j = jStart; j <= jEnd; j++, k++) {
                matrix[iStart][j] = nums[k];
            }
            for(int i = iStart + 1; i <= iEnd; i++, k++) {
                matrix[i][jEnd] = nums[k];
            }
            for(int j = jEnd - 1; j >= jStart; j--, k++) {
                matrix[iEnd][j] = nums[k];
            }
            for(int i = iEnd - 1; i > iStart; i--, k++) {
                matrix[i][jStart] = nums[k];
            }
            iStart++;
            jStart++;
            iEnd--;
            jEnd--;
        }
        System.out.println(Arrays.deepToString(matrix));
    }
}
