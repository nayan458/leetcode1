class Solution {
    private char[][] grid;
    private Boolean[][][] t;
    
    public boolean hasValidPath(char[][] grid) {
        if(grid[0][0] == ')') return false;
        this.grid = grid;
        int n = grid.length, m = grid[0].length;
        this.t = new Boolean[n+1][m+1][401];

        return dp(n,m,0);
    }

    private boolean dp(int n, int m, int count) {
        if (count > 0) return false; 
        count += grid[n-1][m-1] == '(' ? 1 : -1;
        if(n == 1 && m == 1)
            return count == 0;
        int countIdx = count + 200;

        if(t[n][m][countIdx] != null)
            return t[n][m][countIdx];

        if(n == 1)
            return t[n][m][countIdx] = dp(n, m-1, count);
        if(m == 1) 
            return t[n][m][countIdx] = dp(n-1, m, count);
        
        return t[n][m][countIdx] = dp(n, m-1, count) || 
                dp(n-1, m, count);
    }
}