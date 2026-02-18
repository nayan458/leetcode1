// Method 2: LCS approach
class Solution {
    public boolean isSubsequence(String s, String t) {
        int m = s.length();
        int n = t.length();
        int[][] k = new int[m+1][n+1];
        if(m == 0) return true;
        for(int i=1; i <= m; i++) {
            for(int j=1; j <= n; j++) {
                if(s.charAt(i-1) == t.charAt(j-1))
                    k[i][j] = 1 + k[i-1][j-1];
                else
                    k[i][j] = Math.max(k[i][j-1],k[i-1][j]);
            }
        }
        return k[m][n] == s.length();
    }
}

// Method 1: general approach

// class Solution {
//     public boolean isSubsequence(String s, String t) {
//         int j = 0;
//         if(s.length() == 0) return true;
//         for(int i = 0; i < t.length(); i++) {
//             if(t.charAt(i) == s.charAt(j))
//                 j++;
//             if(j == s.length()) return true;
//         }
//         return false;
//     }
// }