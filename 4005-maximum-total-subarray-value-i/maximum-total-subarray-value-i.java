class Solution {
    public long maxTotalValue(int[] nums, int k) {
        long min = Integer.MAX_VALUE;
        long max = Integer.MIN_VALUE;
        
        for(int elem: nums){
            min = Math.min(min,elem);
            max = Math.max(max,elem);
        }
        return k * (max - min);
    }
}