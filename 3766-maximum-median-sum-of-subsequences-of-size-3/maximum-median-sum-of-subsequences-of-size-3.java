class Solution {
    public long maximumMedianSum(int[] nums) {
        Arrays.sort(nums);
        long sum = 0;
            for(int i = nums.length - 2, n = nums.length / 3; n > 0 ; i-=2, n--)
            sum += nums[i];

        return sum;
    }
}