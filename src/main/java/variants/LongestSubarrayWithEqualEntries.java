package variants;

public class LongestSubarrayWithEqualEntries {
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
