class Solution {
    private static final int MOD = 1_000_000_007;

    public int xorAfterQueries(int[] nums, int[][] queries) {
        Map<Integer, List<int[]>> groupQueryByK = new HashMap<>();

        for (int[] query : queries) {
            groupQueryByK
                .computeIfAbsent(query[2], k -> new ArrayList<>())
                .add(query);
        }

        for (Map.Entry<Integer, List<int[]>> entry : groupQueryByK.entrySet()) {
            int k = entry.getKey();
            compute(entry.getValue(), k, nums);
        }

        int xor = 0;
        for (int num : nums) xor ^= num;

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