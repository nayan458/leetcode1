class Solution {
    private int blockSize;
    private int[] blocks;
    private final static int MOD = 1_000_000_007;

    public int xorAfterQueries(int[] nums, int[][] queries) {
        int n = nums.length;
        this.blockSize = (int) Math.ceil(Math.sqrt(n));
        
        Map<Integer,List<int[]>> groupByK = new HashMap<>();
        
        for(int[] query: queries) {
            int l = query[0], r = query[1], k = query[2], v = query[3];
            if(v == 1) continue;
            if(k > blockSize)  {
                for(int i = l; i <= r; i+= k)
                    nums[i] = (int)((long)nums[i] * v % MOD);
            }
            else
                groupByK.computeIfAbsent(k, c -> new ArrayList<>()).add(query);

        }

        for(List<int[]> queryGroup: groupByK.values())
            compute(queryGroup,nums);

        int xor = 0;

        for(int elem: nums)
            xor ^= elem;

        return xor;
    }

    private void compute(List<int[]> queries, int[] nums) {
        int n = nums.length;
        int[] diff = new int[n];
        int k = 0;
        Arrays.fill(diff, 1);

        for(int[] query: queries){
            int l = query[0], r = query[1], v = query[3];
            k = query[2];
            diff[l] = (int)((long)diff[l] * v % MOD);

            int steps = (r-l) / k;
            int next = l + (steps + 1) * k;

            if(next < n)
                diff[next] = (int)((long)diff[next] * modInverse(v) % MOD);
        }

        for(int i = k; i < n; i++)
            diff[i] = (int)((long)diff[i] * diff[i-k] % MOD);

        for(int i = 0; i < n; i++)
            nums[i] = (int)((long)nums[i] * diff[i] % MOD);
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