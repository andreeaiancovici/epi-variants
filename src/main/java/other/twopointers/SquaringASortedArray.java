package other.twopointers;

import java.util.Arrays;

/*Given a sorted array, create a new array containing squares of
all the number of the input array in the sorted order.*/
//Time: O(n)
//Space: O(n)
public class SquaringASortedArray {
    public static void main(String[] args) {
        int[] nums = {-2, -1, 0, 2, 3};
        int[] squareNums = new int[nums.length];
        int indexToReplace = squareNums.length - 1;
        int i = 0, j = nums.length - 1;
        int iSquare, jSquare;
        while(i < j) {
            iSquare = nums[i] * nums[i];
            jSquare = nums[j] * nums[j];
            if(iSquare > jSquare) {
                squareNums[indexToReplace--] = iSquare;
                i++;
            } else {
                squareNums[indexToReplace--] = jSquare;
                j--;
            }
        }
        System.out.printf("The squares array is %s.", Arrays.toString(squareNums));
    }
}
