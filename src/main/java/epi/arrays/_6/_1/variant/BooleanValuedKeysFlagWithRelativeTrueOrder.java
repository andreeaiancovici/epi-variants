package epi.arrays._6._1.variant;

import static org.junit.Assert.assertArrayEquals;

/**
 * Question:
 * Given an array A of n objects with Boolean-valued keys,
 * reorder the array so that objects that have the key false appear first.
 * The relative ordering of objects with key true should not change.
 * Use O(1) additional space and O(n) time.
 * ---
 * Solution:
 * In order to keep relative order of true-valued key elements,
 * we cannot apply the same pattern of dividing an array into 3 sections.
 * Because we have only 2 values to take in consideration (true and false),
 * we simply start from the end and do the following:
 * - if true, decrease index;
 * - if false, find the next true element until we reach 0 and replace it with our current index
 * - move current index to the replaced element, since we already covered the elements between which should be true
 * ---
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class BooleanValuedKeysFlagWithRelativeTrueOrder {

    public static void main(String[] args) {
        BooleanObject[] sortedArray = sort(new BooleanObject[]{
                new BooleanObject(false, 1),
                new BooleanObject(true, 1),
                new BooleanObject(false, 2),
                new BooleanObject(false, 3),
                new BooleanObject(true, 2),
                new BooleanObject(false, 4),
                new BooleanObject(true, 3),
                new BooleanObject(true, 4),
                new BooleanObject(true, 5),
                new BooleanObject(true, 6)});
        BooleanObject[] expectedArray = new BooleanObject[]{
                new BooleanObject(false, 1),
                new BooleanObject(false, 4),
                new BooleanObject(false, 2),
                new BooleanObject(false, 3),
                new BooleanObject(true, 1),
                new BooleanObject(true, 2),
                new BooleanObject(true, 3),
                new BooleanObject(true, 4),
                new BooleanObject(true, 5),
                new BooleanObject(true, 6)};

        assertArrayEquals(expectedArray, sortedArray);
    }

    private static BooleanObject[] sort(BooleanObject[] A) {
        int end = A.length - 1;

        while (0 <= end) {
            // if element is true, decrease index
            if (A[end].key) {
                end--;
            } else {
                // we found a false element
                // we need to find the next lower true element in order to do a replacement
                int index = end - 1;

                // progress towards the start of the array, until we find a true element
                while (0 <= index && !A[index].key) {
                    index--;
                }

                // if we found an element, proceed with replacement
                if (0 <= index) {
                    swap(A, index, end);
                }

                // because we already processed all elements,
                // our current index can now became the swapped index
                end = index;
            }
        }

        return A;
    }

    private static void swap(BooleanObject[] A, int i, int j) {
        BooleanObject temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    private static class BooleanObject {
        boolean key;
        int value;

        BooleanObject(boolean key, int value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            BooleanObject that = (BooleanObject) o;
            return key == that.key && value == that.value;
        }
    }
}
