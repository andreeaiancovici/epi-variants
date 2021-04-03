package variants;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Page 93 Variant
//Time complexity O(n^2)
//Space complexity O(n)
public class PascalsTriangleUsingNSpace {
    public static void main(String[] args) {
        int rowIndex = 4;
        List<Integer> row = new ArrayList<>(Collections.nCopies(rowIndex + 1, 0));
        row.set(0, 1);
        for(int i = 1; i <= rowIndex; i++) {
            row.set(i, 1);
            for(int j = i - 1; j > 0; j--) {
                row.set(j, row.get(j) + row.get(j - 1));
            }
        }
        System.out.println(row);
    }
}
