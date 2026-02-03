class Solution {
    public boolean isTrionic(int[] nums) {
        int i = 0, p = 0, q = 0, n = nums.length - 1;
        
        while(i < n && nums[i] < nums[i+1])
            i++;
        p = i;

        while(i < n && nums[i] > nums[i+1])
            i++;
        q = i;

        while(i < n && nums[i] < nums[i+1])
            i++;

        return i == n && 0 < p && p < q && q < n;
    }
}