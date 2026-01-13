class Solution {
    public boolean isValid(String s) {
        int i = 0;
        Stack<Character> st = new Stack<>();
        while(i < s.length()){
            char ch = s.charAt(i);
            if(isOpenParentheses(ch))
                st.add(ch);
            else {
                if(st.isEmpty() || notValid(ch,st.peek()))
                    return false;
                st.pop();
            }
            i++;
        }
        return true && st.isEmpty();
    }

    private boolean notValid(char close, char open){
        return (close == ')' && open != '(') ||
            (close == '}' && open != '{') ||
            (close == ']' && open != '[');
    }

    private boolean isOpenParentheses(char ch) {
        return ch == '(' || ch == '{' || ch == '[';
    }
}