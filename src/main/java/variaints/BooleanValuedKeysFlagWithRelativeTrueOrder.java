package variaints;

//Page 65 Variant
//Time complexity O(n)
//Space complexity O(1)
public class BooleanValuedKeysFlagWithRelativeTrueOrder {
    private static class BooleanObject {
        boolean key;
        int value;

        BooleanObject(boolean key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    public static void main(String[] args) {
        BooleanObject[] nums = new BooleanObject[]{
                new BooleanObject(false, 1),
                new BooleanObject(true, 1),
                new BooleanObject(false, 2),
                new BooleanObject(false, 3),
                new BooleanObject(true, 2),
                new BooleanObject(false, 4),
                new BooleanObject(true, 3),
                new BooleanObject(true, 4),
                new BooleanObject(true, 5),
                new BooleanObject(true, 6)};
        int i = nums.length - 1;
        int j = -1;
        while (0 <= i) {
            if(nums[i].key) {
                if(j != -1) {
                    BooleanObject temp = nums[j];
                    nums[j] = nums[i];
                    nums[j] = temp;
                    j = -1;
                } else {
                    i--;
                }
            } else {
                if(j == -1) {
                    j = i;
                }
                i--;
            }
        }
    }
}
