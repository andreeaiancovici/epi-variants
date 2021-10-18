package other.mergeintervals;

import java.util.Arrays;
import java.util.Comparator;

/*Given a list of intervals, merge all the overlapping intervals to
produce a list that has only mutually exclusive intervals.*/
//Time: O(n*log(n))
//Space: O(n)
public class MergeIntervals {
    public static void main(String[] args) {
        int[][] intervals = {{1, 4}, {2, 6}, {3, 5}};
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        int[][] mergedIntervals = new int[intervals.length][2];
        int k = 0;
        mergedIntervals[k] = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if(mergedIntervals[k][1] < intervals[i][0]) {
                mergedIntervals[++k] = intervals[i];
            } else {
                mergedIntervals[k][1] =  Math.max(mergedIntervals[k][1], intervals[i][1]);
            }
        }
        System.out.println("Merged intervals are:");
        for (int i = 0; i <= k; i++) {
            System.out.println(Arrays.toString(mergedIntervals[i]));
        }
    }
}
