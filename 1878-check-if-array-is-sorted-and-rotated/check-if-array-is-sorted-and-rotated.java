class Solution {
    public boolean check(int[] nums) {
        if(nums.length == 1) return true;
        int drop = 0;
        int left = nums[0];
        int right = nums[nums.length - 1];

        for(int i = 1; i < nums.length; i++){
            int elem = nums[i];
            if(elem < left) drop++;
            if(drop > 1) return false;
            left = elem;
        }
        left = nums[0];

        return drop == 1 ? (right <= left) : true;
    }
}