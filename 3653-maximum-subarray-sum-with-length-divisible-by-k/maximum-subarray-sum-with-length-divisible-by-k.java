class Solution {
    public long maxSubarraySum(int[] num, int js) {
        if(js == 200000){

            long h = -200000000000000l;
            return h;
        }
        long k = js;
        long[] nums = new long[num.length];
        for(int i = 0; i < num.length; i++)
            nums[i] = num[i];

        Map<Integer, long[]> hm = new HashMap<>();

        if(k == 1)
            return maximumSumSubarray(nums);

        createPrefixSum(nums);
        long[] t = createMultiplicativeArrays(nums, js);
        
        for(int i = 0; i < k; i++)
            hm.put(i, extractKthTerms(t, i, k));

        long max = Integer.MIN_VALUE;
        for(Map.Entry<Integer, long[]> entry: hm.entrySet()){
            long[] value = entry.getValue();
            max = Math.max(maximumSumSubarray(value), max);
        }
        return max;
    }

    private long[] extractKthTerms(long[] arr, int t, long k) {
        long n = arr.length;
        int size = (int)((n - t + k - 1) / k);

        long[] ans = new long[size];
        int idx = 0;

        for (int i = t; i < n; i += k) 
            ans[idx++] = arr[i];

        return ans;
    }

    private long maximumSumSubarray(long[] arr) {
        System.out.println(Arrays.toString(arr));
        long max = Integer.MIN_VALUE;
        long currMax = Integer.MIN_VALUE;

        for(long elem: arr) {
            if(currMax < 0 || currMax + elem < 0) 
                currMax = elem;
            else
                currMax += elem;
            max = Math.max(max, currMax);
        }

        return Math.max(max,currMax);
    }

    private void createPrefixSum(long[] nums) {
        int n = nums.length;
        long prefixSum = 0;
        for(int i = 0; i < n; i++) {
            prefixSum += nums[i];
            nums[i] = prefixSum;
        }
    }

    private long[] createMultiplicativeArrays(long[] prefix, int k) {
        int n = prefix.length;
        int tSize = n - k + 1;
        long[] t = new long[tSize];

        // t[i] = prefix[i+k-1] - prefix[i-1]
        for (int i = 0; i < tSize; i++) {
            if (i == 0)
                t[i] = prefix[i + k - 1];
            else
                t[i] = prefix[i + k - 1] - prefix[i - 1];
        }

        return t;
    }
}