class Solution {
    public long maxSubarraySum(int[] num, int k) {
        long[] nums = new long[num.length];
        for(int i = 0; i < num.length; i++)
            nums[i] = num[i];

        if(k == 1)
            return kadane(nums);

        createPrefixSum(nums);
        long[] t = createMultiplicativeArrays(nums, k);

        long ans = Long.MIN_VALUE;

        for(int i = 0; i < k; i++) {
            long[] seq = extractKthTerms(t, i, k);
            ans = Math.max(ans, kadane(seq));
        }

        return ans;
    }

    private long[] extractKthTerms(long[] arr, int start, int k) {
        int n = arr.length;
        int size = (n - start + k - 1) / k;

        long[] result = new long[size];
        int idx = 0;

        for (int i = start; i < n; i += k)
            result[idx++] = arr[i];

        return result;
    }

    private long kadane(long[] arr) {
        long max = Long.MIN_VALUE;
        long curr = 0;

        for (long x : arr) {
            curr = Math.max(x, curr + x);
            max = Math.max(max, curr);
        }

        return max;
    }

    private void createPrefixSum(long[] nums) {
        long prefix = 0;
        for (int i = 0; i < nums.length; i++) {
            prefix += nums[i];
            nums[i] = prefix;
        }
    }

    private long[] createMultiplicativeArrays(long[] prefix, int k) {
        int n = prefix.length;
        int tSize = n - k + 1;

        long[] t = new long[tSize];

        for (int i = 0; i < tSize; i++) {
            if (i == 0)
                t[i] = prefix[i + k - 1];
            else
                t[i] = prefix[i + k - 1] - prefix[i - 1];
        }

        return t;
    }
}
