package variants;

//Page 98 Variant
//Time complexity O(n)
//Space complexity O(1)
public class IntegerToSpreadsheetEncoding {
    public static void main(String[] args) {
        int colInt = 702;
        int q, r;
        StringBuilder stringBuilder = new StringBuilder();
        colInt--;
        while (colInt > 0) {
            q = colInt / 26;
            r = colInt % 26;
            stringBuilder.append((char) ('A' + r));
            colInt = q - 1;
        }
        System.out.println(stringBuilder.reverse().toString());
    }
}
