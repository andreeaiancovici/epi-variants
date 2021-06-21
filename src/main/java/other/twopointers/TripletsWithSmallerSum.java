package other.twopointers;

import java.util.Arrays;

/*Given an array arr of unsorted numbers and a target sum, count all triplets
in it such that arr[i] + arr[j] + arr[k] < target where i, j, and k are three
different indices. Write a function to return the count of such triplets.*/
//Time: O(n* log(n) + n^2) = O(n^2)
//Space: O(n) - required for sorting
public class TripletsWithSmallerSum {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 2, 3};
        int target = 2;
        int count = 0, targetSum;
        Arrays.sort(nums);
        for (int k = 0; k < nums.length - 2; k++) {
            targetSum = target - nums[k];
            int i = k + 1, j = nums.length - 1;
            while (i < j) {
                int sum = nums[i] + nums[j];
                if (sum < targetSum) {
                    count += (j - i);
                    i++;
                } else {
                    j--;
                }
            }
        }
        System.out.printf("The number of triplets with sum < %d is %d.", target, count);
    }
}