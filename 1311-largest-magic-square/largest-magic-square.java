class Solution {

    private int[][] prefix;
    private int m;
    private int n;

    public int largestMagicSquare(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        prefix = new int[m + 1][n + 1];
        buildPrefix(grid);

        for (int size = Math.min(m, n); size >= 1; size--) {
            for (int i = 0; i + size - 1 < m; i++) {
                for (int j = 0; j + size - 1 < n; j++) {
                    if (isMagicSquare(grid, i, j, size)) {
                        return size;
                    }
                }
            }
        }
        return 0;
    }

    private void buildPrefix(int[][] grid) {
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                prefix[i][j] = grid[i - 1][j - 1]
                             + prefix[i - 1][j]
                             + prefix[i][j - 1]
                             - prefix[i - 1][j - 1];
            }
        }
    }

    private boolean isMagicSquare(int[][] grid, int r, int c, int size) {

        int target = getRowSum(r, c, c + size - 1);

        // early prune: first column
        if (getColSum(r, r + size - 1, c) != target) return false;

        // main diagonal
        int diag1 = 0;
        for (int k = 0; k < size; k++) {
            diag1 += grid[r + k][c + k];
        }
        if (diag1 != target) return false;

        // anti-diagonal
        int diag2 = 0;
        for (int k = 0; k < size; k++) {
            diag2 += grid[r + k][c + size - 1 - k];
        }
        if (diag2 != target) return false;

        // remaining rows
        for (int i = r + 1; i < r + size; i++) {
            if (getRowSum(i, c, c + size - 1) != target) return false;
        }

        // remaining columns
        for (int j = c + 1; j < c + size; j++) {
            if (getColSum(r, r + size - 1, j) != target) return false;
        }

        return true;
    }

    private int getRowSum(int row, int c1, int c2) {
        return prefix[row + 1][c2 + 1]
             - prefix[row][c2 + 1]
             - prefix[row + 1][c1]
             + prefix[row][c1];
    }

    private int getColSum(int r1, int r2, int col) {
        return prefix[r2 + 1][col + 1]
             - prefix[r1][col + 1]
             - prefix[r2 + 1][col]
             + prefix[r1][col];
    }
}
