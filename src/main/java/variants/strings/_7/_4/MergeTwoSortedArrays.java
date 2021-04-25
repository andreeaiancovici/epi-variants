package variants.strings._7._4;

import java.util.Arrays;

//Page 100 Variant
//Time complexity O(n)
//Space complexity O(1)
public class MergeTwoSortedArrays {
    public static void main(String[] args) {
        int[] A = new int[]{1, 3, 4, 5, 0, 0, 0, 0};
        int n = 4;
        int[] B = new int[]{2, 4, 6, 8};
        int m = 4;

        System.out.println("Array A: " + Arrays.toString(A));
        System.out.println("Array B: " + Arrays.toString(B));

        int i = n - 1, j = m - 1, k = A.length - 1;
        while (i >= 0 && j >= 0) {
            if (A[i] >= B[j]) {
                A[k--] = A[i];
                i--;
            } else {
                A[k--] = B[j];
                j--;
            }
        }

        while (i >= 0) {
            A[k--] = A[i--];
        }

        while (j >= 0) {
            A[k--] = B[j--];
        }

        System.out.println("Merged Arrays in A: " + Arrays.toString(A));
    }
}
