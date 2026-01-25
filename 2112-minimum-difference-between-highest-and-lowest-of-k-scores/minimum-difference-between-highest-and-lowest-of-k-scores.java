class Solution {
    public int minimumDifference(int[] nums, int k) {
        int min = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for(int i = 0; (i+k-1) < nums.length; i++)
            min = Math.min((nums[i+k-1] - nums[i]),min);
        return min;
    }
}
