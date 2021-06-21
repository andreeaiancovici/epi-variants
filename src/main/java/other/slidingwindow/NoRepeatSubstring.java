package other.slidingwindow;

import java.util.HashMap;

//Given a string, find the length of the longest substring which has no repeating characters.
//Time: O(n)
//Space: O(k)
public class NoRepeatSubstring {
    public static void main(String[] args) {
        String s = "aabccbb";
        int i = 0, maxLength = 0;
        HashMap<Character, Integer> lastIndexMap = new HashMap<>();
        for(int j = 0; j < s.length(); j++) {
            Integer lastIndex = lastIndexMap.get(s.charAt(j));
            while(lastIndex != null && i < s.length()) {
                lastIndexMap.remove(s.charAt(i));
                i++;
                lastIndex = lastIndexMap.get(s.charAt(i));
            }
            lastIndexMap.put(s.charAt(j), j);
            maxLength = Math.max(maxLength, j - i + 1);
        }
        System.out.printf("Length of the longest substring which has no repeating characters from %s is %d", s, maxLength);
    }
}
