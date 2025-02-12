import java.util.Arrays;

class Solution {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1, min = nums[0];
        while (l <= r) {
            int mid = (l + (r - l) / 2);
            if (nums[mid] < min)
                min = nums[mid];
            if(nums[l] == nums[r]){
                while(l <= r && nums[l] == nums[r]){
                    ++l;
                    --r;
                }
                continue;
            }
            if (nums[mid] >= nums[l] && nums[l] > nums[r])
                l = mid + 1;
            else 
                r = mid - 1;
        }
        return min;
    }
}
