class Solution {
    int[][] t;
    public boolean canPartition(int[] nums) {
        int total = 0;
        for(int elem: nums)
            total += elem;
        if((total & 1) == 1) return false;
        int target = total/2;
        t = new int[target+1][nums.length+1];
        return check(nums,target,nums.length) == 1;
    }

    private int check(int[] nums, int target, int idx){
        if(idx == 0 || target < 0)
            return -1;
        if(target == 0)
            return 1;
        if(t[target][idx] != 0)
            return t[target][idx];
        if(nums[idx-1] > target)
            return t[target][idx] = check(nums,target,idx-1);
        else {
            int include = check(nums,target - nums[idx-1],idx-1);
            int exclude = check(nums,target,idx-1);
            return t[target][idx] = (include == 1 || exclude == 1) ? 1 : -1;
        }
    }
}