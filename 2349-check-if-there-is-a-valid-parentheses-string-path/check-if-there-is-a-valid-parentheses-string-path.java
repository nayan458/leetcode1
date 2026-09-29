class Solution {
    private char[][] grid;
    private Boolean[][][] t;
    
    public boolean hasValidPath(char[][] grid) {
        this.grid = grid;
        int n = grid.length, m = grid[0].length;
        this.t = new Boolean[n+1][m+1][401];

        if(grid[0][0] == ')' || grid[n-1][m-1] == '(')   return false;

        return dp(n,m,0);
    }

    private boolean dp(int n, int m, int count) {
        if (count > 0) return false; 
        if(n == 1 && m == 1)
            return count + 1 == 0;
        int countIdx = count + 200;

        if(t[n][m][countIdx] != null)
            return t[n][m][countIdx];

        if(n == 1)
            return t[n][m][countIdx] = dp(n, m-1, count + getPValue(grid[n-1][m-1]));
        if(m == 1) 
            return t[n][m][countIdx] = dp(n-1, m, count + getPValue(grid[n-1][m-1]));
        
        return t[n][m][countIdx] = dp(n, m-1, count + getPValue(grid[n-1][m-1])) || 
                dp(n-1, m, count + getPValue(grid[n-1][m-1]));
    }

    private int getPValue(char ch) {
        return switch(ch) {
            case '(' -> 1;
            case ')' -> -1;
            default -> throw new IllegalArgumentException("Invalid character: " + ch);
        };
    }
}