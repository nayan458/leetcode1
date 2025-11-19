class Solution {
    public int findFinalValue(int[] nums, int original) {
        // Arrays.sort(nums);
        boolean[] set = new boolean[1001];
        for(int elem: nums) {
            set[elem] = true;
            while(original <= 1000 && set[original])
                original *= 2;
            if(original > 1000)
                return original;
        }
        return original;
    }
}