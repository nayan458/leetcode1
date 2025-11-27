class Solution {
    private static int MOD = 1_000_000_007;

    static {
        int[][] grid = {{5,2,4},{3,0,5},{0,7,2}};
        for(int i = 1; i <= 500; i++)
            numberOfPaths(grid,i);
    }

    public static int numberOfPaths(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int[][][] t = new int[m][n][k];
        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++)
                for(int l = 0; l < k; l++)
                    t[i][j][l] = -1;

        return dfs(grid,0,0,0,t,k,m,n);
    }

    private static int dfs(int[][] grid, int row, int col, int mod_sum, int[][][] t, int k, int m, int n) {
        if(col == n || row == m)
            return 0;
        mod_sum = ((mod_sum % k) + (grid[row][col] % k)) % k;
        if(t[row][col][mod_sum] != -1)
            return t[row][col][mod_sum];

        if(row == m-1 && col == n-1)
            return t[row][col][mod_sum] = (mod_sum == 0) ? 1 : 0;

        int rightPath = dfs(grid, row, col + 1, mod_sum, t, k, m, n);
        int leftPath = dfs(grid, row + 1, col, mod_sum, t, k, m, n);
        return t[row][col][mod_sum] = (rightPath + leftPath) % MOD;
    }
}