class Solution {
    public int maxSubArray(int[] nums) {
        int curr_sum = 0, max = Integer.MIN_VALUE;

        for( int i = 0; i < nums.length; i++){
            curr_sum += nums[i];
            if(curr_sum > max)
                max = curr_sum;
            if(curr_sum < 0 )
                curr_sum = 0;
        }

        return max;
    }
}