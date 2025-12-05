class Solution {
    public int countPartitions(int[] nums) {
        computePrefixSum(nums);
        int sum = nums[nums.length - 1];
        int count = 0;
        for(int i = 0; i < nums.length - 1; i++) {
            int diff = 2 * nums[i] - sum;
            if((diff & 1) == 0)
                count++;
        }
        return count;
    }

    private void computePrefixSum(int[] nums) {
        int prefixSum = 0;
        for(int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            nums[i] = prefixSum;
        }
    }
}