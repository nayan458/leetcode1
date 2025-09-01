class Solution {
    int[][] t;
    public boolean canPartition(int[] nums) {
        int n = nums.length, sum = 0;

        for(int elem: nums)
            sum += elem;
        
        t = new int[n+1][sum/2 + 1];

        return sum % 2 == 0 && dp(nums, sum/2, n);
    }
    private boolean dp(int[] nums, int sum, int n){
        if(sum < 0 || n == 0)
            return false;
        if(sum == 0)
            return true;
        boolean include = false, exclude = false;
        if(sum - nums[n - 1] >= 0){
            if(t[n-1][sum - nums[n - 1]] == 0){
                include = dp(nums, sum - nums[n - 1], n - 1);
                exclude = dp(nums, sum, n - 1);

                if(include)
                    t[n-1][sum - nums[n - 1]] = 1;
                else
                    t[n-1][sum - nums[n - 1]] = -1;
            } else{
                include = (t[n-1][sum - nums[n - 1]] == 1);
                exclude = dp(nums, sum, n - 1);
            }
        }else{
            exclude = dp(nums, sum, n - 1);
        }

        return include || exclude;
    }
}