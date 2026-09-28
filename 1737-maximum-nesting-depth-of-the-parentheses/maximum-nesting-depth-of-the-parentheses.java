class Solution {
    public int maxDepth(String s) {
        int maxDepth = 0;
        int currDepth = 0;
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < s.length(); i++)
            if(s.charAt(i) == '(' || s.charAt(i) == ')')
                st.push(s.charAt(i));

        while(!st.isEmpty()) {
            if(st.pop() == ')')
                currDepth++;
            else
                currDepth--;
            maxDepth = Math.max(maxDepth, currDepth);
        }

        return maxDepth;
    }
}