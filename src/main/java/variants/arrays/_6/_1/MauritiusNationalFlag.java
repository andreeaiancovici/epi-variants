package variants.arrays._6._1;

import java.util.Arrays;

//Page 65 Variant
//Time complexity O(n)
//Space complexity O(1)
public class MauritiusNationalFlag {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 0, 1, 3, 2, 0, 3, 0, 2};
        System.out.println("Array: " + Arrays.toString(nums));

        int red = 0, yellow, white = 0, blue = nums.length - 1;
        while (white <= blue) {
            if (nums[white] == 0) {
                swap(nums, red, white);
                red++;
                white++;
            } else if (nums[white] == 3) {
                swap(nums, white, blue);
                blue--;
            } else {
                white++;
            }
        }
        white = red;
        yellow = red;
        while (white <= blue) {
            if (nums[white] == 1) {
                swap(nums, yellow, white);
                yellow++;
            }
            white++;
        }

        System.out.println("Array after ordering: " + Arrays.toString(nums));
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
