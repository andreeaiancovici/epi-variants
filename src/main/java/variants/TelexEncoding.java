package variants;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Page 100 Variant
//Time complexity O(n)
//Space complexity O(1)
public class TelexEncoding {
    public static void main(String[] args) {
        char[] c = new char[46];
        c[0] = 'H';
        c[1] = 'e';
        c[2] = 'l';
        c[3] = 'l';
        c[4] = 'o';
        c[5] = '!';
        c[6] = ' ';
        c[7] = 'H';
        c[8] = 'o';
        c[9] = 'w';
        c[10] = ' ';
        c[11] = 'a';
        c[12] = 'r';
        c[13] = 'e';
        c[14] = ' ';
        c[15] = 'y';
        c[16] = 'o';
        c[17] = 'u';
        c[18] = '?';

        int C = 19;

        System.out.println("Size: " + C);
        System.out.println("Array: " + Arrays.toString(c));

        Map<Character, List<Character>> map = new HashMap<>();
        map.put('.', Arrays.asList('D', 'O', 'T'));
        map.put(',', Arrays.asList('C', 'O', 'M', 'M', 'A'));
        map.put('?', Arrays.asList('Q', 'U', 'E', 'S', 'T', 'I', 'O', 'N', ' ', 'M', 'A', 'R', 'K'));
        map.put('!', Arrays.asList('E', 'X', 'C', 'L', 'A', 'M', 'A', 'T', 'I', 'O', 'N', ' ', 'M', 'A', 'R', 'K'));

        int T = C;

        for(int i = 0; i < C; i++) {
            if(map.containsKey(c[i])) {
                T += map.get(c[i]).size() - 1;
            }
        }

        int k = T - 1;
        for(int i = C - 1; i >= 0; i--) {
            if(map.containsKey(c[i])) {
                List<Character> list = map.get(c[i]);
                for (int p = list.size() - 1; p >= 0; p--) {
                    c[k--] = list.get(p);
                }
            } else {
                c[k--] = c[i];
            }
        }

        System.out.println("New size: " + T);
        System.out.println("New array: " + Arrays.toString(c));
    }
}
