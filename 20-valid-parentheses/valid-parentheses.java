class Solution {
    public boolean isValid(String str) {
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            try{
                switch(ch) {
                    case ')':
                        if(st.peek() == '(') {
                            st.pop();
                            break;
                        }
                        return false;
                    case '}':
                        if(st.peek() == '{') {
                            st.pop();
                            break;
                        }
                        return false;
                    case ']':
                        if(st.peek() == '[') {
                            st.pop();
                            break;
                        }
                        return false;
                    default:
                        st.push(str.charAt(i));
                        break;
                }
            } catch (Exception  e) {
                return false;
            }
        }
        return st.empty();
    }
}