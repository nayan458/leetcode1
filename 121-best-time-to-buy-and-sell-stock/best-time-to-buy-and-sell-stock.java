class Solution {
    public int maxProfit(int[] prices) {
        int maxProfitGain = 0,minPrice = Integer.MAX_VALUE, n = prices.length, currentMaxProfit = 0;
        for( int i = 0; i < n; i++){
            minPrice = Math.min(minPrice,prices[i]);
            currentMaxProfit = prices[i] - minPrice;
            maxProfitGain = Math.max(maxProfitGain,currentMaxProfit);
        }
        return maxProfitGain;
    }
}