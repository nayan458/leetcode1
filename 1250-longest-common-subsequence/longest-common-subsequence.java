class Solution {
    String text1;
    String text2;
    int[][] t;
    public int longestCommonSubsequence(String text1, String text2) {
        this.text1 = text1;
        this.text2 = text2;
        this.t = new int[text1.length() + 1][text2.length() + 1];
        for(int[] row: t)
            Arrays.fill(row,-1);
        return lcs(text1.length(), text2.length());
    }

    private int lcs(int idx1, int idx2) {
        if(idx1 == 0 || idx2 == 0)
            return 0;
        if(t[idx1][idx2] != -1) return t[idx1][idx2];
        if(text1.charAt(idx1-1) == text2.charAt(idx2-1))
            return t[idx1][idx2] = 1 + lcs(idx1-1, idx2-1);
        else 
            return t[idx1][idx2] = Math.max(
                lcs(idx1,idx2-1),
                lcs(idx1-1,idx2)
            );
    }
}