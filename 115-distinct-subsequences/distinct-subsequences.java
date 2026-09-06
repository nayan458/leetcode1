class Solution {

    private String s;
    private String t;

    private int[][] memo;

    public int numDistinct(String s, String t) {
        this.s = s;
        this.t = t;

        this.memo = new int[s.length() + 1][t.length() + 1];
        for(int i = 0; i < memo.length; i++)
            for(int j = 0; j < memo[0].length; j++)
                memo[i][j] = -1;

        return dp(s.length(), t.length());
    }

    private int dp(int m, int n) {
        if(m == 0 && n > 0) return 0;
        if(n == 0)
            return 1;

        if(memo[m][n] != -1) return memo[m][n];

        if(s.charAt(m-1) != t.charAt(n-1)) {
            return memo[m][n] = dp(m-1,n);
        }

        int take = dp(m-1,n-1); 
        int skip = dp(m-1,n);
        return memo[m][n] = take + skip;
    }
}