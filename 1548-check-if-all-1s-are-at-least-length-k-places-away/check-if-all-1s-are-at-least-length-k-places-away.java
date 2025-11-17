class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int diff = 0;
        int l = -1;

        for(int i = 0; i < nums.length; i++) {
            System.out.println("i: " + i + " l: " + l + " diff: " + diff);
            if(nums[i] == 1 && l != -1) {
                diff = i - l - 1;
                if(diff < k)
                    return false;
                else
                    l = i;
            } else if(nums[i] == 1 && l == -1) {
                l = i;
            }
        }

        return true;
    }
}