public class prob121 {
    public static void main(String[] args) {
        int[] prices = {3,2,6,5,0,3};
        Solution121 sol = new Solution121();
        sol.maxProfit(prices);
    }
}

class Solution121 {
    public int maxProfit(int[] prices) {
        // find the max profit made so far
        int maxProfit = 0;
        int minStockPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minStockPrice) minStockPrice = prices[i];
            if (maxProfit < prices[i] - minStockPrice) maxProfit = prices[i] - minStockPrice;
        }
        return maxProfit;
    }
}