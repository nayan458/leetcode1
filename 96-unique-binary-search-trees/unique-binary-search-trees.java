class Solution {
    public int numTrees(int n) {
        return dp(1,n);
    }
    private int dp(int start,int end){
        if(start > end) return 1;
        if(start == end)
            return 1;
        int sum = 0;
        for(int i = start; i <= end; i++){
            sum += dp(start,i-1) * dp(i+1,end);
        }
        return sum;
    }
}