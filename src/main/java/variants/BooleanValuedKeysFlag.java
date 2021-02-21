package variants;

//Page 70 Variant
//Time complexity O(n)
//Space complexity O(1)
public class BooleanValuedKeysFlag {
    public static void main(String[] args) {
        boolean[] nums = new boolean[]{false, true, true, false, false, true, false, true, true, true};
        int fIndex = 0, tIndex = nums.length - 1;
        while (fIndex <= tIndex) {
            if(!nums[fIndex]) {
                fIndex++;
            } else {
                boolean temp = nums[tIndex];
                nums[tIndex] = true;
                nums[fIndex] = temp;
                tIndex--;
            }
        }
    }
}
