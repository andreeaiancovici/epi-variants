package other.twopointers;

import java.util.Arrays;

/*Given an array of sorted numbers, remove all duplicates from it. You should not use any extra space;
after removing the duplicates in-place return the new length of the array.*/
//Time: O(n)
//Space: O(1)
public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] originalNums = {2, 3, 3, 3, 6, 9, 9};
        int[] nums = Arrays.copyOf(originalNums, originalNums.length);
        int indexToReplace = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] != nums[i]) {
                nums[indexToReplace] = nums[i];
                indexToReplace++;
            }
        }
        System.out.printf("The length of the new array %s without duplicates is %d and the new array is %s.",
                Arrays.toString(originalNums), indexToReplace, Arrays.toString(Arrays.copyOf(nums, indexToReplace)));
    }
}
