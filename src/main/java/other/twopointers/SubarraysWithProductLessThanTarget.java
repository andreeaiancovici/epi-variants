package other.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*Given an array with positive numbers and a target number,
find all of its contiguous subarrays whose product is less than the target number.*/
//Time: O(n * n) -> for creating sub arrays //TODO: Discussion
//Space: O(1)
public class SubarraysWithProductLessThanTarget {
    public static void main(String[] args) {
        int[] nums = {8, 2, 6, 5};
        int target = 50;
        List<int[]> results = new ArrayList<>();
        int product = 1;
        int i = 0;
        for(int j = 0; j < nums.length; j++) {
            product *= nums[j];
            while(product >= target && i < nums.length) {
                product /= nums[i];
                i++;
            }
            if(j != i) {
                results.add(Arrays.copyOfRange(nums, j, j + 1));
            }
            results.add(Arrays.copyOfRange(nums, i, j + 1));
        }
        System.out.printf("All contiguous sub arrays with product < %d are:\n", target);
        results.forEach(result -> System.out.println(Arrays.toString(result)));
    }
}