class Solution {
    public void solveSudoku(char[][] board) {
        int cur = 0;
        boolean[] changeable = new boolean[81];
        while(cur >= 0 && cur < 81){
            int row = cur / 9;
            int col = cur % 9;
            if(board[row][col] == '.' || changeable[cur]){
                changeable[cur] = true;
            } else {
                cur++;
                continue;
            }
            
            int i = (board[row][col] == '.') ? 1 : board[row][col] - '0';
            for(; i <= 9; i++){
                if(isValid(board, (char)( '0' + i), cur)){
                    board[row][col] = (char)('0' + i);
                    break;
                }
            }
            if(i > 9){
                board[row][col] = '.';
                while(!changeable[--cur]);
                continue;
            }
            cur++;
        }
    }
    private boolean isValid(char[][] board, char num, int position){
        int row = position/9;
        int col = position%9;
        return !existInRow(board, row, num) && !existInCol(board, col, num) && !existInMatrix(board, position, num);
    }
    private boolean existInRow(char[][] board,int row,char num){
        for(int i = 0; i < 9; i++)
            if(board[row][i] == num)
                return true;
        return false;
    }

    private boolean existInCol(char[][] board,int col,char num){
        for(int i = 0; i < 9; i++)
            if(board[i][col] == num)
                return true;
        return false;
    }

    private boolean existInMatrix(char[][] board, int position, char num) {
        int row = position / 9;
        int col = position % 9;

        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;

        for (int r = startRow; r < startRow + 3; r++) {
            for (int c = startCol; c < startCol + 3; c++) {
                if (board[r][c] == num) {
                    return true; 
                }
            }
        }
        return false;
    }

}