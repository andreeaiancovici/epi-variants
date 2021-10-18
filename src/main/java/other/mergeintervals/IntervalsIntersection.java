package other.mergeintervals;

import java.util.Arrays;

/*Given two lists of intervals, find the intersection of these two lists.
Each list consists of disjoint intervals sorted on their start time.*/
//Time: O(n*log(n))
//Space: O(n)
public class IntervalsIntersection {
    public static void main(String[] args) {
        int[][] arr1 = {{1, 3}, {5, 7}, {9, 12}};
        int[][] arr2 = {{5, 10}};
        int[][] intersections = new int[Math.max(arr1.length, arr2.length)][2];
        int i = 0, j = 0, k = 0;
        while (i < arr1.length && j < arr2.length) {
            if((arr1[i][0] >= arr2[j][0] && arr1[i][0] <= arr2[j][1])
                    || (arr2[j][0] >= arr1[i][0] && arr2[j][0] <= arr1[i][1])) {
                intersections[k][0] = Math.max(arr1[i][0], arr2[j][0]);
                intersections[k][1] = Math.min(arr1[i][1], arr2[j][1]);
                k++;
            }
            if(arr1[i][1] > arr2[j][1]) {
                j++;
            } else {
                i++;
            }
        }
        System.out.println("Intersection intervals are:");
        for(int p = 0; p < k; p++) {
            System.out.println(Arrays.toString(intersections[p]));
        }
    }
}
