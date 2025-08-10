class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        for(int i = 0; i < k; i++){
            int col = y + i;
            for(int j = 0; j < k/2; j++){
                int row = x + j;
                int temp = grid[row][col];
                grid[row][col] = grid[x+k-j-1][col];
                grid[x+k-j-1][col] = temp;
            }
        }
        return grid;
    }
}