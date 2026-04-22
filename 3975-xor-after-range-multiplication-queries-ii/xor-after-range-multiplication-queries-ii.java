class Solution {
    private static final int MOD = 1_000_000_007;

    public int xorAfterQueries(int[] nums, int[][] queries) {
        int n = nums.length;
        int blockSize = (int) Math.ceil(Math.sqrt(n));

        Map<Integer, List<int[]>> groupByK = new HashMap<>();

        for (int[] query : queries) {
            int l = query[0], r = query[1], k = query[2], v = query[3];

            if (k > blockSize) {
                // Large k: at most sqrt(n) elements touched, apply directly
                for (int i = l; i <= r; i += k)
                    nums[i] = (int)((long) nums[i] * v % MOD);
            } else {
                // Small k: defer and batch by k
                groupByK.computeIfAbsent(k, c -> new ArrayList<>()).add(query);
            }
        }

        // Process each small-k group via multiplicative difference array
        for (Map.Entry<Integer, List<int[]>> entry : groupByK.entrySet())
            applyDiffArray(nums, entry.getValue(), entry.getKey());

        int xor = 0;
        for (int x : nums) xor ^= x;
        return xor;
    }

    private void applyDiffArray(int[] nums, List<int[]> queries, int k) {
        int n = nums.length;
        int[] diff = new int[n];
        Arrays.fill(diff, 1);

        for (int[] query : queries) {
            int l = query[0], r = query[1], v = query[3];

            // Multiply v starting at l
            diff[l] = (int)((long) diff[l] * v % MOD);

            // Cancel v after r (at the next k-step beyond r)
            int stepsToR = (r - l) / k;
            int cancelAt = l + (stepsToR + 1) * k;
            if (cancelAt < n)
                diff[cancelAt] = (int)((long) diff[cancelAt] * modInverse(v) % MOD);
        }

        // Propagate: diff[i] = product of all multipliers up to index i (stepping by k)
        for (int i = k; i < n; i++)
            diff[i] = (int)((long) diff[i] * diff[i - k] % MOD);

        // Apply to nums
        for (int i = 0; i < n; i++)
            nums[i] = (int)((long) nums[i] * diff[i] % MOD);
    }

    private long modPow(long base, long exp) {
        long result = 1;
        base %= MOD;
        while (exp > 0) {
            if ((exp & 1) == 1) result = result * base % MOD;
            base = base * base % MOD;
            exp >>= 1;
        }
        return result;
    }

    private int modInverse(int x) {
        return (int) modPow(x, MOD - 2);
    }
}