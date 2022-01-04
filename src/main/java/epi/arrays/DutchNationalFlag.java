package epi.arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

/*
Given an array nums with n objects colored red, white, or blue, sort them in-place so that
objects of the same color are adjacent, with the colors in the order red, white, and blue.
We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
Time Complexity: O(n)
Space Complexity: O(1)
 */
public class DutchNationalFlag {

    public static void main(String[] args) {
        List<Integer> A = Arrays.asList(2, 0, 2, 1, 1, 0);
        sortColors(A);
        assertEquals(Arrays.asList(0, 0, 1, 1, 2, 2), A);
    }

    private static void sortColors(List<Integer> A) {
        int red = 0, white = 0, blue = A.size() - 1;

        while (white <= blue) {
            if (A.get(white) == 2) {
                Collections.swap(A, white, blue--);
            } else if (A.get(white) == 1) {
                white++;
            } else {
                Collections.swap(A, white++, red++);
            }
        }
    }
}
