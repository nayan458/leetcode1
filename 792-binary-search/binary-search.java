class Solution {
    public int search(int[] nums, int target) {
        int beg = 0, end = (nums.length -1), mid;
        while(beg<=end) {
            mid = beg + (int)((end-beg)/2);
            if(nums[mid] == target)
                return mid;
            if(nums[mid] < target)
                beg = mid+1;
            else
                end = mid -1;
        }
        return -1;
    }
}