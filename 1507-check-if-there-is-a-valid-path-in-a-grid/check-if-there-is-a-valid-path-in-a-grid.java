class Solution {
    private boolean[][] visited;
    private int m, n;
    
    private int[][][] directions = {
        {{0,-1},{0,1}}, 
        {{-1,0},{1,0}},
        {{0,-1},{1,0}}, 
        {{1,0},{0,1}},
        {{-1,0},{0,-1}}, 
        {{-1,0},{0,1}}
    };

    public boolean hasValidPath(int[][] grid) {
        this.m = grid.length;
        this.n = grid[0].length;
        this.visited = new boolean[m][n];
        return dfs(0,0,-1,-1,grid);
    }

    private boolean dfs(int row, int col, int pr, int pc, int[][] grid) {
        if(!isValid(row,col) || visited[row][col])  return false;
        if(row == m-1 && col == n-1)    return true;

        visited[row][col] = true;

        int street = grid[row][col] - 1;

        for(int[] direction: directions[street]){
            int toRow = row + direction[0];
            int toCol = col + direction[1];
            if(!isValid(toRow,toCol) || visited[toRow][toCol]) continue;
            if(pr == toRow && pc == toCol) continue;

            if(!connectsBack(row, col, toRow, toCol, grid)) continue;

            if(dfs(toRow, toCol , row, col, grid)) return true;
        }

        return false;
    }

    private boolean connectsBack(int fromRow, int fromCol, int toRow, int toCol, int[][] grid) {
        int street = grid[toRow][toCol] - 1;
        for(int[] direction: directions[street]){
            int backRow = toRow + direction[0];
            int backCol = toCol + direction[1];
            if(backRow == fromRow && backCol == fromCol) return true;
        }
        return false;
    }

    private boolean isValid(int row, int col) {
        if(row < 0 || col < 0 || row >= m || col >= n)
            return false;
        return true;
    }
}