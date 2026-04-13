class Solution {
    public int getMinDistance(int[] nums, int target, int start) {
        int l = start;
        int r = start;
        int min = Integer.MAX_VALUE;

        while(r < nums.length){
            if(nums[r] == target){
                min = Math.abs(start - r);
                break;
            }
            r++;
        }

        while(l >= 0) {
            if(nums[l] == target){
                min = Math.min(min, Math.abs(start - l));
                break;
            }
            l--;
        }
        
        return min;
    }
}