class Solution {
    int[][] t;
    public boolean canPartition(int[] nums) {
        int total = 0;
        for(int elem: nums)
            total += elem;
        if((total & 1) == 1) return false;
        int target = total/2;
        
        init(target+1,nums.length+1);

        for(int i = 1; i <= target; i++)
            for(int j = 1; j <= nums.length; j++) {
                if(t[i][j] != 0)
                    continue;
                if(nums[j-1] > i)
                    t[i][j] = t[i][j-1];
                else {
                    int include = t[i - nums[j-1]][j-1];
                    int exclude = t[i][j-1];
                    t[i][j] = Math.max(include,exclude);
                }
            }
        return t[target][nums.length] == 1;
    }

    private void init(int m, int n){
        t = new int[m][n];
        for(int i = 0; i < t.length; i++)
            t[i][0] = -1;
        for(int j = 1; j < t[0].length; j++) 
            t[0][j] = 1;
    }
}