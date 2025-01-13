class Solution {
    public int missingNumber(int[] nums) {
        long n = nums.length;
        long sum = (n * (n + 1))/2;
        for(int i = 0; i < n; i++) 
            sum -= nums[i];
        return (int)sum;
    }
}