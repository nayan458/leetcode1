class Solution {
    public int[] finalPrices(int[] prices) {
        Stack<Integer> stk = new Stack<>();
        int i = 0;
        while(i < prices.length){
            while(!stk.isEmpty() && (prices[stk.peek()] >= prices[i]))
                prices[stk.pop()] -=prices[i];
            stk.push(i);
            ++i;
        }

        return prices;
    }
}
// class Solution {
//     public int[] finalPrices(int[] prices) {
//         Stack<Pair<Integer,Integer>> stk = new Stack<>();
//         int i = 0;

//         while(i < prices.length){

//             while(!stk.isEmpty() && (stk.peek().getValue() >= prices[i])) {
//                 Pair p = stk.pop();
//                 prices[(int)p.getKey()] = (int)p.getValue() - prices[i];
//             }

//             stk.push(new Pair(i,prices[i]));

//             ++i;
//         }

//         return prices;
//     }
// }