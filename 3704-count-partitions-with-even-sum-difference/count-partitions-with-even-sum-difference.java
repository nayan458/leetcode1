class Solution {
    public int countPartitions(int[] nums) {
        
        int sum = 0, count = 0, leftSum = nums[0];

        for(int i = 1; i < nums.length; i++){
            sum += nums[i];
        }

        for(int i = 0; i < nums.length-1; i++){
            if((sum - leftSum)%2==0)
                count++;
            sum -= nums[i];
            leftSum+=nums[i];
        }

        return count;
    }
}