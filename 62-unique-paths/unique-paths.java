class Solution {
    public int uniquePaths(int m, int n) {
        int[][] directions = {{1,0},{0,1}};
        int[][] t = new int[m+1][n+1];
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(i==1 && j==1)
                    t[i][j] = 1;
                else
                    t[i][j] = (t[i][j-1] + t[i-1][j]);
            }
        }
        return t[m][n];
    }
}