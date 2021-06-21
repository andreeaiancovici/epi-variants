package other.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Given an array of unsorted numbers, find all unique triplets in it that add up to zero.
//Time: O(n* log(n) + n^2) = O(n^2)
//Space: O(n) - required for sorting
public class TripletSumToZero {
    public static void main(String[] args) {
        List<int[]> triplets = new ArrayList<>();
        int[] nums = {-3, 0, 1, 2, -1, 1, -2};
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                searchPair(i + 1, -nums[i], nums, triplets);
            }
        }
        System.out.println("All unique triplets are:");
        triplets.forEach(triplet -> System.out.println(Arrays.toString(triplet)));
    }

    private static void searchPair(int start, int target, int[] nums, List<int[]> triplets) {
        int i = start, j = nums.length - 1, sum;
        while(i < j) {
            sum = nums[i] + nums[j];
            if(sum > target) {
                j--;
            } else if(sum < target) {
                i++;
            } else {
                triplets.add(new int[]{-target, nums[i++], nums[j--]});
                while(i < j && nums[i] == nums[i - 1]) {
                    i++;
                }
                while(i < j && nums[j] == nums[j + 1]) {
                    j--;
                }
            }
        }
    }
}
