package variants.arrays._6._1;

import java.util.Arrays;

import static variants.arrays._6._1.DutchNationalFlagWithoutPivot.Color.*;

//Page 65 Variant
//Time complexity O(n)
//Space complexity O(1)
public class DutchNationalFlagWithoutPivot {

    enum Color {
        RED,
        WHITE,
        BLUE
    }

    public static void main(String[] args) {
        Color[] colors = new Color[]{WHITE, RED, BLUE, WHITE, RED};
//        Color[] colors = new Color[]{RED, BLUE, WHITE, RED, BLUE, BLUE, RED, BLUE, WHITE, WHITE};
        System.out.println("Colors array: " + Arrays.toString(colors));
        //Order: RED, WHITE, BLUE
        int redIndex = 0, whiteIndex = 0;
        for (int i = 0; i < colors.length; i++) {
            if (colors[i] == RED) {
                swap(colors, i, redIndex++);
                whiteIndex++;
            } else if (colors[i] == WHITE) {
                swap(colors, i, whiteIndex++);
            }
        }

        System.out.println("Colors array after ordering: " + Arrays.toString(colors));
    }

    private static void swap(Color[] colors, int i, int j) {
        Color temp = colors[j];
        colors[j] = colors[i];
        colors[i] = temp;
    }
}
