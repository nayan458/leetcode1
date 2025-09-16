class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        Stack<Integer> st = new Stack<>();
        List<Integer> ans = new ArrayList<>();
        for(int elem: nums){
            // check stack
            if(st.isEmpty()){
                st.add(elem);
                continue;
            }
            int curr = elem;
            while(!st.isEmpty()){
                int peek_item = st.peek();
                int gcd = GCD(peek_item, curr);
                if(gcd == 1)
                    break;
                st.pop();
                curr = LCM(peek_item, curr, gcd);
            }
            st.add(curr);
        }

        while(!st.isEmpty())
            ans.add(st.pop());

        Collections.reverse(ans);

        return ans;
    }

    private int GCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b; 
            a = temp;
        }
        return a;
    }

    private int LCM(int a, int b, int gcd){
        return (int)((a / gcd) * 1L * b);
    }
}