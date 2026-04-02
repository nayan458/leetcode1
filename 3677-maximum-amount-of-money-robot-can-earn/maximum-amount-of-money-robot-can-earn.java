class Solution {
    int[][][] t;
    public int maximumAmount(int[][] coins) {
        int m = coins.length + 1;
        int n = coins[0].length + 1;
        this.t = new int[m][n][3];

        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++)
                for(int k = 0; k < 3; k++)
                    if(i == 0 || j == 0)
                        t[i][j][k] = Integer.MIN_VALUE;

        for(int i = 1; i < m; i++)
            for(int j = 1; j < n; j++)
                for(int k = 0; k < 3; k++) {
                    if(i == 1 && j == 1) {
                        if(k > 0 & coins[i-1][j-1] < 0)
                            t[i][j][k] = 0;
                        else
                            t[i][j][k] = coins[i-1][j-1];
                        continue;
                    }
                    int top = t[i-1][j][k];
                    int left = t[i][j-1][k];

                    int take = coins[i-1][j-1] + Math.max(top,left);
                    int skips = Integer.MIN_VALUE;

                    if(k > 0) {
                        int stop = t[i-1][j][k-1];
                        int sleft = t[i][j-1][k-1];
                        skips = Math.max(stop,sleft);
                    }

                    t[i][j][k] = Math.max(skips,take);
                }

        return t[m-1][n-1][2];
    }

    // private int dp(int[][] coins, int i, int j,int skip) {
    //     if(i == 0 || j == 0)
    //         return Integer.MIN_VALUE;
    //     if(i == 1 && j == 1) {
    //         if(skip > 0 & coins[i-1][j-1] < 0)
    //             return 0;
    //         return coins[i-1][j-1];
    //     }

    //     if(t[i][j][skip] != 0)
    //         return t[i][j][skip];

    //     int top = dp(coins, i-1, j, skip);
    //     int left = dp(coins, i, j-1, skip);

    //     int take = coins[i-1][j-1] + Math.max(top,left);
    //     int skips = Integer.MIN_VALUE;

    //     if(skip > 0) {
    //         int stop = dp(coins, i-1, j, skip-1);
    //         int sleft = dp(coins, i, j-1, skip-1);
    //         skips = Math.max(stop,sleft);
    //     }

    //     return t[i][j][skip] = Math.max(skips,take);
    // }
}