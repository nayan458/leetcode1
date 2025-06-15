class Solution {
    
    private char[][] updateIland(char[][] grid,int i, int j ) {
        // update ij with 0
        grid[i][j] = '0';
        // check up down right left
        if( i-1 >= 0 && grid[i-1][j] == '1')
            grid = updateIland(grid, i-1, j);
        if( i+1 < grid.length && grid[i+1][j] == '1')
            grid = updateIland(grid, i+1, j);
        if( j-1 >= 0 && grid[i][j-1] == '1')
            grid = updateIland(grid, i, j-1);
        if( j+1 < grid[0].length && grid[i][j+1] == '1')
            grid = updateIland(grid, i, j+1);

        return grid;
    }

    public int numIslands(char[][] grid) {
        int count = 0;

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1'){
                    count++;
                    grid = updateIland(grid,i,j);
                }
            }
        }

        return count;
    }
}