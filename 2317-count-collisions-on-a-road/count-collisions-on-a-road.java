class Solution {
    private static Stack<Character> st;

    public static int countCollisions(String directions) {
        st = new Stack<>();
        int count = 0;

        for(int i = 0; i < directions.length(); i++) {
            char d = directions.charAt(i);
            count += collisions(d);
        }
        return count;
    }

    private static int collisions(char d) {
        if(st.isEmpty() || d == 'R') {
            st.push(d);
            return 0;
        }
        switch(d) {
            case 'L':
                if(st.peek() == 'R') {
                    st.pop();
                    return 2 + collisions('S');
                }
                if(st.peek() == 'S')
                    return 1;
                return 0;
            case 'S':
                int count = 0;
                while(!st.isEmpty() && st.peek() == 'R') {
                    st.pop();
                    count++;
                }
                st.push(d);
                return count;
            default :
                break;
        }
        return 0;
    }
}