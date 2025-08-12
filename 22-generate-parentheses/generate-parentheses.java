class Solution {

    List<String> ans = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        createParenthesis(new StringBuffer("("), 1, 0, n);
        return ans;
    }

    private void createParenthesis(StringBuffer str, int open, int close, int n) {
        // breaking statement
        if(close == n){
            ans.add(new String(str.toString()));
            return;
        }

        if(open < n)
            createParenthesis(new StringBuffer(str).append("("), open + 1, close, n);
        if(close < open)
            createParenthesis(new StringBuffer(str).append(")"), open, close + 1, n);
    }
}