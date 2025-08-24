class Solution {
    public int[] maxValue(int[] nums) {
        int [] ans = new int[nums.length];
        int[] prefix_max = new int[nums.length];
        int[] suffix_min = new int[nums.length];
        prefix_max[0] = nums[0];
        suffix_min[nums.length - 1] = nums[nums.length - 1];

        for(int i = 1, j = nums.length - 2; i < nums.length && j >= 0; i++, j--){
            prefix_max[i] = Math.max(prefix_max[i - 1], nums[i]);
            suffix_min[j] = Math.min(suffix_min[j + 1],nums[j]);
        }

        ans[nums.length - 1] = prefix_max[nums.length - 1];
        for(int i = nums.length - 2; i >= 0; i--){
            ans[i] = prefix_max[i];
            if(prefix_max[i] > suffix_min[i + 1])
                ans[i] = Math.max(ans[i], ans[i+1]);
        }

        return ans;
    }
}