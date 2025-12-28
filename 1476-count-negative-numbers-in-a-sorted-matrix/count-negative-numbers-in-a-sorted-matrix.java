class Solution {
    public int countNegatives(int[][] grid) {
        int n = grid[0].length;
        int j = n-1;
        int ans = 0;

        for(int i = 0; i < grid.length; i++) {
            for(;j>=0;j--){
                if(grid[i][j] < 0) continue;
                j = j < n-1 ? j++ : n-1;
                break;
            }
            ans += (n-j-1);
        }
        return ans;
    }
}