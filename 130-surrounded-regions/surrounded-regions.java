class Solution {
    boolean[] visited;
    public void solve(char[][] board) {
        int m = board.length, n = board[0].length;
        visited = new boolean[m * n];
        for(int i = 0; i < n; i++){
            if(board[0][i] == 'O' && !visited[i]) dfs(board, 0, i, m, n);
            if(board[m - 1][i] == 'O' && !visited[((m - 1) * n) + i]) dfs(board, m - 1, i, m, n);
        }

        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O' && !visited[(i * n)]) dfs(board, i, 0, m, n);
            if (board[i][n - 1] == 'O' && !visited[(i * n) + (n - 1)]) dfs(board, i, n - 1, m, n);
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 'O' && !visited[(i*n) + j]) 
                    board[i][j] = 'X';
            }
        }
    }

    private void dfs(char[][] board, int row, int col, int m, int n){
        if (row < 0 || row >= m || col < 0 || col >= n) return;
        int index = row * n + col;
        if (visited[index] || board[row][col] != 'O') return;

        visited[index] = true;

        dfs(board, row - 1, col, m, n); // up
        dfs(board, row + 1, col, m, n); // down
        dfs(board, row, col - 1, m, n); // left
        dfs(board, row, col + 1, m, n); // right
    }
}