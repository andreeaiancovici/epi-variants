package other.twopointers;

import java.util.Arrays;

/*Given an array containing 0s, 1s and 2s, sort the array in-place.
You should treat numbers of the array as objects, hence, we can’t count 0s,
1s, and 2s to recreate the array.*/
//Time: O(n)
//Space: O(1)
public class DutchNationalFlagProblem {
    public static void main(String[] args) {
        int[] nums = {1, 0, 2, 1, 0};
        int zeroIndex = 0, oneIndex = 0, twoIndex = nums.length - 1;
        while (oneIndex <= twoIndex) {
            if (nums[oneIndex] == 0) {
                swap(nums, zeroIndex, oneIndex);
                zeroIndex++;
                oneIndex++;
            } else if (nums[oneIndex] == 1) {
                oneIndex++;
            } else {
                swap(nums, oneIndex, twoIndex);
                twoIndex--;
            }
        }
        System.out.printf("Array sorted in place %s.", Arrays.toString(nums));
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}