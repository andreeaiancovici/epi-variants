package other.binarysearch;

public class OrderAgnosticBinarySearch {
    public static void main(String[] args) {
        int[] nums = {4, 6, 10};
        int key = 10;

        int start = 0;
        int end = nums.length - 1;

        boolean isAscending = nums[end] > nums[start];
        int m;
        while(start < end) {
            m = start + (start + end) / 2;

            if(nums[m] == key) {
                break;
            }

            if(isAscending) {
                if(key < nums[m]) {
                    end = m - 1;
                } else {
                    start = m;
                }
            } else {
                if(key < nums[m]) {
                    start = m + 1;
                } else {
                    end = m;
                }
            }
        }
    }
}
