class Solution {
    private int[] coins;
    private int[][] t;
    public int change(int amount, int[] coins) {
        this.coins = coins;
        this.t = new int[coins.length+1][amount+1];
        for(int i = 0; i < t.length; i++)
            for(int j = 0; j < t[0].length; j++)
                t[i][j] = -1;
        return dp(coins.length,amount);
    }

    private int dp(int idx, int amount) {
        if(amount == 0) return 1;
        if(idx == 0) return 0;
        if(t[idx][amount] != -1) return t[idx][amount];
        if(coins[idx-1] > amount) return dp(idx-1,amount);
        else
            return t[idx][amount] = dp(idx,amount-coins[idx-1]) + dp(idx-1,amount);
    }
}