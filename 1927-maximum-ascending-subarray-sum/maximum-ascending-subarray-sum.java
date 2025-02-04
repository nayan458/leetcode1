class Solution {
    public int maxAscendingSum(int[] nums) {
        
        int max = 0, currentMax = nums[0];

        for(int i = 1; i < nums.length; i++){
            if(nums[i-1] >= nums[i]){
                max = Math.max(max,currentMax);
                currentMax = nums[i];
                continue;
            }
            currentMax += nums[i];
        }
        return Math.max(currentMax,max);
    }
}