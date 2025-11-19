class Solution {
    public int findFinalValue(int[] nums, int original) {
        Arrays.sort(nums);
        for(int elem: nums)
            if(elem == original)
                original *= 2;
        return original;
    }
}