package other.twopointers;

import java.util.Arrays;

/*Given an array of unsorted numbers and a target number,
find a triplet in the array whose sum is as close to the
target number as possible, return the sum of the triplet.
If there are more than one such triplet, return the sum of the triplet with the smallest sum.*/
//TODO: Not returning the smallest sum
//Time: O(n* log(n) + n^2) = O(n^2)
//Space: O(n) - required for sorting
public class TripletSumCloseToTarget {
    public static void main(String[] args) {
        int[] nums = {1, 0, 1, 1};
        int target = 100;
        Arrays.sort(nums);
        int minDiff = Integer.MAX_VALUE;
        int sumClosest = 0;
        boolean found = false;
        for(int k = 0; k < nums.length - 2; k++) {
            if(k == 0 || nums[k] != nums[k - 1]) {
                int tempTarget = target - nums[k];
                int i = k + 1, j = nums.length - 1;
                while(i < j) {
                    int sumTarget = nums[i] + nums[j];
                    if(sumTarget == tempTarget) {
                        found = true;
                    } else if(sumTarget > tempTarget) {
                        if(sumTarget - tempTarget < minDiff) {
                            minDiff = sumTarget - tempTarget;
                            sumClosest = sumTarget + nums[k];
                        }
                        j--;
                    } else {
                        if(tempTarget - sumTarget < minDiff) {
                            minDiff = tempTarget - sumTarget;
                            sumClosest = sumTarget + nums[k];
                        }
                        i++;
                    }
                }
                if(found) {
                    break;
                }
            }
        }
        System.out.printf("Sum of the triplet with the smallest value and closest to the target is %d.", sumClosest);
    }
}
