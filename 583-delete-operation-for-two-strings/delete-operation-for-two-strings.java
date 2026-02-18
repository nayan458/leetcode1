class Solution {
    public int minDistance(String word1, String word2) {
        int l = LCS(word1,word2);
        return word1.length() - l + word2.length() - l;
    }

    private int LCS(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] t = new int[m+1][n+1];
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1))
                    t[i][j] = 1 + t[i-1][j-1];
                else
                    t[i][j] = Math.max(t[i][j-1],t[i-1][j]);
            }
        }
        return t[m][n];
    }
}