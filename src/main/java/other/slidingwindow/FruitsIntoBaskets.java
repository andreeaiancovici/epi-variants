package other.slidingwindow;

import java.util.Arrays;
import java.util.HashMap;

/*Given an array of characters where each character represents a fruit tree,
you are given two baskets and your goal is to put maximum number of fruits in each basket.
The only restriction is that each basket can have only one type of fruit.
You can start with any tree, but once you have started you can’t skip a tree.
You will pick one fruit from each tree until you cannot, i.e., you will stop when
you have to pick from a third fruit type.
Write a function to return the maximum number of fruits in both the baskets.*/
//Time: O(n)
//Space: O(1)
public class FruitsIntoBaskets {
    public static void main(String[] args) {
        char[] fruits = {'A', 'B', 'C', 'B', 'B', 'C'};
        int maxNoFruits = 0;
        HashMap<Character, Integer> frequencies = new HashMap<>();
        int i = 0;
        for (int j = 0; j < fruits.length; j++) {
            frequencies.merge(fruits[j], 1, Integer::sum);
            while (frequencies.size() > 2 && i < fruits.length) {
                Integer frequency = frequencies.get(fruits[i]);
                if (frequency == 1) {
                    frequencies.remove(fruits[i]);
                } else {
                    frequencies.put(fruits[i], frequency - 1);
                }
                i++;
            }
            maxNoFruits = Math.max(maxNoFruits, j - i + 1);
        }
        System.out.printf("Maximum number of fruits in both baskets from %s is %d.", Arrays.toString(fruits), maxNoFruits);
    }
}
