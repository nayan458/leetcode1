class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length <= 1)
            return 0;
        int buy = prices[0];
        int sell = prices[1];
        int profit = sell - buy;

        for(int elem: prices) {
            int currProfit = elem - buy;
            if(elem < buy)
                buy = elem;
            profit = Math.max(profit, currProfit);
        }
        return profit;
    }
}