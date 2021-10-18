package other.dp;

public class _01Knapsack {
    public static void main(String[] args) {
        Integer[][] dp = new Integer[4][7];
        int[] profits = {1, 6, 10, 16};
        int[] weights = {1,2,3,5};
        int capacity = 7;
        System.out.println(solveKnapsack(dp, profits, weights, capacity, 0));
    }

    private static int solveKnapsack(Integer[][] dp, int[] profits, int[] weights, int capacity, int index) {
        if(capacity == 0 || index >= profits.length) {
            return 0;
        }

        if(dp[index][capacity - 1] != null) {
            return dp[index][capacity - 1];
        }

        int profitWithProduct = 0, profitWithoutProduct = 0;
        if(weights[index] <= capacity) {
            profitWithProduct = profits[index] + solveKnapsack(dp, profits, weights, capacity - weights[index], index + 1);
        }
        profitWithoutProduct = solveKnapsack(dp, profits, weights, capacity, index + 1);

        dp[index][capacity - 1] = Math.max(profitWithProduct, profitWithoutProduct);
        return dp[index][capacity - 1];
    }
}
