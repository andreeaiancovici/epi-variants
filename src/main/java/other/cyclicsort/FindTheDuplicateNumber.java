package other.cyclicsort;

/*We are given an unsorted array containing ‘n+1’ numbers taken from the range 1 to ‘n’.
The array has only one duplicate but it can be repeated multiple times. Find that duplicate
number without using any extra space. You are, however, allowed to modify the input array.*/
//Time: O(n)
//Space: O(1)
public class FindTheDuplicateNumber {
    public static void main(String[] args) {
        int[] nums = {1, 4, 4, 3, 2};
        for(int i = 0; i < nums.length;) {
            if(nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            } else i++;
        }

        int i;
        for (i = 0; i < nums.length; i++) {
            if(nums[i] - 1 != i) {
                break;
            }
        }

        System.out.printf("The duplicate number is %d.", nums[i]);
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
