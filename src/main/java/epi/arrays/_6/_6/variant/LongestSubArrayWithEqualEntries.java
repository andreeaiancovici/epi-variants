package epi.arrays._6._6.variant;

/**
 * Question:
 * Write a program that takes an array of integers and finds the length of a longest sub-array
 * all of whose entries are equal.
 * ---
 * Memo:
 * ---
 * Solution:
 * ---
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class LongestSubArrayWithEqualEntries {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2, 2, 2, 3, 3};
        int count = 1, countMax = 0;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] == nums[i - 1]) {
                count++;
            } else {
                countMax = Math.max(countMax, count);
                count = 1;
            }
        }
        countMax = Math.max(countMax, count);
        System.out.println(countMax);
    }
}
