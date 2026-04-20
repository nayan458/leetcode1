class Solution {
    private String s1;
    private String s2;
    private int[][] t;

    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        this.s1 = text1;
        this.s2 = text2;
        this.t = new int[m+1][n+1];
        for(int i = 0; i <= m; i++)
            for(int j = 0; j <= n; j++)
                t[i][j] = -1;
        return dp(m,n);
    }
    private int dp(int i, int j) {
        if(i == 0 || j == 0)
            return 0;
        if(t[i][j] != -1)
            return t[i][j];
        if(s1.charAt(i-1) == s2.charAt(j-1))
            return t[i][j] = 1 + dp(i-1,j-1);
        return t[i][j] = Math.max(
            dp(i-1,j),dp(i,j-1)
        );
    }
}