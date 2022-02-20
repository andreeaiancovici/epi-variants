package epi.arrays._6._6.variant;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Question:
 * Write a program that takes an array of integers and finds the length of a longest sub-array
 * all of whose entries are equal.
 * ---
 * Memo:
 * Sliding Window Algorithm
 * ---
 * Solution:
 * Use 2 indexes i and j to define a window, which will increase as long as we have equal entries.
 * When we find a different entry, we reset the counter and the starting index. (we slide the window to right)
 * Repeat the steps above for each sub-array with equal entries, until we find the longest window.
 * ---
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class LongestSubArrayWithEqualEntries {

    public static void main(String[] args) {
        assertEquals(4, longestSubArrayWithEqualEntriesLength(Arrays.asList(1, 1, 2, 2, 2, 3, 3, 5, 5, 5, 5, 6, 6)));
    }

    private static int longestSubArrayWithEqualEntriesLength(List<Integer> nums) {
        int length = 1;
        int longestSubArrayLength = 1;

        // start with an array of size 1: i = 0 and j = 1
        int i = 0;
        while(i < nums.size()) {
            int j = i + 1;
            // increase end index as long as we have equal entries
            while(j < nums.size() && nums.get(j - 1).equals(nums.get(j))) {
                length++;
                j++;
            }

            // compute longest sub-array so far
            longestSubArrayLength = Math.max(longestSubArrayLength, length);
            // reset length counter
            length = 1;
            // set new index for window start
            i = j;
        }

        return longestSubArrayLength;
    }
}
