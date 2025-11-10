class Solution {
    public int minOperations(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int count = 0;

        for(int elem: nums) {
            if((!st.isEmpty() && st.peek() == elem))
                continue;
            if(st.isEmpty() || st.peek() < elem) {
                st.push(elem);
                if(elem == 0)
                    continue;
                count++;
            }
            else {
                while(!st.isEmpty() && st.peek() > elem) {
                    st.pop();
                }
                if((!st.isEmpty() && st.peek() == elem)) {
                    continue;
                } else {
                    st.push(elem);
                    if(elem == 0)
                        continue;
                    count++;
                }

            }
        }
        
        return count;
    }
}
