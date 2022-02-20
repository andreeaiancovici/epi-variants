package epi.arrays._6._6;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Question:
 * Write a program that takes an array denoting the daily stock price, and returns the
 * maximum profit that could be made by buying and then selling one share of that
 * stock.
 * ---
 * Memo:
 * Buy And Sell class of problems (dynamic programming)
 * ---
 * Solution:
 * Compute the difference between the global maximum and global minimum.
 * E.g. [7,1,5,3,6,4] is the array of daily stock prices.
 *   ▲
 *   │
 *   │
 *   │
 * 7┼x┼
 *   │
 * 6 ├───────────x
 *   │           │
 * 5 ├─────x     │
 *   │     │     │
 * 4 ├─────┼─────┼──x
 *   │     │     │  │
 * 3 ├─────┼──x  │  │
 *   │     │  │  │  │
 *   │     │  │  │  │
 *   │     │  │  │  │
 * 1 ├──x  │  │  │  │
 *   │  │  │  │  │  │
 *   └──┴──┴──┴──┴──┴───────────────►
 *      1  2  3  4  5
 * The above graph helps us find the global maximum (day 4 with 6 stock price) and global minimum (day 1 with 1 stock price).
 * Be aware that we need to buy at a minimum price, before we can sell at a maximum one.
 * ---
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class BuyAndSellStock {

    public static void main(String[] args) {
        assertEquals(30, computeMaxProfit(Arrays.asList(310, 315, 275, 295, 260, 270, 290, 230, 255, 250)));
    }

    private static int computeMaxProfit(List<Integer> prices) {
        int maxProfit = 0;
        int minPrice = prices.get(0);

        for (int i = 1; i < prices.size(); i++) {
            // Compute minimum price so far
            minPrice = Math.min(minPrice, prices.get(i));
            // Recompute maximum profit so far, using the previous minimum price
            maxProfit = Math.max(maxProfit, prices.get(i) - minPrice);
        }

        return maxProfit;
    }
}
