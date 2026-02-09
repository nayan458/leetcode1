class Solution {
    private int[] coins;
    private int[][] t;
    public int coinChange(int[] coins, int amount) {
        this.coins = coins;
        this.t = new int[coins.length + 1][amount+1];
        init(t);
        for(int i = 1; i <= coins.length; i++) {
            for(int j = 1; j <= amount; j++) {
                if(t[i][j] != 0) continue;
                if(coins[i-1] > j) t[i][j] = t[i-1][j];
                else t[i][j] = Math.min(1+t[i][j-coins[i-1]], t[i-1][j]);
            }
        }
        return t[coins.length][amount] == 10_005 ? -1 : t[coins.length][amount];
    }

    private void init(int[][] t) {
        for(int i = 1; i < t[0].length; i++)
            t[0][i] = 10_005;
    }

    // private int dp(int idx, int amount) {
    //     if(amount == 0) return 0;
    //     if(idx == 0) return 10_005;
    //     if(t[idx][amount] != 0) return t[idx][amount];
    //     if(coins[idx -1] > amount)
    //         return t[idx][amount] = dp(idx-1,amount);
    //     else
    //         return t[idx][amount] = Math.min(
    //             (1+dp(idx,amount - coins[idx-1])),
    //             dp(idx-1,amount)
    //         );
    // }
}