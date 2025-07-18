class Solution {
    public int searchInsert(int[] nums, int target) {
        int l = 0, r = nums.length - 1, mid = l + (r - l)/2;
        while(l <= r){
            if(nums[mid] == target)
                return mid;
            if(nums[mid] < target)
                l = mid + 1;
            else
                r = mid - 1;
            mid = l + (r - l)/2;
        }
        return l;
    }
}