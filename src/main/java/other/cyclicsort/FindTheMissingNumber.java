package other.cyclicsort;

/*We are given an array containing ‘n’ distinct numbers taken from the range 0 to ‘n’.
Since the array has only ‘n’ numbers out of the total ‘n+1’ numbers, find the missing number.*/
//Time: O(n)
//Space: O(1)
public class FindTheMissingNumber {
    public static void main(String[] args) {
        int[] nums = {4, 0, 3, 1};
        for (int i = 0; i < nums.length;) {
            if (nums[i] < nums.length && nums[i] != nums[nums[i]]) {
                swap(nums, nums[i], i);
            } else i++;
        }

        int i;
        for (i = 0; i < nums.length; i++) {
            if(nums[i] != i) {
                break;
            }
        }

        System.out.printf("The missing number is %d.", i);
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
