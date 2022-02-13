package epi.arrays._6._2.variant;

import static org.junit.Assert.assertEquals;

/**
 * Question:
 * Write a program which takes as input two strings s and t of bits encoding binary numbers Bs and Bt,
 * respectively, and returns a new string of bits representing the number Bs + Bt.
 * ---
 * Solution:
 * The idea is to follow the primitive algorithm for addition of binaries.
 * E.g.
 *  1010+
 *   111
 * -----
 * 10001, carry = 1 when processing 2nd, 3th, and 4th positions, from right to left
 *
 * Iterate the input array, starting from right to left and process each digit, keeping a carry = 1 if necessary.
 * Note: We are not restricted to any overflow, due to the fact that no Java primitive types with bounded maximum values are used.
 * ---
 * Time Complexity: O(n), where n is the maximum length between strings s and t
 * Space Complexity: O(1) (we don't take in consideration the size of the result)
 */
public class AddBinary {

    public static void main(String[] args) {
        assertEquals("10001010000", addBinary("10101010", "1110100110"));
        assertEquals("11101010000011100010110110", addBinary("10101010110001100", "11101001101110001100101010"));
    }

    private static String addBinary(String s, String t) {
        StringBuilder stringBuilder = new StringBuilder();
        boolean hasCarry = false;

        int i = s.length() - 1, j = t.length() - 1;
        // Iterate through each digit, starting from right to left
        while (i >= 0 && j >= 0) {
            // perform addition between digits of the same position from s and t
            hasCarry = addBinaryDigits(stringBuilder, s.charAt(i--), t.charAt(j--), hasCarry);
        }

        while (i >= 0) {
            // perform addition of rest of s and carry if necessary
            hasCarry = addBinaryDigits(stringBuilder, s.charAt(i--), '0', hasCarry);
        }

        while (j >= 0) {
            // perform addition of rest of t and carry if necessary
            hasCarry = addBinaryDigits(stringBuilder, '0', t.charAt(j--), hasCarry);
        }

        if (hasCarry) {
            // if any carry is left, add 1
            stringBuilder.append("1");
        }

        // don't forget to reverse result
        stringBuilder.reverse();

        return stringBuilder.toString();
    }

    private static boolean addBinaryDigits(StringBuilder stringBuilder, char sChar, char tChar, boolean hasCarry) {
        if (sChar == '1' && tChar == '1') {
            if (hasCarry) {
                // 1 + 1 + 1 = 1 and remaining carry = 1
                stringBuilder.append("1");
            } else {
                // 1 + 1 = 0 and remaining carry = 1
                stringBuilder.append("0");
            }
            hasCarry = true;
        } else if (sChar == '1' || tChar == '1') {
            if (hasCarry) {
                // 1 + 0 + 1 = 0 and remaining carry = 1
                stringBuilder.append("0");
            } else {
                // 1 + 0 = 1 and remaining carry = 0 (no previous carry exists)
                stringBuilder.append("1");
            }
        } else {
            if (hasCarry) {
                // both digits are 0, so 1 comes from adding the previous carry, which becomes 0
                stringBuilder.append("1");
                hasCarry = false;
            } else {
                // both digits are 0 and there is no previous carry
                stringBuilder.append("0");
            }
        }
        return hasCarry;
    }
}
