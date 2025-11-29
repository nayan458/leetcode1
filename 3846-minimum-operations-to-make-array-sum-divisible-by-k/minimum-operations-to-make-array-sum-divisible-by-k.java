class Solution {
    public int minOperations(int[] nums, int k) {
        int count = 0;
        for(int elem: nums) 
            count += (elem % k);
        return count % k;
    }
}