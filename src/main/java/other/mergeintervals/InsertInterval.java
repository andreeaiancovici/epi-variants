package other.mergeintervals;

import java.util.Arrays;

/*Given a list of non-overlapping intervals sorted by their start time,
insert a given interval at the correct position and merge all necessary
intervals to produce a list that has only mutually exclusive intervals.*/
//Time: O(n)
//Space: O(n)
public class InsertInterval {
    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {5, 7}, {8, 12}};
        int [] newInterval = new int[]{4, 6};
        int[][] mergedIntervals = new int[intervals.length + 1][2];
        int k = 0;
        mergedIntervals[k] = newInterval;
        for (int[] interval : intervals) {
            if (interval[0] < mergedIntervals[k][0]) {
                if (interval[1] < mergedIntervals[k][0]) {
                    mergedIntervals[k + 1] = mergedIntervals[k];
                    mergedIntervals[k] = interval;
                    k++;
                } else {
                    if (interval[1] < mergedIntervals[k][1]) {
                        mergedIntervals[k][0] = interval[0];
                    } else {
                        mergedIntervals[k][0] = interval[0];
                        mergedIntervals[k][1] = interval[1];
                    }
                }
            } else {
                if (mergedIntervals[k][1] < interval[0]) {
                    mergedIntervals[++k] = interval;
                } else {
                    if (mergedIntervals[k][1] < interval[1]) {
                        mergedIntervals[k][1] = interval[1];
                    }
                }
            }
        }
        System.out.println("Merged intervals are:");
        for(int i = 0; i <= k; i++) {
            System.out.println(Arrays.toString(mergedIntervals[i]));
        }
    }
}
