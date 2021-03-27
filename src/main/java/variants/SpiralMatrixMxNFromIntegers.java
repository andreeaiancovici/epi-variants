package variants;

import java.util.Arrays;

//Page 90 Variant
//Time complexity O(n^2)
//Space complexity O(1)
public class SpiralMatrixMxNFromIntegers {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 0, 1, 3, 2, 0, 3, 6, 7, 4, 1};
        int m = 3, n = 4;
        int[][] matrix = new int[m][n];
        int k = 0, iStart = 0, iEnd = m - 1, jStart = 0, jEnd = n - 1;
        while(k < nums.length) {
            for(int j = jStart; j <= jEnd && k < nums.length; j++, k++) {
                matrix[iStart][j] = nums[k];
            }
            for(int i = iStart + 1; i <= iEnd && k < nums.length; i++, k++) {
                matrix[i][jEnd] = nums[k];
            }
            for(int j = jEnd - 1; j >= jStart && k < nums.length; j--, k++) {
                matrix[iEnd][j] = nums[k];
            }
            for(int i = iEnd - 1; i > iStart && k < nums.length; i--, k++) {
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
