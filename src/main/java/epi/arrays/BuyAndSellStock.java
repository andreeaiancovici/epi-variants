package epi.arrays;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/*
Write a program that takes an array denoting the daily stock price, and returns the
maximum profit that could be made by buying and then selling one share of that
stock.
Time Complexity: O(n)
Space Complexity: O(1)
 */
public class BuyAndSellStock {

    public static void main(String[] args) {
        assertEquals(30, computeMaxProfit(Arrays.asList(310, 315, 275, 295, 260, 270, 290, 230, 255, 250)));
    }

    private static int computeMaxProfit(List<Integer> prices) {
        int maxProfit = 0;
        int minPrice = prices.get(0);

        for (int i = 1; i < prices.size(); i++) {
            minPrice = Math.min(minPrice, prices.get(i));
            maxProfit = Math.max(maxProfit, prices.get(i) - minPrice);
        }

        return maxProfit;
    }
}
