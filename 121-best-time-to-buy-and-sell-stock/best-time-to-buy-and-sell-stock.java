class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        int buy = prices[0];
        for(int price: prices){
            int currProfit = price - buy;
            max = Math.max(max,currProfit);
            if(price < buy)
                buy = price;
        }
        return max;
    }
}