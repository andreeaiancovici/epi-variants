package other.slidingwindow;

import java.util.Arrays;

/*Given an array of positive numbers and a positive number ‘S’,
find the length of the smallest contiguous subarray whose sum is
greater than or equal to ‘S’. Return 0, if no such subarray exists.*/
//Time: O(n)
//Space: O(1)
public class SmallestSubArrayWithGivenSum {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 1, 5, 2, 3, 2};
        int s = 7, sum = 0, minLength = nums.length;
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            sum += nums[j];
            while (sum >= s && i < nums.length) {
                minLength = Math.min(minLength, j - i + 1);
                sum -= nums[i++];
            }
        }
        System.out.printf("Smallest sub array length whose sum is >= %d from %s is %d.", s, Arrays.toString(Arrays.stream(nums).toArray()), minLength);
    }
}
