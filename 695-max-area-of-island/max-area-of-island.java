class Solution {
    int n;
    int m;

    public int maxAreaOfIsland(int[][] grid) {
        int ans = 0;
        this.n = grid[0].length;
        this.m = grid.length;
        for(int i = 0; i < grid.length; i++)
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1)
                    ans = Math.max(ans,dfs(grid, i, j, 0));
            }
        
        return ans;
    }

    private int dfs(int[][] grid, int i, int j, int count){
        if(i < 0 || j < 0 || i == m || j == n)
            return 0;
        if(grid[i][j] == 0)
            return 0;
        grid[i][j] = 0;

        int right = dfs(grid, i, j+1, count);
        int left = dfs(grid, i, j-1, count + 1);
        int bottom = dfs(grid, i+1, j, count + 1);
        int top = dfs(grid, i-1, j, count + 1);

        return right + left + bottom + top + 1;
    }
}