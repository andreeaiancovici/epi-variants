package epi.arrays._6._1.variant;

import java.util.Arrays;

//Page 65 Variant
//Time complexity O(n)
//Space complexity O(1)
public class BooleanValuedKeysFlag {
    public static void main(String[] args) {
        boolean[] values = new boolean[]{false, true, true, false, false, true, false, true, true, true};
        System.out.println("Array: " + Arrays.toString(values));
        int fIndex = 0, tIndex = values.length - 1;
        while (fIndex <= tIndex) {
            if (!values[fIndex]) {
                fIndex++;
            } else {
                boolean temp = values[tIndex];
                values[tIndex] = true;
                values[fIndex] = temp;
                tIndex--;
            }
        }
        System.out.println("Array after ordering: " + Arrays.toString(values));
    }
}
