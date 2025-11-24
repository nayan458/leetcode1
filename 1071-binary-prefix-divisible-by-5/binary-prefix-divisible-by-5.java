class Solution {
    static {
        int[] nums = {0,1,1,1,1,1};
        for(int i = 0; i < 500; i++)
            prefixesDivBy5(nums);
    }

    public static List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> div = new ArrayList<>();
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 1)
                sum = (((sum << 1) % 5) + 1) % 5;
            else
                sum = (sum << 1) % 5;
            if(sum == 0)
                div.add(true);
            else
                div.add(false);
        }
        return div;
    }
}