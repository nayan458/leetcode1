class Solution {
    public int[] finalPrices(int[] prices) {
        Stack<Pair<Integer,Integer>> stk = new Stack<>();
        int i = 0;

        while(i < prices.length){

            while(!stk.isEmpty() && (stk.peek().getValue() >= prices[i])) {
                Pair p = stk.pop();
                prices[(int)p.getKey()] = (int)p.getValue() - prices[i];
            }

            stk.push(new Pair(i,prices[i]));
            
            ++i;
        }

        return prices;
    }
}