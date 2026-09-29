import java.math.BigInteger;

class Solution {
    public boolean hasValidPath(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        if ((m + n - 1) % 2 == 1 || grid[0][0] == ')' || grid[m-1][n-1] == '(')
            return false;

        BigInteger[][] dp = new BigInteger[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                BigInteger prev;
                if (i == 0 && j == 0) {
                    prev = BigInteger.ONE;                 // balance 0 before the first char
                } else {
                    prev = BigInteger.ZERO;
                    if (i > 0) prev = prev.or(dp[i-1][j]);
                    if (j > 0) prev = prev.or(dp[i][j-1]);
                }
                dp[i][j] = grid[i][j] == '(' ? prev.shiftLeft(1) : prev.shiftRight(1);
            }
        }
        return dp[m-1][n-1].testBit(0);                    // balance 0 reachable at the end
    }
}