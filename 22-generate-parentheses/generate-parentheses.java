class Solution {

    List<String> ans = new ArrayList<>();
    int n;

    public List<String> generateParenthesis(int n) {
        this.n = n;
        backtracking(new StringBuffer("("), 1, 0);
        return ans;
    }

    private void backtracking(StringBuffer str, int open, int close) {
        if(close == n){
            ans.add(new String(str.toString()));
            return;
        }

        if(open < n){
            backtracking(str.append("("), open + 1, close);
            str.delete(str.length() - 1, str.length());
        }
        if(close < open){
            backtracking(str.append(")"), open, close + 1);
            str.delete(str.length() - 1, str.length());
        }
    }
}