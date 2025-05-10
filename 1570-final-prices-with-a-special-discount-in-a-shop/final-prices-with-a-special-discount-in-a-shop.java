//  TIME COMPLEXITY O(N^2)
// Although it's time complexity is higher but it is good for smaller input constrains
class Solution {
    public int[] finalPrices(int[] prices) {
        int n=prices.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++)
            if(prices[i]>=prices[j]){
                prices[i]-=prices[j];
                break;
            }
        }
        return prices;
    }
}



//  TIME COMPLEXITY O(N)

// // Not using PAIR and using KISS
// class Solution {
//     public int[] finalPrices(int[] prices) {
//         Stack<Integer> stk = new Stack<>();
//         int i = 0;
//         while(i < prices.length){
//             while(!stk.isEmpty() && (prices[stk.peek()] >= prices[i]))
//                 prices[stk.pop()] -=prices[i];

//             stk.push(i);

//             ++i;
//         }
//         return prices;
//     }
// }

// USING PAIRS


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