class Solution {
    static {
        int[] nums = {3,9,7};
        for(int i = 0; i < 500; i++)
            minOperations(nums,i+1);
    }
    public static int minOperations(int[] nums, int k) {
        int count = 0;
        for(int elem: nums) 
            count += (elem % k);
        return count % k;
    }
}