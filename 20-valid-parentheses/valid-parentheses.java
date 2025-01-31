class Solution {
    public boolean isValid(String str) {
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            if(ch == '(' || ch == '{' ||ch == '[' )
                st.push(str.charAt(i));
            else{
                if(st.empty())
                    return false;

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
                        break;
                }
            }
        }
        return st.empty() ? true : false;
    }
}