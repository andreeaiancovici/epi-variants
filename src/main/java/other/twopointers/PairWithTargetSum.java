package other.twopointers;

/*Given an array of sorted numbers and a target sum,
find a pair in the array whose sum is equal to the given target.
Write a function to return the indices of the two numbers
(i.e. the pair) such that they add up to the given target.*/
//Time: O(n)
//Space: O(1)
public class PairWithTargetSum {
    public static void main(String[] args) {
         int[] nums = {2, 5, 9, 11};
         int target = 11;
         int i = 0, j = nums.length - 1;
         while(i < j) {
             if(nums[i] + nums[j] > target) {
                 j--;
             } else if(nums[i] + nums[j] < target) {
                 i++;
             } else break;
         }
         System.out.printf("The indices of the two numbers are %d and %d.", i, j);
    }
}
