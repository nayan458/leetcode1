class Solution {
    private int max_limit;
    private int[][][][] t;
    private int MOD = 1_000_000_007;

    public int numberOfStableArrays(int zero, int one, int limit) {
        this.max_limit = limit;
        t = new int[zero+1][one+1][3][limit+1];

        for (int i = 0; i <= zero; i++)
            for (int j = 0; j <= one; j++)
                for (int k = 0; k < 3; k++)
                    for (int l = 0; l <= limit; l++)
                        t[i][j][k][l] = -1;

        return dp(zero, one, 2, limit);
    }

    private int dp(int zero, int one, int last, int limit) {

        if (zero == 0 && one == 0)
            return 1;

        if (t[zero][one][last][limit] != -1)
            return t[zero][one][last][limit];

        long count = 0;

        if (zero > 0) {
            if (last != 0)
                count += dp(zero-1, one, 0, max_limit-1);
            else if (limit > 0)
                count += dp(zero-1, one, 0, limit-1);
        }

        if (one > 0) {
            if (last != 1)
                count += dp(zero, one-1, 1, max_limit-1);
            else if (limit > 0)
                count += dp(zero, one-1, 1, limit-1);
        }

        return t[zero][one][last][limit] = (int)(count % MOD);
    }
}