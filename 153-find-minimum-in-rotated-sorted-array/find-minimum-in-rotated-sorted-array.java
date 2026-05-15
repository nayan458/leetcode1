class Solution {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1, min = Integer.MAX_VALUE;

        while(l <= r) {
            int m = l + (r - l) / 2;
            int left = nums[l], right = nums[r], mid = nums[m];
            
            // check if left half is sorted
                // exclude left
            // check if right half is sorted
                // trace mid and exclude right

            if(left <= mid && mid <= right)
                return Math.min(min,left);
            if(left <= mid){
                l = m + 1;
                min = Math.min(left,min);
            }
            else if(mid <= right)
                r = m - 1;
            min = Math.min(min,mid);
        }
        
        return min;
    }
}