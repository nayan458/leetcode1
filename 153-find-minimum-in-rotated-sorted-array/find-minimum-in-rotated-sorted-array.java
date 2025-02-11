class Solution {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length -1;
        int min = nums[0];
        int mid = l + ((r - l)/2);
        
        while(l<=r) {
            mid = l + ((r - l)/2);
            if(nums[mid] < min)
                min = nums[mid];
            if(nums[mid] >= nums[l] && nums[r] < nums[l])
                l = mid + 1;
            else
                r = mid - 1;
        }
        return min;
    }
}