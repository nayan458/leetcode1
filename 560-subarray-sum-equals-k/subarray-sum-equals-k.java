class Solution {
    public int subarraySum(int[] nums, int k) {
        int[] prefixSum = createPrefixSum(nums,k);    
        int count = 0;
        for(int i = 1; i < nums.length + 1; i++)
            count += countDivByK(prefixSum,i,k);
        return count;
    }

    private int countDivByK(int[] prefixSum, int d, int k) {
        int count = 0;
        if(prefixSum[d-1] == k)
            count++;
        for(int i = d; i < prefixSum.length; i++) {
            int left = prefixSum[i-d];
            int right = prefixSum[i];
            if((right - left) == k)
                count++;
        }
        return count;
    }

    private int[] createPrefixSum(int[] nums, int k) {
        int sum = 0;
        int[] prefixSum = new int[nums.length];
        int i = 0;
        for(int elem: nums) {
            sum += elem;
            prefixSum[i++] = sum;
        }
        return prefixSum;
    }
}