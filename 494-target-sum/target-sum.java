class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return isFound(nums,target,nums.length);
    }

    private int isFound(int[] nums, int target, int idx) {
        
        if(idx == 0)
            return target == 0 ? 1:0;

        int include = isFound(nums, target - nums[idx-1],idx-1);
        int exclude = isFound(nums, target - (-1*nums[idx-1]), idx -1);

        return include + exclude;
    }
}