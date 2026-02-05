class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        for(int i = 0; i < n; i++)
            result[i] = get(nums,i);
        return result;
    }
    private int get(int[] nums, int idx){
        int r = Math.abs(nums[idx]);
        int n = nums.length;
        if(nums[idx] > 0)
            return nums[(r+idx)%n];
        return nums[ ((idx - r) % n + n) % n];

    }
}