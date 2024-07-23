class Solution {
    public int removeDuplicates(int[] nums) {
        int unique = 1, n = nums.length, l = 0, r = 0;
        if(n == 1)
            return 1;
        int element = nums[l];
        for(int i = 1; i < n; i++){
            if(element == nums[i])
                continue;
            element = nums[i];
            nums[++l] = element;
            ++unique;
        }
        return unique;
    }
}