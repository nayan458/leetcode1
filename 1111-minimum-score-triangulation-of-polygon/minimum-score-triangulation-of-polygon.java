// MCM variation
class Solution {
    public int minScoreTriangulation(int[] A) {
        int n = A.length;
        int[][] dp = new int[n][n];

        // dp[i][j] = min score triangulation of polygon vertices between i and j
        for (int len = 2; len < n; len++) { // length of interval
            for (int i = 0; i + len < n; i++) {
                int j = i + len;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j],
                        dp[i][k] + dp[k][j] + A[i] * A[j] * A[k]);
                }
            }
        }

        return dp[0][n - 1];
    }
}
