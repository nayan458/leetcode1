class Solution {
    public List<List<String>> solveNQueens(int n) {
        int[] board = new int[n];
        int cur = 0;
        Arrays.fill(board, -1);

        List<List<String>> ans = new ArrayList<>();
        while(cur != -1){
            boolean found = false;
            for(int i = board[cur] + 1; i < n; i++){
                if(isValid(board, cur, i)){
                    board[cur] = i;
                    found = true;
                    break;
                }
            }
            if(found){
                cur++;
            } else {
                board[cur] = -1;
                cur -= 1;
            }
            if(cur == n){
                ans.add(createBoard(board));
                board[cur - 1] = -1;
                cur -= 2;
            }
        }
        return ans;
    }

    private List<String> createBoard(int[] board){
        List<String> ans = new ArrayList<>();
        for(int i = 0; i < board.length; i++){
            StringBuilder str = new StringBuilder(".".repeat(board.length));
            str.setCharAt(board[i],'Q');
            ans.add(new String(str.toString()));
        }
        return ans;
    }

    private boolean isValid(int[] board, int cur, int position){
        for(int i = 0; i < cur; i++){
            if(board[i] == position || Math.abs(i - cur) == Math.abs(position - board[i]))
                return false;
        }
        return true;
    }
}