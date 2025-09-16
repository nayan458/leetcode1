class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        // Stack<Integer> st = new Stack<>();
        Deque<Integer> dq = new ArrayDeque<>();
        // List<Integer> ans = new ArrayList<>();

        for(int elem: nums){
            int curr = elem;
            while(!dq.isEmpty()){
                int peek_item = dq.peekLast();
                int gcd = GCD(peek_item, curr);
                if(gcd == 1)
                    break;
                dq.pollLast();
                curr = LCM(peek_item, curr, gcd);
            }
            dq.addLast(curr);
        }

        return new ArrayList<>(dq);
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