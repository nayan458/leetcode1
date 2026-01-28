class Solution {
    private int[][] t = new int[4001][21];
    public Solution(){
        for(int[] row: t)
            Arrays.fill(row,-1);
    }

    public int findTargetSumWays(int[] nums, int target) {
        isFound(nums,target,nums.length);
        return t[Math.abs(target*2)][nums.length];
    }

    private int isFound(int[] nums, int target, int idx) {
        if(idx == 0)
            return target == 0 ? 1:0;

        if(t[Math.abs(target*2)][idx] != -1)  return t[Math.abs(target*2)][idx];

        int positive = isFound(nums, target - nums[idx-1],idx-1);
        int negative = isFound(nums, target - (-1*nums[idx-1]), idx -1);

        return t[Math.abs(target*2)][idx] = positive + negative;
    }
}