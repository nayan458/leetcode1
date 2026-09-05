class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int size = nums.length;

        int[] min = new int[size];
        int max = nums[0];

        min[size-1] = nums[size - 1];

        for(int i = 1; i < size; i++)
            min[size - 1 - i] = Math.min(nums[size - 1 - i], min[size - i]);

        for(int i = 0; i < size; i++) {
            max = Math.max(nums[i],max);
            if((max - min[i]) <= k) 
                return i;
        }

        return -1;
    }
}