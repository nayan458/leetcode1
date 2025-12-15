class Solution {
    public long getDescentPeriods(int[] prices) {
        int i = 0;
        long ans = 0;
        while(i < prices.length) {
            long count = 1;
            while(i < prices.length-1 && (prices[i] - prices[i + 1]) == 1){ 
                count++; 
                ++i;
            }
            ans += sumOfNumbers(count);
            ++i;
        }
        return ans;
    }

    private long sumOfNumbers(long n) {
        return (n * (n+1))/2;
    }
}