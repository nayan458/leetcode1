class Solution {
    private static final int MOD = 1_000_000_007;
    public int countPermutations(int[] complexity) {
        int count = 1;
        if(noMaster(complexity)) return 0;
        int n = complexity.length;
        for(int i = 1; i < n; i++)
            // count = (int) ((count % MOD) * (1L % MOD) * (i % MOD)) % MOD;
            count = (int) (((count % MOD) * (1L % MOD) * (i % MOD)) % MOD);
        return count % MOD;
    }

    private boolean noMaster(int[] arr) {
        int master = arr[0];
        for(int i = 1; i < arr.length; i++)
            if(arr[i] <= master)
                return true;
        return false;
    }
}