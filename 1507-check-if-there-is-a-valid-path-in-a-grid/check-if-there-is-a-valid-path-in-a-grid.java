class Solution {
    private boolean[][] visited;
    private int m, n;

    private int[][][] directions = {
        {{0,-1},{0,1}},
        {{-1,0},{1,0}},
        {{0,-1},{1,0}},
        {{1,0},{0,1}},
        {{-1,0},{0,-1}},
        {{-1,0},{0,1}}
    };

    public boolean hasValidPath(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        visited = new boolean[m][n];
        return dfs(0, 0, -1, -1, grid);
    }

    private boolean dfs(int row, int col, int pr, int pc, int[][] grid) {
        if (!isValid(row, col) || visited[row][col]) return false;

        if (row == m - 1 && col == n - 1) return true;

        visited[row][col] = true;

        int street = grid[row][col] - 1;

        for (int[] d : directions[street]) {
            int nr = row + d[0];
            int nc = col + d[1];

            if (!isValid(nr, nc) || visited[nr][nc]) continue;
            if (pr == nr && pc == nc) continue;

            if (!connectsBack(row, col, nr, nc, grid)) continue;

            if (dfs(nr, nc, row, col, grid)) return true;
        }

        return false;
    }

    private boolean connectsBack(int fromRow, int fromCol, int toRow, int toCol, int[][] grid) {
        int street = grid[toRow][toCol] - 1;

        for (int[] d : directions[street]) {
            if (toRow + d[0] == fromRow && toCol + d[1] == fromCol) {
                return true;
            }
        }

        return false;
    }

    private boolean isValid(int r, int c) {
        return r >= 0 && c >= 0 && r < m && c < n;
    }
}