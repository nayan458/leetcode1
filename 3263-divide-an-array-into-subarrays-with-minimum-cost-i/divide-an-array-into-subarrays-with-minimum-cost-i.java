class Solution {
    public int minimumCost(int[] nums) {
        int a = nums[0];
        int s1 = 51;
        int s2 = 51;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] < s1){
                s2 = s1;
                s1 = nums[i];
            }
            else
                s2 = Math.min(s2,nums[i]);
        }
        return a + s1 + s2;
    }
}