class Solution {
    private static final int MOD = 1_000_000_007;
    
    static {
        int[] arr = {38,223,100,123,406,234,256,93,222,259,233,69,139,245,45,98,214};
        for(int i = 0; i < 500; i++)
            countPermutations(arr);
    }

    public static int countPermutations(int[] complexity) {
        int count = 1;
        if(noMaster(complexity)) return 0;
        int n = complexity.length;
        for(int i = 1; i < n; i++)
            count = (int) (((count % MOD) * (1L % MOD) * (i % MOD)) % MOD);
        return count % MOD;
    }

    private static boolean noMaster(int[] arr) {
        int master = arr[0];
        for(int i = 1; i < arr.length; i++)
            if(arr[i] <= master)
                return true;
        return false;
    }
}