package other.cyclicsort;

import java.util.Arrays;

/*We are given an array containing ‘n’ objects. Each object, when created,
was assigned a unique number from 1 to ‘n’ based on their creation sequence.
This means that the object with sequence number ‘3’ was created just before the object with sequence number ‘4’.

Write a function to sort the objects in-place on their creation sequence
number in O(n) and without any extra space. For simplicity, let’s
assume we are passed an integer array containing only the sequence numbers,
though each number is actually an object.*/
//Time: O(n)
//Space: O(1)
public class CyclicSort {
    public static void main(String[] args) {
        int[] nums = {2, 6, 4, 3, 1, 5};
        for(int i = 0; i < nums.length;) {
            if(nums[i] != nums[nums[i] - 1]) {
                swap(nums, nums[i] - 1, i);
            } else i++;
        }
        System.out.printf("Cyclic sorted array is %s.", Arrays.toString(nums));
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}