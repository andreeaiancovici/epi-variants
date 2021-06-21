package other.slidingwindow;

import java.util.Arrays;

/*Given an array of positive numbers and a positive number ‘k’, find the maximum sum of
any contiguous subarray of size ‘k’.*/
//Time: O(n)
//Space: O(1)
public class MaximumSumSubArrayOfSizeK {
    public static void main(String[] args) {
        int k = 3, sum = 0, maxSum = 0;
        int[] nums = new int[]{2, 1, 5, 1, 3, 2};
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            sum += nums[j];
            while (j - i == k - 1) {
                maxSum = Math.max(maxSum, sum);
                sum -= nums[i++];
            }
        }
        System.out.printf("Maximum sum for a sub array of size K = %d from %s is %d.", k, Arrays.toString(Arrays.stream(nums).toArray()), maxSum);
    }
}


