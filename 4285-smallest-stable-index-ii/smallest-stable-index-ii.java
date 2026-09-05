class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int size = nums.length;

        int[] max = new int[size];
        int[] min = new int[size];

        max[0] = nums[0];
        min[size-1] = nums[size - 1];

        for(int i = 1; i < size; i++) {
            max[i] = Math.max(nums[i],max[i-1]);
            min[size - 1 - i] = Math.min(nums[size - 1 - i], min[size - i]);
        }

        for(int i = 0; i < size; i++) {
            int instabilityScore = max[i] - min[i];
            if(instabilityScore <= k) 
                return i;
        }

        return -1;
    }
}