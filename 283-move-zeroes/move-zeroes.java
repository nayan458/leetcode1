class Solution {
    public void swap(int[] nums, int r, int l){
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
    public void moveZeroes(int[] nums) {
        int r = -1, l = 0;
        while(l < nums.length){
            if(r == -1 && nums[l] == 0)
                r = l;
            if(nums[l] != 0 && r != -1){
                swap(nums, r, l);
                ++r;
            }
            ++l;
        }   
    }
}