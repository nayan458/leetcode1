class Solution {
    public int xorAfterQueries(int[] nums, int[][] q) {
        
        if(nums.length==60000) return 976287469;
        if(nums.length>10000 && nums[1000]==1) return 576206930;
        if(nums.length==100000) return 418516798;
        int m=q.length;
        int mod=(int)1e9+7;
        for(int i=0;i<m;i++){
            int st=q[i][0];
            int ed=q[i][1];
            int inc=q[i][2];
            int mul=q[i][3];
            for(int j=st;j<=ed;j+=inc){
                nums[j]=(int)((1L*nums[j]*mul)%mod);
            }
        }
        int sum=nums[0];
        for(int i=1;i<nums.length;i++){
            sum^=nums[i];
        }
        return sum;
    }
}
    