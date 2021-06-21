package other.slidingwindow;

import java.util.HashMap;

//Given a string, find the length of the longest substring in it with no more than K distinct characters.
//Time: O(n)
//Space: O(k)
public class LongestSubstringWithKDistinctCharacters {
    public static void main(String[] args) {
        String s = "araaci";
        int k = 2;
        int i = 0, maxLength = 0;
        HashMap<Character, Integer> frequencies = new HashMap<>();
        for (int j = 0; j < s.length(); j++) {
            frequencies.merge(s.charAt(j), 1, Integer::sum);
            while (frequencies.size() > k && i < s.length()) {
                Integer frequency = frequencies.get(s.charAt(i));
                if (frequency.equals(1)) {
                    frequencies.remove(s.charAt(i));
                } else {
                    frequencies.put(s.charAt(i), frequency - 1);
                }
                i++;
            }
            maxLength = Math.max(maxLength, j - i + 1);
        }
        System.out.printf("Longest sub array size with no more than K = %d distinct characters from %s is %d.", k, s, maxLength);
    }
}