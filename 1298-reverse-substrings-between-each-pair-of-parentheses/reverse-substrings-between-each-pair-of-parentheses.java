class Solution {
    public String reverseParentheses(String s) {

        Stack<Character> st = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if(ch == ')') {
                StringBuilder sb = new StringBuilder();

                while(st.peek() != '(')
                    sb.append(st.pop());
                    
                st.pop();

                sb.chars()
                    .mapToObj(c -> (char) c)
                    .forEach(st::push);
                    
            } else {
                st.push(ch);
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()) 
            sb.append(st.pop());
        
        return sb.reverse().toString();
        
    }
}