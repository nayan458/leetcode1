class Solution {
    int[][] prefixSum;
    int m;
    int n;
    int threshold;

    public int maxSideLength(int[][] mat, int threshold) {
        this.m = mat.length;
        this.n = mat[0].length;
        this.prefixSum = new int[m][n];
        this.threshold = threshold;

        createPrefixSum(mat);

        int l = 0;
        int r = Math.min(m-1,n-1);
        while(l <= r){
            int mid = l + (r-l)/2;
            if(isPosible(mid)) {
                l = mid + 1;
            }
            else
                r = mid - 1;
        }
        return l;
    }
    
    private boolean isPosible(int size){
        for(int i = 0; i+size < m; i++)
            for(int j = 0; j+size < n; j++){
                int sum = 
                    prefixSum[i+size][j+size] 
                    - (i > 0 ? prefixSum[i-1][j+size] : 0) 
                    - (j > 0 ? prefixSum[i+size][j-1] : 0) 
                    + (i > 0 && j > 0 ? prefixSum[i-1][j-1] : 0);
                if(sum <= threshold)
                    return true;
            }
        return false;
    }
    
    // private boolean isPosible(int size) {
    //     for (int i = 0; i + size < m; i++) {
    //         for (int j = 0; j + size < n; j++) {
    //             int sum =
    //                 prefixSum[i + size][j + size]
    //                 - (i > 0 ? prefixSum[i - 1][j + size] : 0)
    //                 - (j > 0 ? prefixSum[i + size][j - 1] : 0)
    //                 + (i > 0 && j > 0 ? prefixSum[i - 1][j - 1] : 0);

    //             if (sum <= threshold) return true;
    //         }
    //     }
    //     return false;
    // }

    private void createPrefixSum(int[][] arr) {
        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++)
                prefixSum[i][j] = arr[i][j] - (i > 0 && j > 0 ? prefixSum[i-1][j-1] : 0) + ( i > 0 ? prefixSum[i-1][j] : 0) + (j > 0 ?prefixSum[i][j-1] : 0);
    }
}
