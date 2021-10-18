package other.cyclicsort;

import java.util.ArrayList;
import java.util.List;

/*We are given an unsorted array containing numbers taken from the range 1 to ‘n’.
The array can have duplicates, which means some numbers will be missing. Find all those missing numbers.*/
//Time: O(n)
//Space: O(1)
public class FindAllMissingNumbers {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 8, 2, 3, 5, 1};
        for (int i = 0; i < nums.length; ) {
            if (nums[i] != nums[nums[i] - 1]) {
                swap(nums, nums[i] - 1, i);
            } else i++;
        }

        List<Integer> missingNumbers = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] - 1 != i) {
                missingNumbers.add(i + 1);
            }
        }

        System.out.printf("The missing numbers are %s.", missingNumbers);
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
