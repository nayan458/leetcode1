class Solution {
    public boolean isTrionic(int[] nums) {
        int p = 0, q=0, i = 0;
        // strictly increasing
        while(i < nums.length - 1 && nums[i] < nums[i+1]){
            i++;
        }
        p = i;
        // strictly decreasing
        while(i < nums.length - 1 && nums[i] > nums[i+1]){
            i++;
        }
        q = i;
        // strictly increasing
        while(i < nums.length - 1 && nums[i] < nums[i+1]){
            i++;
        }
        return i == nums.length - 1 && 0 < p && p < q && q < nums.length - 1;
    }
}