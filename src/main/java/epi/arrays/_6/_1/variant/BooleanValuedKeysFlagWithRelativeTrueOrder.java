package epi.arrays._6._1.variant;

import java.util.Arrays;

/**
 * Question:
 * Given an array A of n objects with Boolean-valued keys,
 * reorder the array so that objects that have the key false appear first.
 * The relative ordering of objects with key true should not change.
 * Use O(1) additional space and O(n) time.
 * ---
 * Memo:
 * ---
 * Solution:
 * ---
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class BooleanValuedKeysFlagWithRelativeTrueOrder {

    private static class BooleanObject {
        boolean key;
        int value;

        BooleanObject(boolean key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        BooleanObject[] values = new BooleanObject[]{
                new BooleanObject(false, 1),
                new BooleanObject(true, 1),
                new BooleanObject(false, 2),
                new BooleanObject(false, 3),
                new BooleanObject(true, 2),
                new BooleanObject(false, 4),
                new BooleanObject(true, 3),
                new BooleanObject(true, 4),
                new BooleanObject(true, 5),
                new BooleanObject(true, 6)};
        System.out.println("Array: " + Arrays.toString(values));
        int i = values.length - 1;
        int j = -1;
        while (0 <= i) {
            if (values[i].key) {
                if (j != -1) {
                    BooleanObject temp = values[j];
                    values[j] = values[i];
                    values[j] = temp;
                    j = -1;
                } else {
                    i--;
                }
            } else {
                if (j == -1) {
                    j = i;
                }
                i--;
            }
        }
        System.out.println("Array after ordering: " + Arrays.toString(values));
    }
}
