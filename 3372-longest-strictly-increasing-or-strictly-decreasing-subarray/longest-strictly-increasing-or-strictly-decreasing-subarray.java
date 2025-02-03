class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int max = 1,i = 0, currentMax = 1, state = -1;
        while(i < (nums.length -1)) {
            if(nums[i] > nums[i+1]){
                if( state == 1)
                    ++currentMax;
                else {
                    state = 1;
                    max = Math.max(currentMax,max);
                    currentMax = 2;
                }
            } else if(nums[i] < nums[i+1]){
                if( state == 2)
                    ++currentMax;
                else {
                    state = 2;
                    max = Math.max(currentMax,max);
                    currentMax = 2;
                }
            } else {
               
                    state = 0;
                    max = Math.max(currentMax,max);
                    currentMax = 0;
            }
            System.out.println(state);
            ++i;
        }
        return Math.max(max,currentMax);
    }
}