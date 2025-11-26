class Solution {
    private int m;
    private int n;
    private int k;
    private int[][][] t;
    private static final int MOD = 1_000_000_007;

    public int numberOfPaths(int[][] grid, int k) {
        this.k = k;
        this.m = grid.length;
        this.n = grid[0].length;

        // allocate AFTER initializing m,n
        this.t = new int[m][n][k];

        // initialize memo with -1
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                for (int mod = 0; mod < k; mod++)
                    t[i][j][mod] = -1;

        return dfs(grid, 0, 0, 0);
    }

    private int dfs(int[][] grid, int row, int col, int sum_mod) {

        // Out of bounds
        if (row >= m || col >= n)
            return 0;

        // Recalculate mod using current cell
        int new_mod = (sum_mod + grid[row][col]) % k;

        // Base case
        if (row == m - 1 && col == n - 1)
            return (new_mod == 0) ? 1 : 0;

        // Memo lookup
        if (t[row][col][new_mod] != -1)
            return t[row][col][new_mod];

        // Compute both choices
        long right = dfs(grid, row, col + 1, new_mod);
        long down  = dfs(grid, row + 1, col, new_mod);

        // Store modded result in memo
        long ans = (right + down) % MOD;

        return t[row][col][new_mod] = (int) ans;
    }
}
