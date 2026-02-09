class Solution {
    private int[] coins;
    private int[][] t;
    public int change(int amount, int[] coins) {
        this.coins = coins;
        this.t = new int[coins.length+1][amount+1];
        init();
        for(int i = 1; i < t.length; i++)
            for(int j = 1; j < t[0].length; j++) {
                if(t[i][j] != -1) continue;
                if(coins[i-1] > j) t[i][j] = t[i-1][j];
                else t[i][j] = t[i][j - coins[i-1]] + t[i-1][j];
            }
        return t[coins.length][amount];
    }

    void init() {
        for(int i = 1; i < t.length; i++)
            for(int j = 1; j < t[0].length; j++)
                t[i][j] = -1;
        // without coin no amount other than zero is posible
        for(int j = 1; j < t[0].length; j++)
            t[0][j] = 0;
        // all amount = 0 is posible
        for(int i = 0; i < t.length; i++)
            t[i][0] = 1;

    }

    // private int dp(int idx, int amount) {
    //     if(amount == 0) return 1;
    //     if(idx == 0) return 0;
    //     if(t[idx][amount] != -1) return t[idx][amount];
    //     if(coins[idx-1] > amount) return dp(idx-1,amount);
    //     else
    //         return t[idx][amount] = dp(idx,amount-coins[idx-1]) + dp(idx-1,amount);
    // }
}