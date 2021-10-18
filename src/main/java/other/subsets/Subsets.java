package other.subsets;

import java.util.ArrayList;
import java.util.List;

//Given a set with distinct elements, find all of its distinct subsets.
public class Subsets {
    public static void main(String[] args) {
        int[] nums = {1, 3};
        List<List<Integer>> results = new ArrayList<>();
        generateSubsets(nums, results, new ArrayList<>(), 0);
    }

    private static void generateSubsets(int[] nums, List<List<Integer>> results, List<Integer> list, int index) {
        if (index <= nums.length) {
            results.add(new ArrayList<>(list));
        }
        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            generateSubsets(nums, results, list, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
