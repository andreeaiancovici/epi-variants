package other.cyclicsort;

import java.util.ArrayList;
import java.util.List;

/*We are given an unsorted array containing ‘n’ numbers taken from the range 1 to ‘n’.
The array has some duplicates, find all the duplicate numbers without using any extra space.*/
//Time: O(n)
//Space: O(1)
public class FindAllDuplicateNumbers {
    public static void main(String[] args) {
        int[] nums = {3, 4, 4, 5, 5};
        for(int i = 0; i < nums.length;) {
            if(nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            } else i++;
        }

        List<Integer> duplicateNumbers = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] - 1 != i) {
                duplicateNumbers.add(nums[i]);
            }
        }

        System.out.printf("The duplicate numbers are %s.", duplicateNumbers);
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
