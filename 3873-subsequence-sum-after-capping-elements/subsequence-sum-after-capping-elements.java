class Solution {
    public boolean[] subsequenceSumAfterCapping(int[] nums, int k) {
        Arrays.sort(nums);
        Set<Integer> st = new HashSet<>();
        st.add(0);
        int idx = 0;
        int n = nums.length;
        boolean[] result = new boolean[n];
        for(int i = 1; i <= n; i++){
            while(idx < n && nums[idx] <= i){
                List<Integer> list = new ArrayList<>(st);
                for(int sum: list){
                    int newSum = sum + nums[idx];
                    if(newSum <= k) st.add(newSum);
                }
                idx++;
            }
            if(st.contains(k)){
                result[i-1] = true;
            } else {
                for(int p = idx; p < n; p++){
                    int rightremaining = p-idx+1;
                    int needed = k - (rightremaining * i);
                    if(st.contains(needed)){
                        result[i-1] = true;
                        break;
                    }
                }
            }
        }
        return result;
    }
}

// class Solution {
//     int[][] t;
    
//     public boolean[] subsequenceSumAfterCapping(int[] nums, int k) {
//         int n = nums.length;
//         boolean[] ans = new boolean[n];

//         // Arrays.sort(nums);
//         for(int i = 1; i <= n; i++)
//             ans[i-1] = find(n, i, k, nums);
        
//         // int min_mid = 5000;
//         // // binary search
//         // int beg = 1, end = n, mid = 0;
//         // while(beg <= end){
//         //     mid = beg + ((end - beg)/2);
//         //     if(!find(n, mid, k, nums))
//         //         beg = mid + 1;
//         //     else{
//         //         end = mid - 1;
//         //         min_mid = Math.min(mid, min_mid);
//         //     }
//         // }

//         // for(int i = min_mid - 1; i < n; i++){
//         //     ans[i] = true;
//         // }
//         return ans;
//     }

//     private boolean find(int n,int x, int k, int[] nums){
//         int[] capped = new int[n];
//         for(int j = 0; j < n; j++)
//                 capped[j] = Math.min(x,nums[j]);
//             t = new int[n+1][k+1];
//         return dp(capped, k, n);
//     }
    
//     boolean dp(int[] wt, int w, int n) {
//         if (w == 0) return true;
//         if (n == 0) return false;
    
//         if (t[n][w] != 0) return t[n][w] == 1;
    
//         if (wt[n - 1] <= w) {
//             boolean take = dp(wt, w - wt[n - 1], n - 1);
//             boolean notTake = dp(wt, w, n - 1);
//             t[n][w] = (take || notTake) ? 1 : -1;
//         } else {
//             t[n][w] = dp(wt, w, n - 1) ? 1 : -1;
//         }
    
//         return t[n][w] == 1;
//     }

    
// }



