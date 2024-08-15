class Solution {
    public int search(int[] nums, int target) {
        int beg = 0, end = (nums.length - 1), mid = 0;
        while (beg <= end) {
            mid = (beg + ((int) ((end - beg) / 2)));
            // int nums[beg] = nums[beg], nums[mid] = nums[mid], nums[end] = nums[end];
            if (nums[mid] == target)
                return mid;
            if (nums[beg] <= nums[mid] ) {
                if (target <= nums[mid] && target >= nums[beg])
                    end = mid - 1;
                else
                    beg = mid + 1;
            } else {
                if (target >= nums[mid] && target <= nums[end])
                    beg = mid + 1;
                else
                    end = mid - 1;
            }
        }
        return -1;
    }
}