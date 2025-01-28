class Solution {
    public void swap(int[] nums, int r, int l){
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
    public void moveZeroes(int[] nums) {
        int l = -1, r = 0;
        while(r < nums.length){
            if(l == -1 && nums[r] == 0)
                l = r;
            if(nums[r] != 0 && l != -1){
                swap(nums, l,r );
                ++l;
            }
            ++r;
        }   
    }
}