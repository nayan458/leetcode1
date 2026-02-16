class Solution {
    String text1;
    String text2;
    int[][] t;
    public int longestCommonSubsequence(String text1, String text2) {
        this.text1 = text1;
        this.text2 = text2;
        this.t = new int[text1.length() + 1][text2.length() + 1];

        init();

        for(int i = 1; i <= text1.length(); i++) {
            for(int j = 1; j <= text2.length(); j++) {
                if(t[i][j] != -1) continue;
                if(text1.charAt(i-1) == text2.charAt(j-1))
                    t[i][j] = 1 + t[i-1][j-1];
                else
                    t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
            }
        }
        return t[text1.length()][text2.length()];
    }

    private void init(){
        for(int i = 1; i < t.length; i++){
            for(int j = 1; j < t[0].length; j++)
                t[i][j] = -1;
        }
    }

    // private int lcs(int idx1, int idx2) {
    //     if(idx1 == 0 || idx2 == 0)
    //         return 0;
    //     if(t[idx1][idx2] != -1) return t[idx1][idx2];
    //     if(text1.charAt(idx1-1) == text2.charAt(idx2-1))
    //         return t[idx1][idx2] = 1 + lcs(idx1-1, idx2-1);
    //     else 
    //         return t[idx1][idx2] = Math.max(
    //             lcs(idx1,idx2-1),
    //             lcs(idx1-1,idx2)
    //         );
    // }
}