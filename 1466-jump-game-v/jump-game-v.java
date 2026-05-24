class Solution {
    private int[] arr;
    private int d;
    private int n;
    private int[] t;

    public int maxJumps(int[] arr, int d) {
        this.arr = arr;
        this.d = d;
        this.n = arr.length;
        this.t = new int[n];

        int maxIdx = 1;

        for(int i = 0; i < n; i++)
            maxIdx = Math.max(maxIdx,dp(i));
        
        return maxIdx;
    }

    private int dp(int idx) {

        if(t[idx] != 0) return t[idx];
        int maxIdx = 1;

        // LEFT
        for(int i = 1; i <= d; i++) {
            if(idx - i < 0 || arr[idx] <= arr[idx-i]) break;
            maxIdx = Math.max(maxIdx, 1 + dp(idx - i));
        }

        // RIGHT
        for(int i = 1; i <= d; i++) {
            if(idx + i >= n || arr[idx] <= arr[idx+i]) break;
            maxIdx = Math.max(maxIdx, 1 + dp(idx + i));
        }
        
        return t[idx] = maxIdx;
    }
}