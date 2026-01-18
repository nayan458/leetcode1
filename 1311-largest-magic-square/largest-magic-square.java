class Solution {

    private int[][] prefixSumRow;
    private int[][] prefixSumCol;
    private int[][] prefixSumDiag;
    private int m;
    private int n;
    
    public int largestMagicSquare(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        prefixSumRow = new int[m][n];
        prefixSumCol = new int[m][n];
        prefixSumDiag = new int[m][n];
        
        calcPrefixSum(grid);

        for (int size = Math.min(m, n); size > 0; size--) {
            for (int i = 0; i + size - 1 < m; i++) {
                for (int j = 0; j + size - 1 < n; j++) {
                    if (isMagicSquare(i, j, size)) return size;
                }
            }
        }
        return 0;
    }

    private void calcPrefixSum(int[][] grid) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                prefixSumRow[i][j] =
                        grid[i][j] + (j > 0 ? prefixSumRow[i][j - 1] : 0);

                prefixSumCol[i][j] =
                        grid[i][j] + (i > 0 ? prefixSumCol[i - 1][j] : 0);

                prefixSumDiag[i][j] =
                        grid[i][j] + (i > 0 && j > 0 ? prefixSumDiag[i - 1][j - 1] : 0);
            }
        }
    }

    private boolean isMagicSquare(int i, int j, int size) {
        int row = getRowSum(i, j, size);
        if (row < 0) return false;

        int col = getColSum(i, j, size);
        if (row != col) return false;

        int diag = getDiagSum(i, j, size);
        return row == diag;
    }

    private int getRowSum(int i, int j, int size) {
        int sum = 0;
        for (int t = 0; t < size; t++) {
            int curr = prefixSumRow[i + t][j + size - 1]
                     - (j > 0 ? prefixSumRow[i + t][j - 1] : 0);
            if (t == 0) sum = curr;
            else if (sum != curr) return -1;
        }
        return sum;
    }

    private int getColSum(int i, int j, int size) {
        int sum = 0;
        for (int t = 0; t < size; t++) {
            int curr = prefixSumCol[i + size - 1][j + t]
                     - (i > 0 ? prefixSumCol[i - 1][j + t] : 0);
            if (t == 0) sum = curr;
            else if (sum != curr) return -2;
        }
        return sum;
    }

    private int getDiagSum(int i, int j, int size) {
        int diag1 = prefixSumDiag[i + size - 1][j + size - 1]
                  - (i > 0 && j > 0 ? prefixSumDiag[i - 1][j - 1] : 0);

        int diag2 = 0;
        for (int k = 0; k < size; k++) {
            diag2 += prefixSumRow[i + k][j + size - 1 - k]
                   - (j + size - 2 - k >= 0
                      ? prefixSumRow[i + k][j + size - 2 - k]
                      : 0);
        }

        return diag1 == diag2 ? diag1 : -3;
    }
}
