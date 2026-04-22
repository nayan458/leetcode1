class Solution {
    private static final int MOD = 1_000_000_007;

    public int xorAfterQueries(int[] nums, int[][] queries) {
        Map<Integer, List<int[]>> groupQueryByK = new HashMap<>();

        for(int[] query: queries)
            groupQueryByK.computeIfAbsent(query[2], k -> new ArrayList<>()).add(query);

        for(List<int[]> queryGroup: groupQueryByK.values()){
            int k = queryGroup.get(0)[2];
            compute(queryGroup,k,nums);
        }

        int xor = 0;

        for(int elem: nums)
            xor ^= elem;

        return xor;
    }

    private void compute(List<int[]> queries, int k, int[] nums) {
        int n = nums.length;
        int[] diff = new int[n];

        Arrays.fill(diff, 1);

        for (int[] query : queries) {
            int l = query[0], r = query[1], v = query[3];

            diff[l] = (int)((long)diff[l] * v % MOD);

            int steps = (r - l) / k;
            int next = l + (steps + 1) * k;

            if (next < n) {
                diff[next] = (int)((long)diff[next] * modInverse(v) % MOD);
            }
        }

        for (int i = k; i < n; i++) {
            diff[i] = (int)((long)diff[i] * diff[i - k] % MOD);
        }

        for (int i = 0; i < n; i++) {
            nums[i] = (int)((long)nums[i] * diff[i] % MOD);
        }
    }

    // private void compute(List<int[]> queries, int k, int[] nums) {
    //     int n = nums.length;
    //     int[] diff = new int[n];

    //     for(int i = 0; i < n; i++) diff[i] = 1;

    //     for(int[] query: queries){
    //         int l = query[0], r = query[1], v = query[3] % MOD;

    //         diff[l] = ((diff[l] % MOD) * v) % MOD;

    //         int steps = (r-l) / k;
    //         int next = l + ((steps + 1) * k);
    //         if(next < n)
    //             diff[next] = ((diff[next] % MOD) * (modInverse(v) % MOD)) % MOD;
    //     }

    //     for(int i = k; i < n; i++)
    //         diff[i] = ((diff[i] % MOD) * (diff[i-k] % MOD)) % MOD;

    //     for(int i = 0; i < n; i++)
    //         nums[i] = ((nums[i] % MOD) * (diff[i] % MOD)) % MOD;
    // }

    private int modPow(int base, int exp) {
        long result = 1;
        long b = base;

        while (exp > 0) {
            if ((exp & 1) == 1) result = (result * b) % MOD;
            b = (b * b) % MOD;
            exp >>= 1;
        }

        return (int) result;
    }

    private int modInverse(int x) {
        return modPow(x, MOD - 2);
    }
}
