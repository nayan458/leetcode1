class Solution {
    public int triangularSum(int[] nums) {
        for(int j = 0; j < nums.length; j++){
            for(int i = 0; i < nums.length - j - 1; i++){
                nums[i] = (nums[i] + nums[i+1]) % 10;
            }
        }
        return nums[0];
    }
}