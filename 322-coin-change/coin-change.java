class Solution {
    private int[] coins;
    private int[][] t;
    public int coinChange(int[] coins, int amount) {
        this.coins = coins;
        this.t = new int[coins.length + 1][amount+1];
        dp(coins.length,amount);
        return t[coins.length][amount] == 10_005 ? -1 : t[coins.length][amount];
    }

    private int dp(int idx, int amount) {
        if(amount == 0) return 0;
        if(idx == 0) return 10_005;
        if(t[idx][amount] != 0) return t[idx][amount];
        if(coins[idx -1] > amount)
            return t[idx][amount] = dp(idx-1,amount);
        else
            return t[idx][amount] = Math.min(
                (1+dp(idx,amount - coins[idx-1])),
                dp(idx-1,amount)
            );
    }
}