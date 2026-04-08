class Solution {
    private static final int MOD = 1_000_000_007;

    public int xorAfterQueries(int[] nums, int[][] queries) {
        for(int[] query: queries) {
            int l = query[0], r = query[1], k = query[2];
            long v = query[3] % MOD;

            if(v == 1)  continue;

            for(int idx = l; idx <= r; idx += k)
                nums[idx] = (int) ((nums[idx] * 1l * v) % MOD);
        }
        int xor = 0;
        for(int num: nums) xor ^= num;
        return xor;
    }
}