class Solution {
    private int[][] img1;
    private int[][] img2;
    private int n;

    public int largestOverlap(int[][] img1, int[][] img2) {
        this.img1 = img1;
        this.img2 = img2;
        this.n = img1.length;

        return dp(-(n - 1), -(n - 1));
    }

    private int dp(int rowOffset, int colOffset) {

        // All possible column offsets for this row offset are exhausted
        if (colOffset == n)
            return dp(rowOffset + 1, -(n - 1));

        // All possible row offsets are exhausted
        if (rowOffset == n)
            return 0;

        int current = overlapCount(rowOffset, colOffset);

        int right = dp(rowOffset, colOffset + 1);

        return Math.max(current, right);
    }

    private int overlapCount(int rowOffset, int colOffset) {

        int overlap = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                int newRow = i + rowOffset;
                int newCol = j + colOffset;

                if (newRow >= 0 && newRow < n &&
                    newCol >= 0 && newCol < n &&
                    img1[i][j] == 1 &&
                    img2[newRow][newCol] == 1) {

                    overlap++;
                }
            }
        }

        return overlap;
    }
}