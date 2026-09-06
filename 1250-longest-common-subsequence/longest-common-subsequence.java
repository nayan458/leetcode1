class Solution {

    private String text1;
    private String text2;

    private int[][] t;

    public int longestCommonSubsequence(String text1, String text2) {
        this.text1 = text1;
        this.text2 = text2;
        this.t = new int[text1.length()+1][text2.length()+1];
        for(int i = 0; i < t.length; i++)
            for(int j = 0; j < t[0].length; j++)
                t[i][j] = -1;
        return dp(text1.length(), text2.length());
    }

    private int dp(int m, int n) {
        if(m == 0 || n == 0)
            return 0;
        if(t[m][n] != -1)
            return t[m][n];
        if(text1.charAt(m-1) == text2.charAt(n-1))
            return t[m][n] = 1 + dp(m-1,n-1);
        return t[m][n] = Math.max(
            dp(m,n-1),
            dp(m-1,n)
        );
    }
}