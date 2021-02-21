package variants;

//Page 76 Variant
//Time complexity O(n)
//Space complexity O(1)
public class InversePermutation {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 4, 5, 1};
        //int[] nums= new int[]{1, 4, 3, 2};
        for(int i = 0; i < nums.length; i++) {
            int next = i;
            int pos = nums[next] - 1;
            while(pos >= 0) {
                int temp = nums[pos] - 1;
                nums[pos] = next + 1 - nums.length;
                next = pos;
                pos = temp;
            }
        }
        for(int i = 0; i < nums.length; i++) {
            nums[i]+=nums.length;
        }
    }
}